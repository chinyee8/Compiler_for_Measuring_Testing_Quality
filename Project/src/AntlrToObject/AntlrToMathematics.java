package AntlrToObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antlr.*;
import antlr.exprParser.*;
import model.*;

public class AntlrToMathematics extends exprBaseVisitor<Mathematics> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToMathematics(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}

	@Override
	public Mathematics visitMathNumber(MathNumberContext ctx) {
		int intNum = Integer.parseInt(ctx.getChild(0).getText());
		return new MathNumber(intNum);
	}

	@Override
	public Mathematics visitAddition(AdditionContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(2));
		return new Addition(left,right);
	}

	@Override
	public Mathematics visitMultiplication(MultiplicationContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(2));
		return new Multiplication(left,right);
	}

	@Override
	public Mathematics visitSubtraction(SubtractionContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(2));
		return new Subtraction(left,right);
	}

	@Override
	public Mathematics visitMathDouble(MathDoubleContext ctx) {
		double db = Double.parseDouble(ctx.getChild(0).getText());
		return new MathDouble(db);
	}

	@Override
	public Mathematics visitMathParenthesis(MathParenthesisContext ctx) {
		Mathematics math = visit(ctx.getChild(1));
		return new MathParenthesis(math);
	}

	@Override
	public Mathematics visitMathVarName(MathVarNameContext ctx) {
		String strVarName = ctx.getChild(0).getText();
		AntlrToGameBody.variableMap.get(strVarName);
		return new MathVarName(strVarName);
	}

	@Override
	public Mathematics visitDivision(DivisionContext ctx) {
		Mathematics left = visit(ctx.getChild(0));
		Mathematics right = visit(ctx.getChild(2));
		return new Division(left,right);
	}	
}
