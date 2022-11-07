package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.AdditionContext;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.CallEmptyParameterContext;
import antlr.exprParser.CallMultiParameterContext;
import antlr.exprParser.CallParamCharContext;
import antlr.exprParser.CallParamCondContext;
import antlr.exprParser.CallParamDoubleContext;
import antlr.exprParser.CallParamMathContext;
import antlr.exprParser.CallParamNumContext;
import antlr.exprParser.CallParamStringContext;
import antlr.exprParser.CallParamVarNameContext;
import antlr.exprParser.CallParameterContext;
import antlr.exprParser.CondBoolContext;
import antlr.exprParser.CondEqualContext;
import antlr.exprParser.CondNotEqualContext;
import antlr.exprParser.CondParenthesisContext;
import antlr.exprParser.CondVarNameContext;
import antlr.exprParser.ConjunctionContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.DisjunctionContext;
import antlr.exprParser.DivisionContext;
import antlr.exprParser.EmptyParamContext;
import antlr.exprParser.EqualToContext;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.IfStatementContext;
import antlr.exprParser.LessContext;
import antlr.exprParser.LessOrEqualContext;
import antlr.exprParser.MathDoubleContext;
import antlr.exprParser.MathNumberContext;
import antlr.exprParser.MathParenthesisContext;
import antlr.exprParser.MathVarNameContext;
import antlr.exprParser.MoreContext;
import antlr.exprParser.MoreOrEqualContext;
import antlr.exprParser.MultiParamChildContext;
import antlr.exprParser.MultiParamContext;
import antlr.exprParser.MultipleInputContext;
import antlr.exprParser.MultiplicationContext;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import antlr.exprParser.NegationContext;
import antlr.exprParser.NotEqualToContext;
import antlr.exprParser.ParamsContext;
import antlr.exprParser.RMethodCallContext;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.SingleParamContext;
import antlr.exprParser.SubtractionContext;
import antlr.exprParser.TestCaseContext;
import antlr.exprParser.TestMethodCallContext;
import antlr.exprParser.ValueBoolContext;
import antlr.exprParser.ValueCharContext;
import antlr.exprParser.ValueDoubleContext;
import antlr.exprParser.ValueMathContext;
import antlr.exprParser.ValueNumContext;
import antlr.exprParser.ValueStringContext;
import antlr.exprParser.ValuesContext;
import antlr.exprParser.VoidMethodCallContext;
import model.GameClass;

public class AntlrToGame extends exprBaseVisitor<GameClass>{
	List<String> vars;
	List<String> methods; 
	// can variable and method has the same name as class?
	List<String> semanticErrors;
	
	public AntlrToGame(List<String> semanticErrors) {
		this.vars = new ArrayList<>();
		this.semanticErrors = semanticErrors;
	}

	@Override
	public GameClass visitGameClass(GameClassContext ctx) {
		// TODO Auto-generated method stub
		return super.visitGameClass(ctx);
	}

	@Override
	public GameClass visitGameBody(GameBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitGameBody(ctx);
	}

