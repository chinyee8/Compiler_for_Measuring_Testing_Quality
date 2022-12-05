package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.tree.ParseTree;

import AntlrToObject.AntlrToProgram;
import Operations.AllCUsesCoverage;
import Operations.AllDefCoverage;
import Operations.ConditionCoverage;
import Operations.ErrorListener;
import Operations.Original;
import Operations.PrettyPrinter;
import Operations.Statement;
import Operations.Testcase;
import antlr.exprLexer;
import antlr.exprParser;
import antlr.exprParser.ProgramContext;
import model.MethodCall;
import model.Program;
import model.Values;

public class ExpressionApp {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.print("file name");
		}
		else {
			String fileName = args[0];
			exprParser parser =getParser(fileName);
			ParseTree progAST = parser.prog();

			String fileName2 = args[1];
			exprParser parser2 =getParser(fileName2);
			ParseTree testAST = parser2.prog();

			if(ErrorListener.hasError) {

			}
			else {
				AntlrToProgram progVisitor = new AntlrToProgram();
				Program prog = progVisitor.visit(progAST);

				AntlrToProgram testVisitor = new AntlrToProgram();
				Program testProg = testVisitor.visit(testAST);

				if (progVisitor.semanticErrors.isEmpty() && testVisitor.semanticErrors.isEmpty()) {

					if(prog.gameclass != null && testProg.testcase != null) {
						ArrayList<Program> programList = new ArrayList<>();
						Map<Program, MethodCall> programList2 = new LinkedHashMap<>();

						//devCoverage
						Map<Program, MethodCall> defProgram = new LinkedHashMap<>();
						List<String> errors = new ArrayList<>();
						boolean containErrors = false;

						//						for(Map.Entry<MethodCall, Map<String, Values>> t : testProg.testcase.allMethodCalls.entrySet()) {
						//
						//							AntlrToProgram progControllor = new AntlrToProgram(t.getKey(), t.getValue(), testProg.testcase.methodCallParamOrder.get(t.getKey())); //pass in methodcall, input parameters, and order of input parameters
						//
						//							Program prog2 = progControllor.control((ProgramContext)progAST);
						//							if(progControllor.semanticErrors.size()>0) {
						//								containErrors = true;
						//
						//							}
						//							programList.add(prog2);
						//							programList2.put(prog2, t.getKey());
						//						}


//						//Statement Coverage
//						AntlrToProgram testV1 = new AntlrToProgram();
//						Program testp1 = testV1.testControl((ProgramContext)testAST, progAST, progVisitor.global_methods, "statement", testProg.testcase.methodCallParamOrder);
//
//						int i = 0;
//						for(Program p : testV1.progReturn) {
//							if(i == 0) {
//								programList.add(p);
//							}
//							programList2.put(p, testV1.testKey.get(i));
//							i++;
//						}

						// Condition coverage
						ConditionCoverage condCov = new ConditionCoverage();							
						AntlrToProgram progCondComp = new AntlrToProgram(condCov);
						progCondComp.visitConditionCoverage((ProgramContext)progAST); // for addCompoenent

						condCov.setComponentState(false); // now adding result state

						/*for(Map.Entry<MethodCall, Map<String, Values>> t : testProg.testcase.allMethodCalls.entrySet()) {
							//AntlrToProgram progCond = new AntlrToProgram(t.getKey(), t.getValue(), condCov);
							condCov.setTestMethod(t);
							
							ArrayList<String> list = new ArrayList<>();
							for(Entry<MethodCall, List<String>> e : testProg.testcase.methodCallParamOrder.entrySet()) {
								if(e.getKey().getName().equals(t.getKey().getName())) {
									list.addAll(e.getValue());
								}
							}
							condCov.setMethodCallParamOrder(list);

							AntlrToProgram progCond = new AntlrToProgram(condCov);
							progCond.visitConditionCoverage((ProgramContext)progAST);	 // for addResult						
						}*/
						// End of Condition Coverage
						
						//DefCoverage
						AntlrToProgram testV = new AntlrToProgram(condCov);
						Program testp = testV.testControl((ProgramContext)testAST, progAST, progVisitor.global_methods, "", testProg.testcase.methodCallParamOrder);

						int i = 0;
						for(Program p : testV.progReturn) {
							defProgram.put(p, testV.testKey.get(i));
							if(i == 0) {
								programList.add(p);
							}
							if(testV.semanticErrors.size()>0) {
								containErrors = true;
								for(String e : testV.semanticErrors) {
									if(!errors.contains(e)) {
										errors.add(e);
									}
								}
							}
							i++;
						}

						if(containErrors) {
							
							for(String err: errors) {
								System.out.println(err);
							}
						}
						else {
							
							
							Original ori = new Original(programList);
							Testcase test = new Testcase(testp, testV);
							Statement st = new Statement(defProgram);
							condCov.setProgramList(programList); // condition coverage for html

							AllDefCoverage alldef = new AllDefCoverage(defProgram);
							AllCUsesCoverage allc = new AllCUsesCoverage(defProgram);
							AllPUsesCoverage allp = new AllPUsesCoverage(defProgram);

							PrettyPrinter printer = new PrettyPrinter(testProg.testcase.allMethodCalls);
							printer.addOriginal(ori);
							printer.addStatement(st);
							printer.addAllDefCoverage(alldef);
							printer.addAllCUseCoverage(allc);
							printer.addAllPUseCoverage(allp);
							printer.addCondCoverage(condCov);
							printer.addTest(test);

							printer.prettyPrint();
						}

					}else {
						System.err.println("Error: please input game file first, before test file!");
					}

				}
				else {
					List<String> errors = new ArrayList<>();
					for(String e : progVisitor.semanticErrors) {
						if(!errors.contains(e)) {
							errors.add(e);
						}
					}
					
					for(String e : testVisitor.semanticErrors) {
						if(!errors.contains(e)) {
							errors.add(e);
						}
					}
					
					for(String err: errors) {
						System.out.println(err);
					}
					
				}	


			}


		}
	}

	private static exprParser getParser(String fileName) {
		exprParser parser = null;

		try {
			CharStream input = CharStreams.fromFileName(fileName);			
			exprLexer lexer = new exprLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new exprParser(tokens);

			parser.removeErrorListeners();
			parser.addErrorListener(new ErrorListener());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parser;



	}

}
