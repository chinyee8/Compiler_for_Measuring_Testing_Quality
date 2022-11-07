package AntlrToObject;
import model.*;
import java.util.ArrayList;
import java.util.List;

import antlr.*;
import antlr.exprParser.*;

public class AntlrToValue extends exprBaseVisitor<Values> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	
	
	@Override
	public Values visitValues(ValuesContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValues(ctx);
	}
	@Override
	public Values visitValueNum(ValueNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueNum(ctx);
	}
	@Override
	public Values visitValueDouble(ValueDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueDouble(ctx);
	}
	@Override
	public Values visitValueString(ValueStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueString(ctx);
	}
	@Override
	public Values visitValueChar(ValueCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueChar(ctx);
	}
	@Override
	public Values visitValueBool(ValueBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueBool(ctx);
	}
	@Override
	public Values visitValueMath(ValueMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueMath(ctx);
	}
	
	
}
