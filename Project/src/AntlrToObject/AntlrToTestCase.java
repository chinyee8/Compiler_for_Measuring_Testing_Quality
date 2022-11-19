package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antlr.exprBaseVisitor;
import antlr.exprParser.TestCaseContext;
import model.Assignment;
import model.Call_Parameter;
import model.Declaration;
import model.Expr;
import model.MyMethods;
import model.MyReturnMethod;
import model.ReturnMethodCall;
import model.TestCase;
import model.TestMethodCall;
import model.Values;
import model.VoidMethodCall;

public class AntlrToTestCase extends exprBaseVisitor<TestCase>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	List<Declaration> decl = new ArrayList<>();
	List<Assignment> assi = new ArrayList<>();
	List<TestMethodCall> t_method_call = new ArrayList<>();
	
	public AntlrToTestCase(List<String> semanticError, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
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
		AntlrToTestMethodCall testVisitor = new AntlrToTestMethodCall(semanticErrors, this.variableMap);
		
		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
			variableMap.put(decl.get(i).varName, decl.get(i).defaultValue);
		}
		
		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}
		
		for(int i = 0; i < ctx.t_method_call().size() ; i++) {
			t_method_call.add(testVisitor.visit(ctx.t_method_call(i)));
		}
		
		this.decl = decl;
		this.assi = assi;
		this.t_method_call = t_method_call;
		
		for(Assignment i: assi) {
			if(variableMap.containsKey(i.varName)) {
				//At Values to variableMap for both r_method_call and value
				if(checkIfAssignmentTypeMatchesRHS(i, i.expr, decl)) {
					if(i.expr instanceof Values) {
						variableMap.put(i.varName, ((Values)i.expr).getValues());
					}else if(i.expr instanceof ReturnMethodCall) {
						semanticErrors.add("Error: " + i.expr.toString() + " cannot be assigned to " + i.varName);
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
			for(String s: parameters) {
				if(!variableMap.containsKey(s)) {
					semanticErrors.add("Error: " + s + " is not declared");
				}
			}
		}
		
		return new TestCase(testName, decl, assi, t_method_call);
	}
	
//	private boolean checkIfMyMethodContainsReturnMethodCall(ReturnMethodCall r, List<MyMethods> mymethod) {
//		for(MyMethods i: mymethod) {
//			if(i.methodName.equals(r.methodName)) {
//				return true;
//			}
//		}
//		return false;
//	}

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
			return false;
		}
		else return false;
	}

	
	//controlflow
	public TestCase control(TestCaseContext child) {
		// TODO Auto-generated method stub
		return null;
	}
}
