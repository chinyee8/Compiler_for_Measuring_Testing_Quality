package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.VoidMethodCallContext;
import model.Assignment;
import model.Declaration;
import model.Expr;
import model.IfStatement;
import model.MethodCall;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.ReturnMethodCall;
import model.Values;
import model.VoidMethodCall;

public class AntlrToMyMethodBody extends exprBaseVisitor<MyMethodBody>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public HashMap<String, Values> local_methodvar;
	public List<MyMethods> global_mymethods;
	public List<Declaration> decl;
	public List<Assignment> assi;
	public List<IfStatement> ifstatement;

	public AntlrToMyMethodBody(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.local_methodvar = new HashMap<>();

	}

	public AntlrToMyMethodBody(List<String> semanticErrors, HashMap<String, Values> variableMap,
			List<MyMethods> global_mymethods, HashMap<String, Values> local_methodVar) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.local_methodvar = local_methodVar;
	}

	@Override
	public MyMethodBody visitMyMethodBody(MyMethodBodyContext ctx) {
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<IfStatement> ifstatement = new ArrayList<>();
		List<MethodCall> methodCall = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap, this.global_mymethods);
		AntlrToMethodCall methodcallVisitor = new AntlrToMethodCall(semanticErrors, this.variableMap);

		this.local_methodvar.putAll(variableMap);
		
		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
			local_methodvar.put(decl.get(i).varName, decl.get(i).defaultValue);
		}

		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}
		
		AntlrToIfStatement ifVisitor = new AntlrToIfStatement(semanticErrors, this.variableMap, this.global_mymethods, local_methodvar);
		for(int i = 0; i < ctx.if_statement().size(); i++){
			  ifstatement.add(ifVisitor.visit(ctx.if_statement(i)));
		}

		for(int i = 0; i < ctx.getChildCount(); i++) { 
			 if(ctx.getChild(i) instanceof ReturnMethodCallContext 
					|| ctx.getChild(i) instanceof VoidMethodCallContext) {
				methodCall.add(methodcallVisitor.visit(ctx.getChild(i)));
			}
		}
		
		this.decl = decl;
		this.assi = assi;
		this.ifstatement = ifstatement;
		//methodcall?
		
		for(Assignment i: assi) {
			if(local_methodvar.containsKey(i.varName)) {
				//At Values to variableMap for both r_method_call and value
				if(checkIfAssignmentTypeMatchesRHS(i, i.expr, this.local_methodvar)) {
					if(i.expr instanceof Values) {
						local_methodvar.put(i.varName, ((Values)i.expr).getValues());
					}else if(i.expr instanceof ReturnMethodCall) {
//						local_methodvar.put(i.varName, ((ReturnMethodCall)i.expr));
						
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

		return new MyMethodBody(decl, assi, ifstatement, methodCall);

	}
	
	private boolean checkIfMyMethodContainsReturnMethodCall(ReturnMethodCall r, List<MyMethods> mymethod) {
		for(MyMethods i: mymethod) {
			if(i.methodName.equals(r.methodName)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkIfAssignmentTypeMatchesRHS(Assignment a, Expr rhs, HashMap<String, Values> var) {
		String type = "";
		for(Map.Entry<String, Values> d: var.entrySet()) { //find dec type from declarations of game body
			if(d.getKey().equals(a.varName)) {
				type = d.getValue().getType();
			}
		}
		if(rhs instanceof VoidMethodCall ) {
			return false;
		}
		else if(rhs instanceof Values) {
			if(((Values) rhs).getType().equals(type)) {
				return true; //need to get type for "MATH" -->ValueMath
			}else if(((Values)rhs).getType().equals("MATH")) {
				if(type.equals("INT") || type.equals("DOUBLE")) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		else if(rhs instanceof ReturnMethodCall) {
			if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, this.global_mymethods)) { //if rhs methodcall is declared 
				String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
				for(MyMethods m: this.global_mymethods) { //grab method from DeclaredMethodsList, find matching method, check for return data type against type
					if(m.methodName.equals(rhsMethodName)) {

						List<String> RHSparams = ((ReturnMethodCall)rhs).call_parameter.getCallParams();
						Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
						if(RHSparams.size() != methodparams.size()) {
							semanticErrors.add("Error: " + ((ReturnMethodCall)rhs).toString() + " must have the same number of parameters as mymethod " + m.methodName);
						}else {
							int i = 0;
							for(Map.Entry<String, String> map: methodparams.entrySet()){
								if(!(this.local_methodvar.get(RHSparams.get(i)).getType().equals(map.getValue()))){
									semanticErrors.add("Error: dataType of " + RHSparams.get(i) + " in " +  ((ReturnMethodCall)rhs).toString() + " is not the same as dataType of " + map.getKey() + " in mymethod" + m.methodName);
								}
								i++;
							}
						}

						if(m.methodType instanceof MyReturnMethod) {
							return ((MyReturnMethod)m.methodType).dataType.equals(type);
						}
						else { 						//if m.methodType instanceof MyVoidMethod it would have been detected earlier ignore else case
							System.out.println("void type checking error");
							return false;
						}
					}
				}
				return false;
			}
			else { //if method not declared
				this.semanticErrors.add("Return Method Call on RHS is not declared: " + a.varName + " cannot be assigned to: " + rhs.toString());
				return false;
			}
		}
		else return false;
	}
	
	
}
