package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.exprBaseVisitor;
import antlr.exprParser.ProgramContext;
import antlr.exprParser.TestCaseContext;
import model.Assignment;
import model.CallParamBoolean;
import model.CallParamChar;
import model.CallParamDouble;
import model.CallParamNum;
import model.CallParamString;
import model.CallParamVarName;
import model.Call_Parameter;
import model.Declaration;
import model.Expr;
import model.Input_List;
import model.MethodCall;
import model.MyMethods;
import model.MyReturnMethod;
import model.Program;
import model.ReturnMethodCall;
import model.TestCase;
import model.TestMethodCall;
import model.ValueBool;
import model.ValueChar;
import model.ValueDouble;
import model.ValueNum;
import model.ValueString;
import model.Values;
import model.VoidMethodCall;

public class AntlrToTestCase extends exprBaseVisitor<TestCase>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	List<Declaration> decl = new ArrayList<>();
	List<Assignment> assi = new ArrayList<>();
	List<TestMethodCall> t_method_call = new ArrayList<>();
	public HashMap<String, Values> testVarMap = new HashMap<>();
	public Map<MethodCall, Map<String, Values>> allMethodCalls = new HashMap<>();
	public Map<MethodCall, List<String>> methodMappedToOrderParameter = new HashMap<>();
	public List<Program> progReturn;
	public List<MethodCall> testKey = new LinkedList<>();

	public AntlrToTestCase(List<String> semanticError, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.progReturn = new LinkedList<>();
		//		this.mymethod = ;
	}
	public AntlrToTestCase() {

	}


	@Override
	public TestCase visitTestCase(TestCaseContext ctx) {
		String testName = ctx.TEST_NAME().getText();
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<TestMethodCall> t_method_call = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap);

		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
			variableMap.put(decl.get(i).varName, decl.get(i).defaultValue);
			this.testVarMap.put(decl.get(i).varName, decl.get(i).defaultValue);
		}

		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
			if(assi.get(i).expr instanceof Values) {
				this.testVarMap.put(assi.get(i).varName, ((Values)assi.get(i).expr).getValues());

			}else if(assi.get(i).expr instanceof ReturnMethodCall) {
				this.allMethodCalls.put((ReturnMethodCall)assi.get(i).expr, new LinkedHashMap<String, Values>());

			}
		}

		AntlrToTestMethodCall testVisitor = new AntlrToTestMethodCall(semanticErrors, this.variableMap);

		for(int i = 0; i < ctx.t_method_call().size() ; i++) {
			t_method_call.add(testVisitor.visit(ctx.t_method_call(i)));
		}

		this.decl = decl;
		this.assi = assi;
		this.t_method_call = t_method_call;

		for(Assignment i: assi) { //after assignment objects are created, loop through to find semantic errors
			if(variableMap.containsKey(i.varName)) {
				//At Values to variableMap for both r_method_call and value
				if(checkIfAssignmentTypeMatchesRHS(i, i.expr, decl)) {
					if(i.expr instanceof Values) {
						variableMap.put(i.varName, ((Values)i.expr).getValues());
					}else if(i.expr instanceof ReturnMethodCall) {
						ReturnMethodCall rmc = ((ReturnMethodCall) i.expr);
						List<Input_List> paramaters = rmc.call_parameter.getTestCallParams(); //this returns an empty list?
						this.methodMappedToOrderParameter.put(rmc, paramaters);
						Map<String, Values> callInputs = new LinkedHashMap<>();
						int num = 0;
						for(Input_List p : paramaters) {
							if(p instanceof CallParamVarName) {
								CallParamVarName a = (CallParamVarName) p;
								if(!testVarMap.containsKey(a.varName)) {
									semanticErrors.add("Error: " + a.varName + " in " + i.expr.toString() + " does not exist");
								}else {
									callInputs.put("" + num, testVarMap.get(a.varName));
								}
							}else if(p instanceof CallParamDouble) {
								CallParamDouble a = (CallParamDouble) p;
								callInputs.put("" + num, new ValueDouble(a.input));		
							}else if(p instanceof CallParamNum) {
								CallParamNum a = (CallParamNum) p;
								callInputs.put("" + num, new ValueNum(a.num));		
							}else if(p instanceof CallParamChar) {
								CallParamChar a = (CallParamChar) p;
								callInputs.put("" + num, new ValueChar(a.input));		
							}else if(p instanceof CallParamString) {
								CallParamString a = (CallParamString) p;
								callInputs.put("" + num, new ValueString(a.input));		
							}else if(p instanceof CallParamBoolean) {
								CallParamBoolean a = (CallParamBoolean) p;
								callInputs.put("" + num, new ValueBool(a.input));		
							}

							num++;
						}
						this.allMethodCalls.put(rmc, callInputs);
					}
				}
				else {
					this.semanticErrors.add("Error: variable " + i.varName + " return type does not match expression return type.");
				}
			}
			else {
				//report semantic error uninitialized var
				this.semanticErrors.add("Error: variable " + i.varName + " is not declared.");
			}
		}

		for(TestMethodCall t : this.t_method_call) {
			Call_Parameter c = t.call_parameter;
			List<String> parameters = c.getCallParams();
			Map<String, Values> callInputs = new HashMap<>();
			for(String s: parameters) {
				if(!testVarMap.containsKey(s)) {
					semanticErrors.add("Error: " + s + " is not declared");
				}else {
					callInputs.put(s, testVarMap.get(s));
				}
			}
			this.allMethodCalls.put(t, callInputs);
		}
		TestCase temp =new TestCase(testName, decl, assi, t_method_call, this.methodMappedToOrderParameter);
		temp.addAll(this.allMethodCalls);

		return temp;
	}

	private boolean checkIfAssignmentTypeMatchesRHS(Assignment a, Expr rhs, List<Declaration> dList) {
		String decType = "";
		for(Declaration d: dList) { //find dec type from declarations of game body
			if(d.varName.equals(a.varName)) {
				decType = d.dataType;
			}
		}
		if(rhs instanceof VoidMethodCall ) {
			return false;
		}
		else if(rhs instanceof Values) {
			if(((Values) rhs).getType().equals(decType)) {
				return true; //need to get type for "MATH" -->ValueMath
			}else if(((Values)rhs).getType().equals("MATH")) {
				if(decType.equals("INT") || decType.equals("DOUBLE")) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		else if(rhs instanceof ReturnMethodCall) {			
			return true;
		}
		else return false;
	}


	//controlflow
	public TestCase control(TestCaseContext ctx) {
		String testName = ctx.TEST_NAME().getText();
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();

		List<TestMethodCall> t_method_call = new ArrayList<>();


		return null;
	}

	public TestCase testcontrol(TestCaseContext ctx, ParseTree progAST, List<MyMethods> global_methods2, String check, Map<MethodCall, List<String>> methodCallParamOrder2) {
		String testName = ctx.TEST_NAME().getText();
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();

		List<TestMethodCall> t_method_call = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap);

		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
			variableMap.put(decl.get(i).varName, decl.get(i).defaultValue);
			this.testVarMap.put(decl.get(i).varName, decl.get(i).defaultValue);
		}

		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
			if(assi.get(i).expr instanceof Values) {
				this.testVarMap.put(assi.get(i).varName, ((Values)assi.get(i).expr).getValues());

			}else if(assi.get(i).expr instanceof ReturnMethodCall) {
				ReturnMethodCall rmc = ((ReturnMethodCall) assi.get(i).expr);
				List<Input_List> paramaters = rmc.call_parameter.getTestCallParams(); //this returns an empty list?
				//						this.methodMappedToOrderParameter.put(rmc, paramaters);
				Map<String, Values> callInputs = new LinkedHashMap<>();
				int num = 0;
				for(Input_List p : paramaters) {
					if(p instanceof CallParamVarName) {
						CallParamVarName a = (CallParamVarName) p;
						callInputs.put("" + num, testVarMap.get(a.varName));
					}else if(p instanceof CallParamDouble) {
						CallParamDouble a = (CallParamDouble) p;
						callInputs.put("" + num, new ValueDouble(a.input));		
					}else if(p instanceof CallParamNum) {
						CallParamNum a = (CallParamNum) p;
						callInputs.put("" + num, new ValueNum(a.num));		
					}else if(p instanceof CallParamChar) {
						CallParamChar a = (CallParamChar) p;
						callInputs.put("" + num, new ValueChar(a.input));		
					}else if(p instanceof CallParamString) {
						CallParamString a = (CallParamString) p;
						callInputs.put("" + num, new ValueString(a.input));		
					}else if(p instanceof CallParamBoolean) {
						CallParamBoolean a = (CallParamBoolean) p;
						callInputs.put("" + num, new ValueBool(a.input));		
					}

					num++;
				}
				this.testKey.add(((ReturnMethodCall)assi.get(i).expr));
				this.testVarMap.put(assi.get(i).varName, getTestValue((ReturnMethodCall)assi.get(i).expr, progAST, global_methods2, callInputs, check, methodCallParamOrder2));
			}
		}

		AntlrToTestMethodCall testVisitor = new AntlrToTestMethodCall(semanticErrors, this.variableMap);

		for(int i = 0; i < ctx.t_method_call().size() ; i++) {
			t_method_call.add(testVisitor.visit(ctx.t_method_call(i)));
		}

		this.decl = decl;
		this.assi = assi;
		this.t_method_call = t_method_call;
		return new TestCase(testName, decl, assi, t_method_call, null);
	}

	private Values getTestValue(ReturnMethodCall rm, ParseTree progAST, List<MyMethods> global_methods2, Map<String, Values> callInputs, String check, Map<MethodCall, List<String>> methodCallParamOrder2) {
		Values result = null;

		if(check.equals("statement")) {
			ArrayList<String> list = new ArrayList<>();
			for(Entry<MethodCall, List<String>> e : methodCallParamOrder2.entrySet()) {
				if(e.getKey().getName().equals(rm.methodName)) {
					list.addAll(e.getValue());
				}
			}
			AntlrToProgram progControllor = new AntlrToProgram(rm, callInputs, list); //pass in methodcall, input parameters, and order of input parameters
			Program prog2 = progControllor.control((ProgramContext)progAST);
			this.progReturn.add(prog2);
			result = progControllor.testValue;

		}else {
			AntlrToProgram devCoverage = new AntlrToProgram(rm, global_methods2, callInputs);
			Program defProg = devCoverage.defControl((ProgramContext)progAST);
			this.progReturn.add(defProg);
			result = devCoverage.testValue;

			if(devCoverage.semanticErrors.size()>0) {
				for(String s: devCoverage.semanticErrors) {
					if(!this.semanticErrors.contains(s)) {
						this.semanticErrors.add(s);
					}
				}
			}
		}


		return result;
	}

	public List<Program> getProgReturn(){
		return this.progReturn;
	}

	public List<MethodCall> getTestKey(){
		return this.testKey;
	}
}
