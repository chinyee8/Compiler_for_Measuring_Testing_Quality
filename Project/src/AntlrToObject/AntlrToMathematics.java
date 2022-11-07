package AntlrToObject;
import java.util.List;

import antlr.*;
import antlr.exprParser.*;
import model.*;

public class AntlrToMathematics extends exprBaseVisitor<Mathematics> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	//monica: hi yeseul, i've created a skeleton, pls fill them in (remove this comment after reading :))

	@Override
	public Mathematics visitMathNumber(MathNumberContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathNumber(ctx);
	}

	@Override
	public Mathematics visitAddition(AdditionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddition(ctx);
	}

	@Override
	public Mathematics visitMultiplication(MultiplicationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiplication(ctx);
	}

	@Override
	public Mathematics visitSubtraction(SubtractionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSubtraction(ctx);
	}

	@Override
	public Mathematics visitMathDouble(MathDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathDouble(ctx);
	}

	@Override
	public Mathematics visitMathParenthesis(MathParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathParenthesis(ctx);
	}

	@Override
	public Mathematics visitMathVarName(MathVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathVarName(ctx);
	}

	@Override
	public Mathematics visitDivision(DivisionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDivision(ctx);
	}
	
	
	
	
	
	
}
