package AntlrToObject;
import model.*;
import java.util.ArrayList;
import java.util.List;

import antlr.*;
import antlr.exprParser.*;

public class AntlrToCondition extends exprBaseVisitor<Condition> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	@Override
	public Condition visitLessOrEqual(LessOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLessOrEqual(ctx);
	}
	@Override
	public Condition visitNegation(NegationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNegation(ctx);
	}
	@Override
	public Condition visitNotEqualTo(NotEqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNotEqualTo(ctx);
	}
	@Override
	public Condition visitCondVarName(CondVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondVarName(ctx);
	}
	@Override
	public Condition visitCondEqual(CondEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondEqual(ctx);
	}
	@Override
	public Condition visitEqualTo(EqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualTo(ctx);
	}
	@Override
	public Condition visitMore(MoreContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMore(ctx);
	}
	@Override
	public Condition visitDisjunction(DisjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDisjunction(ctx);
	}
	@Override
	public Condition visitCondBool(CondBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondBool(ctx);
	}
	@Override
	public Condition visitMoreOrEqual(MoreOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMoreOrEqual(ctx);
	}
	@Override
	public Condition visitCondNotEqual(CondNotEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondNotEqual(ctx);
	}
	@Override
	public Condition visitConjunction(ConjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConjunction(ctx);
	}
	@Override
	public Condition visitCondParenthesis(CondParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondParenthesis(ctx);
	}
	@Override
	public Condition visitLess(LessContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLess(ctx);
	}

	
	
	
}
