package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IfStatement{
	public Condition cond;
	public MyMethodBody ifBody;
	public MyMethodBody elseBody;
	public HashMap<String, Values> variableMap;
	public boolean ifCovered;
	public boolean elseCovered;
	public List<String> semanticErrors;
	
	public IfStatement(Condition cond, MyMethodBody ifBody, MyMethodBody elseBody, List<String> semanticErrors) {
		this.cond = cond;
		this.ifBody = ifBody;
		this.elseBody = elseBody;
		ifCovered = false;
		elseCovered = false;
		this.semanticErrors = semanticErrors;
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
		
//	public List<MyMethodBody> getIfBody(Map<String, Values> map) {
//		List<MyMethodBody> m = new ArrayList<>();
//		
//		if(evaluated(cond, map)) {
//			m.add(ifBody);
//			m.add(elseBody);
//		}else {
//			m.add(elseBody);
//			m.add(ifBody);
//		}
//		
//		return m;
//	}
//	
//	public boolean evaluated(Condition c, Map<String, Values> map) {
//		boolean result = false;
//		
//		if(c instanceof Negation) {
//			Negation e = (Negation) c;
//			result = !(evaluated(e.cond, map));
//			
//		}else if(c instanceof CondParenthesis) {
//			CondParenthesis e = (CondParenthesis) c;
//			result = evaluated(e.cond, map);
//		}else if(c instanceof Conjunction) {
//			Conjunction e = (Conjunction) c;
//			boolean left = evaluated(e.cond1, map);
//			boolean right = evaluated(e.cond2, map);
//			result = left && right;
//		}else if(c instanceof Disjunction) {
//			Disjunction e = (Disjunction) c;
//			boolean left = evaluated(e.cond1, map);
//			boolean right = evaluated(e.cond2, map);
//			result = left || right;
//		}else if(c instanceof EqualTo) {
//			EqualTo e = (EqualTo) c;
//			boolean left = evaluated(e.cond1, map);
//			boolean right = evaluated(e.cond2, map);
//			result = left == right;
//		}else if(c instanceof NotEqualTo) {
//			NotEqualTo e = (NotEqualTo) c;
//			boolean left = evaluated(e.left, map);
//			boolean right = evaluated(e.right, map);
//			result = left != right;
//		}else if(c instanceof CondBool) {
//			CondBool e = (CondBool) c;
//			result = e.bool;
//		}else if(c instanceof CondEqual) {
//			CondEqual e = (CondEqual) c;
//			if(getMATHTYPE(e.math1).equals("INT")) {
//				int left = getInt(e.math1);
//				int right = getInt(e.math2);
//				result = left == right;
//			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
//				double left = getDouble(e.math1);
//				double right = getDouble(e.math2);
//				result = left == right;
//			}
//		}else if(c instanceof CondNotEqual) {
//			CondNotEqual e = (CondNotEqual) c;
//			if(getMATHTYPE(e.math1).equals("INT")) {
//				int left = getInt(e.math1);
//				int right = getInt(e.math2);
//				result = left != right;
//			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
//				double left = getDouble(e.math1);
//				double right = getDouble(e.math2);
//				result = left != right;
//			}
//		}else if(c instanceof MoreOrEqual) {
//			MoreOrEqual e = (MoreOrEqual) c;
//			if(getMATHTYPE(e.math1).equals("INT")) {
//				int left = getInt(e.math1);
//				int right = getInt(e.math2);
//				result = left >= right;
//			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
//				double left = getDouble(e.math1);
//				double right = getDouble(e.math2);
//				result = left >= right;
//			}
//		}else if(c instanceof LessOrEqual) {
//			LessOrEqual e = (LessOrEqual) c;
//			if(getMATHTYPE(e.left).equals("INT")) {
//				int left = getInt(e.left);
//				int right = getInt(e.right);
//				result = left <= right;
//			}else if(getMATHTYPE(e.left).equals("DOUBLE")) {
//				double left = getDouble(e.left);
//				double right = getDouble(e.right);
//				result = left <= right;
//			}
//		}else if(c instanceof More) {
//			More e = (More) c;
//			if(getMATHTYPE(e.math1).equals("INT")) {
//				int left = getInt(e.math1);
//				int right = getInt(e.math2);
//				result = left > right;
//			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
//				double left = getDouble(e.math1);
//				double right = getDouble(e.math2);
//				result = left > right;
//			}
//		}else if(c instanceof Less) {
//			Less e = (Less) c;
//			if(getMATHTYPE(e.math1).equals("INT")) {
//				int left = getInt(e.math1);
//				int right = getInt(e.math2);
//				result = left < right;
//			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
//				double left = getDouble(e.math1);
//				double right = getDouble(e.math2);
//				result = left < right;
//			}
//		}else if(c instanceof CondVarName) {
//			CondVarName e = (CondVarName) c;
//			if(map.containsKey(e.varName)) {
//				Values val = map.get(e.varName);
//				if(val.getType().equals("BOOLEAN")) {
//					result = ((ValueBool)val.getValues()).value;
//				}
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
//	
//	private double getDouble(Mathematics m) {
//		double result = 0.00;
//		if(m instanceof Addition) {
//			Addition a = (Addition) m;
//			double left = getDouble(a.math1);
//			double right = getDouble(a.math2);
//			result = left + right;
//		}else if(m instanceof Subtraction) {
//			Subtraction a = (Subtraction) m;
//			double left = getDouble(a.math1);
//			double right = getDouble(a.math2);
//			result = left - right;
//		}else if(m instanceof Multiplication) {
//			Multiplication a = (Multiplication) m;
//			double left = getDouble(a.math1);
//			double right = getDouble(a.math2);
//			result = left * right;
//		}else if(m instanceof Division) {
//			Division a = (Division) m;
//			double left = getDouble(a.math1);
//			double right = getDouble(a.math2);
//			if(right == 0) {
//				semanticErrors.add("Error: undefined. Cannot divide by 0");
//			}else {
//				result = left / right;
//			}
//			
//		}else if(m instanceof MathParenthesis) {
//			MathParenthesis a = (MathParenthesis) m;
//			result = getDouble(a.math);
//		}else if(m instanceof MathDouble) {
//			MathDouble a = (MathDouble) m;
//			result = a.num;
//		}else if(m instanceof MathVarName) {
//			MathVarName a = (MathVarName) m;
//			if(a.val.getType().equals("INT")) {
//				result = ((ValueNum)a.val).num;
//			}
//		}
//		
//		return result;
//	}
//
//	public int getInt(Mathematics m) {
//		int result = 0;
//		
//		if(m instanceof Addition) {
//			Addition a = (Addition) m;
//			int left = getInt(a.math1);
//			int right = getInt(a.math2);
//			result = left + right;
//		}else if(m instanceof Subtraction) {
//			Subtraction a = (Subtraction) m;
//			int left = getInt(a.math1);
//			int right = getInt(a.math2);
//			result = left - right;
//		}else if(m instanceof Multiplication) {
//			Multiplication a = (Multiplication) m;
//			int left = getInt(a.math1);
//			int right = getInt(a.math2);
//			result = left * right;
//		}else if(m instanceof Division) {
//			Division a = (Division) m;
//			int left = getInt(a.math1);
//			int right = getInt(a.math2);
//			if(right == 0) {
//				semanticErrors.add("Error: undefined. Cannot divide by 0");
//			}else {
//				result = left / right;
//			}
//		}else if(m instanceof MathParenthesis) {
//			MathParenthesis a = (MathParenthesis) m;
//			result = getInt(a.math);
//		}else if(m instanceof MathNumber) {
//			MathNumber a = (MathNumber) m;
//			result = a.num;
//		}else if(m instanceof MathVarName) {
//			MathVarName a = (MathVarName) m;
//			if(a.val.getType().equals("INT")) {
//				result = ((ValueNum)a.val).num;
//			}
//		}
//			
//		return result;
//	}
}
