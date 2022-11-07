package AntlrToObject;
import java.util.List;

import antlr.*;
import antlr.exprParser.*;
import model.*;

public class AntlrToMathematics extends exprBaseVisitor<Mathematics> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;

	@Override
	public Mathematics visitMathNumber(MathNumberContext ctx) {
		Mathematics num = visit(ctx.getChild(0));
		int intNum = Integer.parseInt(num.toString());
		return new MathNumber(intNum);
	}

	@Override
	public Mathematics visitAddition(AdditionContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(1));
		return new Addition(left,right);
	}

	@Override
	public Mathematics visitMultiplication(MultiplicationContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(1));
		return new Multiplication(left,right);
	}

	@Override
	public Mathematics visitSubtraction(SubtractionContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(1));
		return new Subtraction(left,right);
	}

	@Override
	public Mathematics visitMathDouble(MathDoubleContext ctx) {
		Mathematics db = visit(ctx.getChild(0));
		double dbDb = Double.parseDouble(db.toString());
		return new MathDouble(dbDb);
	}

	@Override
	public Mathematics visitMathParenthesis(MathParenthesisContext ctx) {
		Mathematics math = visit(ctx.getChild(0));
		return new MathParenthesis(math);
	}

	@Override
	public Mathematics visitMathVarName(MathVarNameContext ctx) {
		Mathematics varName = visit(ctx.getChild(0));
		String strVarName = varName.toString();
		return new MathVarName(strVarName);
	}

	@Override
	public Mathematics visitDivision(DivisionContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(1));
		return new Division(left,right);
	}	
}
