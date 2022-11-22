package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.IfStatementContext;
import antlr.exprParser.Method_bodyContext;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.VoidMethodCallContext;
import model.Addition;
import model.Assignment;
import model.CondBool;
import model.CondEqual;
import model.CondNotEqual;
import model.CondParenthesis;
import model.CondVarName;
import model.Condition;
import model.Conjunction;
import model.Declaration;
import model.Disjunction;
import model.Division;
import model.EqualTo;
import model.Expr;
import model.IfStatement;
import model.Less;
import model.LessOrEqual;
import model.MathDouble;
import model.MathNumber;
import model.MathParenthesis;
import model.MathVarName;
import model.Mathematics;
import model.MethodCall;
import model.More;
import model.MoreOrEqual;
import model.Multiplication;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Negation;
import model.NotEqualTo;
import model.ReturnMethodCall;
import model.Subtraction;
import model.ValueDouble;
import model.ValueMath;
import model.ValueNum;
import model.Values;
import model.VoidMethodCall;

public class AntlrToMyMethodBody extends exprBaseVisitor<MyMethodBody> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public HashMap<String, Values> local_methodvar;
	public List<MyMethods> global_mymethods;
	public List<Declaration> decl;
	public List<Assignment> assi;
	public List<IfStatement> ifstatement;
	public List<MethodCall> methodcall;
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public Values returnValue;
	
	public AntlrToMyMethodBody(List<String> semanticErrors, HashMap<String, Values> variableMap,
			List<MyMethods> global_mymethods) {
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

	public AntlrToMyMethodBody(HashMap<String, Values> variableMap, Values returnValue, List<MyMethods>global_mymethods) {
		this.variableMap = variableMap;
		this.returnValue = returnValue;
		this.global_mymethods = global_mymethods;
		this.local_methodvar = new HashMap<>();
}

	@Override
	public MyMethodBody visitMyMethodBody(MyMethodBodyContext ctx) {
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<IfStatement> ifstatement = new ArrayList<>();
		List<MethodCall> methodcall = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap, this.global_mymethods);
		AntlrToMethodCall methodcallVisitor = new AntlrToMethodCall(semanticErrors, this.variableMap);

		this.local_methodvar.putAll(variableMap);

		for (int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
		}

		for (int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}

		AntlrToIfStatement ifVisitor = new AntlrToIfStatement(semanticErrors, this.variableMap, this.global_mymethods,
				local_methodvar);
		for (int i = 0; i < ctx.if_statement().size(); i++) {
			ifstatement.add(ifVisitor.visit(ctx.if_statement(i)));
		}

		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i) instanceof VoidMethodCallContext
					|| ctx.getChild(i) instanceof ReturnMethodCallContext) {
				methodcall.add(methodcallVisitor.visit(ctx.getChild(i)));
			}
		}

		this.decl = decl;
		this.assi = assi;
		this.ifstatement = ifstatement;
		this.methodcall = methodcall;


