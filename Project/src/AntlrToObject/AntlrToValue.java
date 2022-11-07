package AntlrToObject;
import model.*;
import java.util.ArrayList;
import java.util.List;

import antlr.*;
import antlr.exprParser.*;

public class AntlrToValue extends exprBaseVisitor<Values> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToValue(List<String> semanticErrors) {
		this.semanticErrors = new ArrayList<>();
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
		double res = temp1/100;
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
		AntlrToMathematics mVisitor = new AntlrToMathematics(semanticErrors);
		Mathematics m = mVisitor.visit(ctx.getChild(0));
		return new ValueMath(m);
	}
	
	
}
