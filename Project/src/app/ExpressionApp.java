package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.tree.ParseTree;

import AntlrToObject.AntlrToProgram;
import Operations.ErrorListener;
import Operations.Evaluator;
import Operations.PrettyPrinter;
import antlr.exprLexer;
import antlr.exprParser;
import antlr.exprParser.ProgramContext;
import model.MethodCall;
import model.Program;
import model.TestMethodCall;
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
						
						for(Map.Entry<MethodCall, Map<String, Values>> t : testProg.testcase.allMethodCalls.entrySet()) {
							
							AntlrToProgram progControllor = new AntlrToProgram(t.getKey(), t.getValue(), testProg.testcase.methodCallParamOrder.get(t.getKey())); //pass in methodcall, input parameters, and order of input parameters
							Program prog2 = progControllor.control((ProgramContext)progAST);
							programList.add(prog2);
						}
						Evaluator ep = new Evaluator(testProg.testcase, prog.gameclass);
						PrettyPrinter printer = new PrettyPrinter(ep);
						printer.prettyPrint();
					}else {
						System.err.println("Error: please input game file first, before test file!");
					}

				}
				else {
					for(String err: progVisitor.semanticErrors) {
						System.out.println(err);
					}
					for(String err: testVisitor.semanticErrors) {
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