//		for(Assignment i: assi) {
//			if(local_methodvar.containsKey(i.varName)) {
//				//At Values to variableMap for both r_method_call and value
//				if(checkIfAssignmentTypeMatchesRHS(i, i.expr, this.local_methodvar)) {
//					if(i.expr instanceof Values) {
//						if(((Values)i.expr) instanceof ValueMath) {
//							
//							
//						}else{
//							local_methodvar.put(i.varName, ((Values)i.expr).getValues());
//						}
//					}else if(i.expr instanceof ReturnMethodCall) {
//						//						local_methodvar.put(i.varName, ((ReturnMethodCall)i.expr));
//
//					}
//				}
//				else {
//					this.semanticErrors.add("Error: variable " + i.varName + " return type does not match expression return type.");
//				}
//			}
//			else {
//				//report semantic error uninitialized var
//				this.semanticErrors.add("Error: variable " + i.varName + " is not declared.");
//			}
//		}
//
//		for(IfStatement i : ifstatement) {
//			if(getCondType(i.cond).equals("NO")) {
//				if(!semanticErrors.contains("Error: condition " + i.cond.toString() + " error. LHS and RHS must match")){
//					semanticErrors.add("Error: condition " + i.cond.toString() + " error. LHS and RHS must match");
//				}
//			}
//			for(Declaration d: i.getIfBody().declList) {
//				if(local_methodvar.containsKey(d.varName)) {
//					if(!semanticErrors.contains("Error: " + d.varName + " has been declared")){
//						semanticErrors.add("Error: " + d.varName + " has been declared");
//					}
//				}
//			}
//		}
//		
//		if(this.global_mymethods != null) {
//			List<String> global_methodname = new ArrayList<>();
//			for(MyMethods m : global_mymethods) {
//				if(m.methodType instanceof MyVoidMethod) {
//					global_methodname.add(m.methodName);
//				}
//			}
//			
//			for(MethodCall v : methodcall) {
//				if(v instanceof VoidMethodCall) {
//					if(!global_methodname.contains(((VoidMethodCall)v).methodname)) {
//						if(!semanticErrors.contains("Error: " + ((VoidMethodCall)v).methodname + " does not exist")){
//							semanticErrors.add("Error: " + ((VoidMethodCall)v).methodname + " does not exist");
//						}
//					}
//				}else if(v instanceof ReturnMethodCall) {
//					if(global_methodname.contains(((ReturnMethodCall)v).methodName)) {
//						if(!semanticErrors.contains("Error: " + ((ReturnMethodCall)v).methodName + " is not a void method call")){
//							semanticErrors.add("Error: " + ((ReturnMethodCall)v).methodName + " is not a void method call");
//						}
//					}
//				}
//				
//			}
//		}

//		}

		return new MyMethodBody(decl, assi, ifstatement, methodcall, global_mymethods);

	}

	public MyMethodBody control(MyMethodBodyContext ctx) {
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<IfStatement> ifstatement = new ArrayList<>();
		List<MethodCall> methodcall = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap, this.global_mymethods);
		AntlrToMethodCall methodcallVisitor = new AntlrToMethodCall(semanticErrors, this.variableMap);

		this.local_methodvar.putAll(variableMap);

		for (int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.control((DeclarationContext)ctx.decl(i)));
			decl.get(i).covered = true;
			this.variableMap.put(decl.get(i).varName, decl.get(i).defaultValue);
		}

		for (int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.control((AssignmentContext)ctx.assi(i)));
			assi.get(i).covered = true;
			this.variableMap.put(assi.get(i).varName, (Values)assi.get(i).expr);//MONICA_fix later - temporarily add cast for expr, returnmethodcall not accountedfor
		}

		AntlrToIfStatement ifVisitor = new AntlrToIfStatement(semanticErrors, this.variableMap, this.global_mymethods,
				local_methodvar);
		for (int i = 0; i < ctx.if_statement().size(); i++) {
			ifstatement.add(ifVisitor.control((IfStatementContext) ctx.if_statement(i))); //monica stop1
		}
		for(int i = 0; i < ctx.assi().size(); i++) { //add return methodcalls from assign into list of methodcall
			if(ctx.assi(i).getChild(2) != null && ctx.assi(i).getChild(2) instanceof ReturnMethodCallContext) {
				methodcall.add(methodcallVisitor.visit(ctx.assi(i).getChild(2)));
			}
		}
		
		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i) instanceof VoidMethodCallContext
					|| ctx.getChild(i) instanceof ReturnMethodCallContext) {
				methodcall.add(methodcallVisitor.visit(ctx.getChild(i))); //add void methodcalls into list of methodcall
			}
		}

		this.decl = decl;
		this.assi = assi;
		this.ifstatement = ifstatement;
		this.methodcall = methodcall;
		return new MyMethodBody(decl, assi, ifstatement, methodcall, global_mymethods);
	}