	@Override
	public GameClass visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDeclaration(ctx);
	}

	@Override
	public GameClass visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignment(ctx);
	}

	@Override
	public GameClass visitRMethodCall(RMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRMethodCall(ctx);
	}

	@Override
	public GameClass visitValues(ValuesContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValues(ctx);
	}

	@Override
	public GameClass visitMyMethods(MyMethodsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMethods(ctx);
	}

	@Override
	public GameClass visitMyReturnMethod(MyReturnMethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyReturnMethod(ctx);
	}

	@Override
	public GameClass visitMyVoidMethod(MyVoidMethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyVoidMethod(ctx);
	}

	@Override
	public GameClass visitMyMethodBody(MyMethodBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMethodBody(ctx);
	}

	@Override
	public GameClass visitSingleParam(SingleParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSingleParam(ctx);
	}

	@Override
	public GameClass visitMultiParam(MultiParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiParam(ctx);
	}

	@Override
	public GameClass visitEmptyParam(EmptyParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEmptyParam(ctx);
	}

	@Override
	public GameClass visitParams(ParamsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParams(ctx);
	}

	@Override
	public GameClass visitMultiParamChild(MultiParamChildContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiParamChild(ctx);
	}

	@Override
	public GameClass visitReturnMethodCall(ReturnMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturnMethodCall(ctx);
	}

	@Override
	public GameClass visitVoidMethodCall(VoidMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVoidMethodCall(ctx);
	}

	@Override
	public GameClass visitCallParameter(CallParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParameter(ctx);
	}

	@Override
	public GameClass visitCallMultiParameter(CallMultiParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallMultiParameter(ctx);
	}

	@Override
	public GameClass visitCallEmptyParameter(CallEmptyParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallEmptyParameter(ctx);
	}

	@Override
	public GameClass visitCallParamMath(CallParamMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamMath(ctx);
	}

	@Override
	public GameClass visitCallParamCond(CallParamCondContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamCond(ctx);
	}

	@Override
	public GameClass visitCallParamVarName(CallParamVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamVarName(ctx);
	}

	@Override
	public GameClass visitCallParamNum(CallParamNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamNum(ctx);
	}

	@Override
	public GameClass visitCallParamChar(CallParamCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamChar(ctx);
	}

	@Override
	public GameClass visitCallParamString(CallParamStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamString(ctx);
	}

	@Override
	public GameClass visitCallParamDouble(CallParamDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamDouble(ctx);
	}

	@Override
	public GameClass visitMultipleInput(MultipleInputContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultipleInput(ctx);
	}

	@Override
	public GameClass visitIfStatement(IfStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIfStatement(ctx);
	}

	@Override
	public GameClass visitValueNum(ValueNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueNum(ctx);
	}

	@Override
	public GameClass visitValueDouble(ValueDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueDouble(ctx);
	}

	@Override
	public GameClass visitValueString(ValueStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueString(ctx);
	}

	@Override
	public GameClass visitValueChar(ValueCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueChar(ctx);
	}

	@Override
	public GameClass visitValueBool(ValueBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueBool(ctx);
	}

	@Override
	public GameClass visitValueMath(ValueMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueMath(ctx);
	}

	@Override
	public GameClass visitMathNumber(MathNumberContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathNumber(ctx);
	}

	@Override
	public GameClass visitAddition(AdditionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddition(ctx);
	}

	@Override
	public GameClass visitMultiplication(MultiplicationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiplication(ctx);
	}

	@Override
	public GameClass visitSubtraction(SubtractionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSubtraction(ctx);
	}

	@Override
	public GameClass visitMathDouble(MathDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathDouble(ctx);
	}

	@Override
	public GameClass visitMathParenthesis(MathParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathParenthesis(ctx);
	}

	@Override
	public GameClass visitMathVarName(MathVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathVarName(ctx);
	}

	@Override
	public GameClass visitDivision(DivisionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDivision(ctx);
	}

	@Override
	public GameClass visitLessOrEqual(LessOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLessOrEqual(ctx);
	}

	@Override
	public GameClass visitNegation(NegationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNegation(ctx);
	}

	@Override
	public GameClass visitNotEqualTo(NotEqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNotEqualTo(ctx);
	}

	@Override
	public GameClass visitCondVarName(CondVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondVarName(ctx);
	}

	@Override
	public GameClass visitCondEqual(CondEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondEqual(ctx);
	}

	@Override
	public GameClass visitEqualTo(EqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualTo(ctx);
	}

	@Override
	public GameClass visitMore(MoreContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMore(ctx);
	}

	@Override
	public GameClass visitDisjunction(DisjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDisjunction(ctx);
	}

	@Override
	public GameClass visitCondBool(CondBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondBool(ctx);
	}

	@Override
	public GameClass visitMoreOrEqual(MoreOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMoreOrEqual(ctx);
	}

	@Override
	public GameClass visitCondNotEqual(CondNotEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondNotEqual(ctx);
	}

	@Override
	public GameClass visitConjunction(ConjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConjunction(ctx);
	}

	@Override
	public GameClass visitCondParenthesis(CondParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondParenthesis(ctx);
	}

	@Override
	public GameClass visitLess(LessContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLess(ctx);
	}

	
}