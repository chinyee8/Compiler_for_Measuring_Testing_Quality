package model;

import java.util.HashMap;

import org.antlr.v4.codegen.model.dbg;

public class IfStatement{
	public Condition cond;
	MyMethodBody ifBody;
	MyMethodBody elseBody;
	HashMap<String, Values> variableMap;

	public IfStatement(Condition cond, MyMethodBody ifBody, MyMethodBody elseBody, HashMap<String, Values> variableMap) {
		this.cond = cond;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
		this.variableMap = variableMap;
	}

	public String toString() {
		String result = "";

		result += "jackieAsks [ " + cond.toString() + " ] !\n";
		result += ifBody.toString() + "\n";
		result += "! elseJackie !\n";
		result += elseBody.toString() + "\n";
		result += "!";

		return result;
	}
	
	public MyMethodBody getIfBody() {
		if(evaluated(cond)) {
			return this.ifBody;
		}else {
			return this.elseBody;
		}
	}
	
	public boolean evaluated(Condition c) {
		boolean result = false;
		
		if(c instanceof Negation) {
			Negation e = (Negation) c;
			result = !(evaluated(e.cond));
			
		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			result = evaluated(e.cond);
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			boolean left = evaluated(e.cond1);
			boolean right = evaluated(e.cond2);
			result = left && right;
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			boolean left = evaluated(e.cond1);
			boolean right = evaluated(e.cond2);
			result = left || right;
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			boolean left = evaluated(e.cond1);
			boolean right = evaluated(e.cond2);
			result = left == right;
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			boolean left = evaluated(e.left);
			boolean right = evaluated(e.right);
			result = left != right;
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
			result = e.bool;
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left == right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left == right;
			}
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left != right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left != right;
			}
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left >= right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left >= right;
			}
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			if(getMATHTYPE(e.left).equals("INT")) {
				int left = getInt(e.left);
				int right = getInt(e.right);
				result = left <= right;
			}else if(getMATHTYPE(e.left).equals("DOUBLE")) {
				double left = getDouble(e.left);
				double right = getDouble(e.right);
				result = left <= right;
			}
		}else if(c instanceof More) {
			More e = (More) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left > right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left > right;
			}
		}else if(c instanceof Less) {
			Less e = (Less) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left < right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left < right;
			}
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			Values val = variableMap.get(e.varName);
			if(val.getType().equals("BOOLEAN")) {
				result = ((ValueBool)val.getValues()).value;
			}else {
				result = true;
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
			result = a.val.getType();
		}

		return result;
	}
	
	private double getDouble(Mathematics m) {
		double result = 0.00;
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left / right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left / right;
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getDouble(a.math);
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(a.val.getType().equals("INT")) {
				result = ((ValueNum)a.val).num;
			}
		}
		
		return result;
	}

	public int getInt(Mathematics m) {
		int result = 0;
		
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left / right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left / right;
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getInt(a.math);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(a.val.getType().equals("INT")) {
				result = ((ValueNum)a.val).num;
			}
		}
			
		return result;
	}
}
