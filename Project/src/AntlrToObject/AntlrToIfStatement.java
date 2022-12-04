package AntlrToObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import Operations.ConditionCoverage;
import antlr.exprBaseVisitor;
import antlr.exprParser.IfStatementContext;
import antlr.exprParser.MyMethodBodyContext;
import model.Addition;
import model.CondBool;
import model.CondEqual;
import model.CondNotEqual;
import model.CondParenthesis;
import model.CondVarName;
import model.Condition;
import model.Conjunction;
import model.Disjunction;
import model.Division;
import model.EqualTo;
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
import model.Negation;
import model.NotEqualTo;
import model.Subtraction;
import model.ValueBool;
import model.ValueDouble;
import model.ValueNum;
import model.Values;
public class AntlrToIfStatement extends exprBaseVisitor<IfStatement>  {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public List<MyMethods> global_mymethods;
	public HashMap<String, Values> local_methodVar;
	
	//DefCoverage
	public Map<String, String> def;
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public List<String> lines;
	public int totalNotUsed;
	
	// Condition Coverage
	public ConditionCoverage condCov;

	public AntlrToIfStatement(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, HashMap<String, Values> local_methodVar) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.local_methodVar = local_methodVar;
	}
	
	//defCoverage
	public AntlrToIfStatement(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, MethodCall t_method_call, Map<String, Values> inputValues, HashMap<String, Values> local_methodVar) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.local_methodVar = local_methodVar;
	}

	// Condition Coverage
	public AntlrToIfStatement(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, HashMap<String, Values> local_methodVar, ConditionCoverage condCov) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.local_methodVar = local_methodVar;
		this.condCov = condCov;
	}
	
	// Condition Coverage
	public void visitConditionCoverage(IfStatementContext ctx) {
		AntlrToCondition ifCondVisitor = new AntlrToCondition(semanticErrors, this.variableMap, condCov);
		String strIfStatement = ctx.getChild(0).getText() + ctx.getChild(1).getText() + ctx.getChild(2).getText() + ctx.getChild(3).getText();
		condCov.setIfStatString(strIfStatement);
		
		if (!condCov.isComponentState() && condCov.isCalledMethod()) {
			condCov.resetResultString();
		}
		ifCondVisitor.visit(ctx.cond());
		if (!condCov.isComponentState() && condCov.isCalledMethod()) {
			condCov.addResult();
		}
		AntlrToMyMethodBody ifBodyVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.global_mymethods, condCov);
		ifBodyVisitor.visitConditionCoverage((MyMethodBodyContext) ctx.getChild(5)); // inside if body
		ifBodyVisitor.visitConditionCoverage((MyMethodBodyContext) ctx.getChild(9)); // inside else body

	}
	
	@Override
	public IfStatement visitIfStatement(IfStatementContext ctx) {
		Token token = ctx.start;
		int line = token.getLine();
		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors, this.variableMap);
		Condition cond = condVisitor.visit(ctx.cond());

		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors,this.variableMap, this.global_mymethods, this.local_methodVar);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.getChild(5));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.getChild(9));

		return new IfStatement(cond,ifBody,elseBody, semanticErrors, line);

	}

	
	public IfStatement control(IfStatementContext ctx) {
		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors, this.variableMap);
		Condition cond = condVisitor.visit(ctx.cond());

		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors,this.variableMap, this.global_mymethods, this.local_methodVar);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.getChild(5));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.getChild(9));

		
		IfStatement temp = new IfStatement(cond,ifBody,elseBody, semanticErrors, 0);
		boolean ifEvaluator = evaluated(cond, variableMap);
		if(ifEvaluator) {
			AntlrToMyMethodBody BodyController = new AntlrToMyMethodBody(this.semanticErrors, this.variableMap, this.global_mymethods, this.local_methodVar);
			MyMethodBody newIfBody = BodyController.control((MyMethodBodyContext) ctx.getChild(5));
			IfStatement result = new IfStatement(cond, newIfBody, elseBody, semanticErrors, 0);
			result.ifCovered = true;
			return result;
		}
		else {
			AntlrToMyMethodBody BodyController = new AntlrToMyMethodBody(this.semanticErrors, this.variableMap, this.global_mymethods, this.local_methodVar);
			MyMethodBody newElseBody = BodyController.control((MyMethodBodyContext) ctx.getChild(9));
			IfStatement result = new IfStatement(cond, ifBody, newElseBody, semanticErrors, 0);
			result.elseCovered = true;
			return result;
		}
	}

	public IfStatement defControl(IfStatementContext ctx) {
		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors, this.variableMap);
		Condition cond = condVisitor.visit(ctx.cond());

		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues, this.local_methodVar);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.getChild(5));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.getChild(9));

		return new IfStatement(cond,ifBody,elseBody, semanticErrors, 0);
	}
	
	private double getMATHDOUBLE(Mathematics m) {
		double result = 0.00;
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			if(right == 0) {
				semanticErrors.add("Error: undefined. Cannot divide by 0");
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMATHDOUBLE(a.math);
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(variableMap.containsKey(a.varName) && variableMap.get(a.varName) instanceof ValueDouble) {
				result = ((ValueDouble)variableMap.get(a.varName)).getNum();
			}
		}

		return result;		
	}

	private int getMathINT(Mathematics m) {
		int result = 0;

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			if(right == 0) {
				if(!semanticErrors.contains("Error: undefined. Cannot divide by 0")) {
					semanticErrors.add("Error: undefined. Cannot divide by 0");
				}
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMathINT(a.math);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(variableMap.containsKey(a.varName) && variableMap.get(a.varName) instanceof ValueNum) {
				result = ((ValueNum)variableMap.get(a.varName)).getNum();
			}
		}

		return result;
	}

	private String getCondType(Condition c) {
		String result = "";

		if(c instanceof Negation) {
			Negation e = (Negation) c;
			result = getCondType(e.cond);
		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			result = getCondType(e.cond);
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			String left = getCondType(e.cond1);
			String right = getCondType(e.cond2);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			String left = getCondType(e.cond1);
			String right = getCondType(e.cond2);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			String left = getCondType(e.cond1);
			String right = getCondType(e.cond2);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}		
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			String left = getCondType(e.left);
			String right = getCondType(e.right);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
			result = "BOOLEAN";
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			if(getMATHTYPE(e.left).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.left.toString() + " is not the same");
			}else if(getMATHTYPE(e.right).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.right.toString() + " is not the same");
			}else if(!getMATHTYPE(e.left).equals(getMATHTYPE(e.right))){
				semanticErrors.add("Error: " + e.left + " must have the same datatype as " + e.right);
			}
			result = "BOOLEAN";
		}else if(c instanceof More) {
			More e = (More) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof Less) {
			Less e = (Less) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			if(!variableMap.containsKey(e.varName)) {
				semanticErrors.add("Error: variable " + e.varName + " does not exist");
			}else {
				Values val = variableMap.get(e.varName);

				if(val.getType().equals("BOOLEAN")) {
					result = val.getType();
				}else {
					semanticErrors.add("Error: " + e.varName + " must be BOOLEAN type");
				}
			}

		}

		return result;
	}

	private String getMATHTYPE(Mathematics m) {
		String result = "";

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Division) {
			Division a = (Division) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMATHTYPE(a.math);
		}else if(m instanceof MathNumber) {
			result = "INT";
		}else if(m instanceof MathDouble) {
			result = "DOUBLE";
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(!variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error: variable " + a.varName + " is not declared");
			}else if(variableMap.containsKey(a.varName)) {
				result = variableMap.get(a.varName).getType();
			}
		}

		return result;
	}

	public boolean evaluated(Condition c, Map<String, Values> map) {
		boolean result = false;

		if(c instanceof Negation) {
			Negation e = (Negation) c;
			result = !(evaluated(e.cond, map));

		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			result = evaluated(e.cond, map);
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			boolean left = evaluated(e.cond1, map);
			boolean right = evaluated(e.cond2, map);
			result = left && right;
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			boolean left = evaluated(e.cond1, map);
			boolean right = evaluated(e.cond2, map);
			result = left || right;
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			boolean left = evaluated(e.cond1, map);
			boolean right = evaluated(e.cond2, map);
			result = left == right;
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			boolean left = evaluated(e.left, map);
			boolean right = evaluated(e.right, map);
			result = left != right;
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
			result = e.bool;
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left == right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left == right;
			}
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left != right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left != right;
			}
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left >= right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left >= right;
			}
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			if(getMATHTYPE(e.left).equals("INT")) {
				int left = getMathINT(e.left);
				int right = getMathINT(e.right);
				result = left <= right;
			}else if(getMATHTYPE(e.left).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.left);
				double right = getMATHDOUBLE(e.right);
				result = left <= right;
			}
		}else if(c instanceof More) {
			More e = (More) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left > right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left > right;
			}
		}else if(c instanceof Less) {
			Less e = (Less) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left < right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left < right;
			}
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			if(map.containsKey(e.varName)) {
				Values val = map.get(e.varName);
				if(val.getType().equals("BOOLEAN")) {
					result = ((ValueBool)val.getValues()).value;
				}
			}
		}

		return result;
	}

	
}