//	private boolean checkIfMyMethodContainsReturnMethodCall(ReturnMethodCall r, List<MyMethods> mymethod) {
//		for(MyMethods i: mymethod) {
//			if(i.methodName.equals(r.methodName)) {
//				return true;
//			}
//		}
//		return false;
//	}

//	private boolean checkIfAssignmentTypeMatchesRHS(Assignment a, Expr rhs, HashMap<String, Values> var) {
//		String type = "";
//		for(Map.Entry<String, Values> d: var.entrySet()) { //find dec type from declarations of game body
//			if(d.getKey().equals(a.varName)) {
//				type = d.getValue().getType();
//			}
//		}
//		if(rhs instanceof VoidMethodCall ) {
//			return false;
//		}
//		else if(rhs instanceof Values) {
//			if(((Values) rhs).getType().equals(type)) {
//				return true; //need to get type for "MATH" -->ValueMath
//			}else if(((Values)rhs).getType().equals("MATH")) {
//				if(type.equals("INT") || type.equals("DOUBLE")) {
//					return true;
//				}else {
//					return false;
//				}
//			}else {
//				return false;
//			}
//		}
//		else if(rhs instanceof ReturnMethodCall) {
//			if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, this.global_mymethods)) { //if rhs methodcall is declared 
//				String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
//				for(MyMethods m: this.global_mymethods) { //grab method from DeclaredMethodsList, find matching method, check for return data type against type
//					if(m.methodName.equals(rhsMethodName)) {
//
//						List<String> RHSparams = ((ReturnMethodCall)rhs).call_parameter.getCallParams();
//						Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
//						if(RHSparams.size() != methodparams.size()) {
//							semanticErrors.add("Error: " + ((ReturnMethodCall)rhs).toString() + " must have the same number of parameters as mymethod " + m.methodName);
//						}else {
//							int i = 0;
//							for(Map.Entry<String, String> map: methodparams.entrySet()){
//								if(!(this.local_methodvar.get(RHSparams.get(i)).getType().equals(map.getValue()))){
//									semanticErrors.add("Error: dataType of " + RHSparams.get(i) + " in " +  ((ReturnMethodCall)rhs).toString() + " is not the same as dataType of " + map.getKey() + " in mymethod" + m.methodName);
//								}
//								i++;
//							}
//						}
//
//						if(m.methodType instanceof MyReturnMethod) {
//							return ((MyReturnMethod)m.methodType).dataType.equals(type);
//						}
//						else { 						//if m.methodType instanceof MyVoidMethod it would have been detected earlier ignore else case
//							System.out.println("void type checking error");
//							return false;
//						}
//					}
//				}
//				return false;
//			}
//			else { //if method not declared
//				this.semanticErrors.add("Return Method Call on RHS is not declared: " + a.varName + " cannot be assigned to: " + rhs.toString());
//				return false;
//			}
//		}
//		else return false;
//	}
//
//
//	private String getCondType(Condition c) {
//		String result = "";
//
//		if(c instanceof Negation) {
//			Negation e = (Negation) c;
//			result = getCondType(e.cond);
//		}else if(c instanceof CondParenthesis) {
//			CondParenthesis e = (CondParenthesis) c;
//			result = getCondType(e.cond);
//		}else if(c instanceof Conjunction) {
//			Conjunction e = (Conjunction) c;
//			String left = getCondType(e.cond1);
//			String right = getCondType(e.cond2);
//			if(left.equals(right)) {
//				result = left;
//			}else {
//				result = "NO";
//			}
//		}else if(c instanceof Disjunction) {
//			Disjunction e = (Disjunction) c;
//			String left = getCondType(e.cond1);
//			String right = getCondType(e.cond2);
//			if(left.equals(right)) {
//				result = left;
//			}else {
//				result = "NO";
//			}
//		}else if(c instanceof EqualTo) {
//			EqualTo e = (EqualTo) c;
//			String left = getCondType(e.cond1);
//			String right = getCondType(e.cond2);
//			if(left.equals(right)) {
//				result = left;
//			}else {
//				result = "NO";
//			}		
//		}else if(c instanceof NotEqualTo) {
//			NotEqualTo e = (NotEqualTo) c;
//			String left = getCondType(e.left);
//			String right = getCondType(e.right);
//			if(left.equals(right)) {
//				result = left;
//			}else {
//				result = "NO";
//			}
//		}else if(c instanceof CondBool) {
//			CondBool e = (CondBool) c;
//			result = "BOOLEAN";
//		}else if(c instanceof CondEqual) {
//			CondEqual e = (CondEqual) c;
//			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
//			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
//			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
//				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
//			}
//			result = "BOOLEAN";
//		}else if(c instanceof CondNotEqual) {
//			CondNotEqual e = (CondNotEqual) c;
//			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
//			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
//			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
//				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
//			}
//			result = "BOOLEAN";
//		}else if(c instanceof MoreOrEqual) {
//			MoreOrEqual e = (MoreOrEqual) c;
//			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
//			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
//			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
//				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
//			}
//			result = "BOOLEAN";
//		}else if(c instanceof LessOrEqual) {
//			LessOrEqual e = (LessOrEqual) c;
//			if(getMATHTYPE(e.left).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.left.toString() + " is not the same");
//			}else if(getMATHTYPE(e.right).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.right.toString() + " is not the same");
//			}else if(!getMATHTYPE(e.left).equals(getMATHTYPE(e.right))){
//				semanticErrors.add("Error: " + e.left + " must have the same datatype as " + e.right);
//			}
//			result = "BOOLEAN";
//		}else if(c instanceof More) {
//			More e = (More) c;
//			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
//			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
//			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
//				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
//			}
//			result = "BOOLEAN";
//		}else if(c instanceof Less) {
//			Less e = (Less) c;
//			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
//			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
//				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
//			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
//				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
//			}
//			result = "BOOLEAN";
//		}else if(c instanceof CondVarName) {
//			CondVarName e = (CondVarName) c;
//			Values val = local_methodvar.get(e.varName);
//
//			if(val.getType().equals("BOOLEAN")) {
//				result = val.getType();
//			}else {
//				semanticErrors.add("Error: " + e.varName + " must be BOOLEAN type");
//			}
//		}
//
//		return result;
//	}
//
//	private String getMATHTYPE(Mathematics m) {
//		String result = "";
//
//		if(m instanceof Addition) {
//			Addition a = (Addition) m;
//			String left = getMATHTYPE(a.math1);
//			String right = getMATHTYPE(a.math2);
//			if(left.equals(right)) {
//				result = left;
//			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
//				result = "NOT SAME";
//			}
//		}else if(m instanceof Subtraction) {
//			Subtraction a = (Subtraction) m;
//			String left = getMATHTYPE(a.math1);
//			String right = getMATHTYPE(a.math2);
//			if(left.equals(right)) {
//				result = left;
//			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
//				result = "NOT SAME";
//			}
//		}else if(m instanceof Multiplication) {
//			Multiplication a = (Multiplication) m;
//			String left = getMATHTYPE(a.math1);
//			String right = getMATHTYPE(a.math2);
//			if(left.equals(right)) {
//				result = left;
//			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
//				result = "NOT SAME";
//			}
//		}else if(m instanceof Division) {
//			Division a = (Division) m;
//			String left = getMATHTYPE(a.math1);
//			String right = getMATHTYPE(a.math2);
//			if(left.equals(right)) {
//				result = left;
//			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
//			}
//		}else if(m instanceof MathParenthesis) {
//			MathParenthesis a = (MathParenthesis) m;
//			result = getMATHTYPE(a.math);
//		}else if(m instanceof MathNumber) {
//			result = "INT";
//		}else if(m instanceof MathDouble) {
//			result = "DOUBLE";
//		}else if(m instanceof MathVarName) {
//			MathVarName a = (MathVarName) m;
//			result = a.val.getType();
//		}
//
//		return result;
//	}
	
	
}
