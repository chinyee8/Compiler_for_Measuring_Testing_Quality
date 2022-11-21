package AntlrToObject;
import model.*;

import java.util.HashMap;
import java.util.List;

import antlr.*;
import antlr.exprParser.*;

public class AntlrToValue extends exprBaseVisitor<Values> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	
	public AntlrToValue(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	@Override
	public Values visitValues(ValuesContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValues(ctx);
	}
	@Override
	public Values visitValueNum(ValueNumContext ctx) {
		int temp = Integer.parseInt(ctx.getChild(0).getText());
		return new ValueNum(temp);
	}
	@Override
	public Values visitValueDouble(ValueDoubleContext ctx) {
		String temp = "";
		for(int i = 0; i < ctx.getChild(0).getText().length(); i++) {
			if(ctx.getChild(0).getText().charAt(i) != '.') {
				temp += ctx.getChild(0).getText().charAt(i);
			}
		}
		int temp1 = Integer.parseInt(temp);
		double res = temp1/100.0;
		return new ValueDouble(res);
	}
	@Override
	public Values visitValueString(ValueStringContext ctx) {
		return new ValueString(ctx.getChild(0).getText());
	}
	@Override
	public Values visitValueChar(ValueCharContext ctx) {
		return new ValueChar(ctx.getChild(0).getText().charAt(1));
	}
	@Override
	public Values visitValueBool(ValueBoolContext ctx) {
		String temp = ctx.getChild(0).getText();
		boolean k = false;
		if(temp.equals("TRUE")) {
			k = true;
		}
		return new ValueBool(k);
	}
	@Override
	public Values visitValueMath(ValueMathContext ctx) {
		AntlrToMathematics mVisitor = new AntlrToMathematics(semanticErrors, this.variableMap);
		Mathematics m = mVisitor.visit(ctx.getChild(0));
		
		
		return new ValueMath(m);
	}
	
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
