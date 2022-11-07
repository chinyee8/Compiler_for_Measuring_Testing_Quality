package AntlrToObject;
import model.*;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.*;
import antlr.exprParser.*;

public class AntlrToCondition extends exprBaseVisitor<Condition> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	

	
	@Override
	public Condition visitLessOrEqual(LessOrEqualContext ctx) {
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics();
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics();
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		return new LessOrEqual(left, right);
	}
	@Override
	public Condition visitNegation(NegationContext ctx) {
		Condition condition = visit(ctx.getChild(1));
		return new Negation(condition);
	}
	@Override
	public Condition visitNotEqualTo(NotEqualToContext ctx) {
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		return new NotEqualTo(left, right);
	}
	@Override
	public Condition visitCondVarName(CondVarNameContext ctx) {
		String varName = ctx.getChild(0).getText();
		return new CondVarName(varName);
	}
	@Override
	public Condition visitCondEqual(CondEqualContext ctx) {
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics();
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics();
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		return new CondEqual(left, right);
	}
	@Override
	public Condition visitEqualTo(EqualToContext ctx) {
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		return new EqualTo(left, right);
	}
	@Override
	public Condition visitMore(MoreContext ctx) {
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics();
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics();
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		return new More(left, right);
	}
	@Override
	public Condition visitDisjunction(DisjunctionContext ctx) {
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		return new Disjunction(left, right);
	}
	@Override
	public Condition visitCondBool(CondBoolContext ctx) {
		String temp = ctx.getChild(0).getText();
		boolean res = false;
		if(temp.equals("TRUE")) {
			res = true;
		}
		else if (temp.equals("FALSE")) {
			res = false;
		}
		return new CondBool(res);
	}
	@Override
	public Condition visitMoreOrEqual(MoreOrEqualContext ctx) {
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics();
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics();
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		return new MoreOrEqual(left, right);
	}
	@Override
	public Condition visitCondNotEqual(CondNotEqualContext ctx) {
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics();
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics();
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		return new CondNotEqual(left, right);
	}
	@Override
	public Condition visitConjunction(ConjunctionContext ctx) {
		Condition left = visit(ctx.getChild(0));
		Condition right = visit(ctx.getChild(2));
		return new Conjunction(left, right);
	}
	@Override
	public Condition visitCondParenthesis(CondParenthesisContext ctx) {
		Condition temp = visit(ctx.getChild(1));
		return new CondParenthesis(temp);
	}
	@Override
	public Condition visitLess(LessContext ctx) {
		AntlrToMathematics mVisitorLeft = new AntlrToMathematics();
		Mathematics left = mVisitorLeft.visit(ctx.getChild(0));
		AntlrToMathematics mVisitorRight = new AntlrToMathematics();
		Mathematics right = mVisitorRight.visit(ctx.getChild(2));
		
		return new Less(left, right);
	}

	
	
	
}