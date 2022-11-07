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
import antlr.exprParser.Multi_InputContext;
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
import model.Expression;

public class AntlrToExpression extends exprBaseVisitor<Expression>{
	List<String> vars;
	List<String> methods; 
	// can variable and method has the same name as class?
	List<String> tests;
	List<String> semanticErrors;
	
	public AntlrToExpression(List<String> semanticErrors) {
		this.vars = new ArrayList<>();
		this.semanticErrors = semanticErrors;
	}

	@Override
	public Expression visitGameClass(GameClassContext ctx) {
		// TODO Auto-generated method stub
		return super.visitGameClass(ctx);
	}

	@Override
	public Expression visitGameBody(GameBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitGameBody(ctx);
	}

	@Override
	public Expression visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDeclaration(ctx);
	}

	@Override
	public Expression visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignment(ctx);
	}

	@Override
	public Expression visitRMethodCall(RMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRMethodCall(ctx);
	}

	@Override
	public Expression visitValues(ValuesContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValues(ctx);
	}

	@Override
	public Expression visitMyMethods(MyMethodsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMethods(ctx);
	}

	@Override
	public Expression visitMyReturnMethod(MyReturnMethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyReturnMethod(ctx);
	}

	@Override
	public Expression visitMyVoidMethod(MyVoidMethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyVoidMethod(ctx);
	}

	@Override
	public Expression visitMyMethodBody(MyMethodBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMethodBody(ctx);
	}

	@Override
	public Expression visitSingleParam(SingleParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSingleParam(ctx);
	}

	@Override
	public Expression visitMultiParam(MultiParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiParam(ctx);
	}

	@Override
	public Expression visitEmptyParam(EmptyParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEmptyParam(ctx);
	}

	@Override
	public Expression visitParams(ParamsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParams(ctx);
	}

	@Override
	public Expression visitMultiParamChild(MultiParamChildContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiParamChild(ctx);
	}

	@Override
	public Expression visitTestCase(TestCaseContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestCase(ctx);
	}

	@Override
	public Expression visitTestMethodCall(TestMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestMethodCall(ctx);
	}

	@Override
	public Expression visitReturnMethodCall(ReturnMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturnMethodCall(ctx);
	}

	@Override
	public Expression visitVoidMethodCall(VoidMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVoidMethodCall(ctx);
	}

	@Override
	public Expression visitCallParameter(CallParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParameter(ctx);
	}

	@Override
	public Expression visitCallMultiParameter(CallMultiParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallMultiParameter(ctx);
	}

	@Override
	public Expression visitCallEmptyParameter(CallEmptyParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallEmptyParameter(ctx);
	}

	@Override
	public Expression visitCallParamMath(CallParamMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamMath(ctx);
	}

	@Override
	public Expression visitCallParamCond(CallParamCondContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamCond(ctx);
	}

	@Override
	public Expression visitCallParamVarName(CallParamVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamVarName(ctx);
	}

	@Override
	public Expression visitCallParamNum(CallParamNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamNum(ctx);
	}

	@Override
	public Expression visitCallParamChar(CallParamCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamChar(ctx);
	}

	@Override
	public Expression visitCallParamString(CallParamStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamString(ctx);
	}

	@Override
	public Expression visitCallParamDouble(CallParamDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamDouble(ctx);
	}

	@Override
	public Expression visitMulti_Input(Multi_InputContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMulti_Input(ctx);
	}

	@Override
	public Expression visitIfStatement(IfStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIfStatement(ctx);
	}

	@Override
	public Expression visitValueNum(ValueNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueNum(ctx);
	}

	@Override
	public Expression visitValueDouble(ValueDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueDouble(ctx);
	}

	@Override
	public Expression visitValueString(ValueStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueString(ctx);
	}

	@Override
	public Expression visitValueChar(ValueCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueChar(ctx);
	}

	@Override
	public Expression visitValueBool(ValueBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueBool(ctx);
	}

	@Override
	public Expression visitValueMath(ValueMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueMath(ctx);
	}

	@Override
	public Expression visitMathNumber(MathNumberContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathNumber(ctx);
	}

	@Override
	public Expression visitAddition(AdditionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddition(ctx);
	}

	@Override
	public Expression visitMultiplication(MultiplicationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiplication(ctx);
	}

	@Override
	public Expression visitSubtraction(SubtractionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSubtraction(ctx);
	}

	@Override
	public Expression visitMathDouble(MathDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathDouble(ctx);
	}

	@Override
	public Expression visitMathParenthesis(MathParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathParenthesis(ctx);
	}

	@Override
	public Expression visitMathVarName(MathVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathVarName(ctx);
	}

	@Override
	public Expression visitDivision(DivisionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDivision(ctx);
	}

	@Override
	public Expression visitLessOrEqual(LessOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLessOrEqual(ctx);
	}

	@Override
	public Expression visitNegation(NegationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNegation(ctx);
	}

	@Override
	public Expression visitNotEqualTo(NotEqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNotEqualTo(ctx);
	}

	@Override
	public Expression visitCondVarName(CondVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondVarName(ctx);
	}

	@Override
	public Expression visitCondEqual(CondEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondEqual(ctx);
	}

	@Override
	public Expression visitEqualTo(EqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualTo(ctx);
	}

	@Override
	public Expression visitMore(MoreContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMore(ctx);
	}

	@Override
	public Expression visitDisjunction(DisjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDisjunction(ctx);
	}

	@Override
	public Expression visitCondBool(CondBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondBool(ctx);
	}

	@Override
	public Expression visitMoreOrEqual(MoreOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMoreOrEqual(ctx);
	}

	@Override
	public Expression visitCondNotEqual(CondNotEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondNotEqual(ctx);
	}

	@Override
	public Expression visitConjunction(ConjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConjunction(ctx);
	}

	@Override
	public Expression visitCondParenthesis(CondParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondParenthesis(ctx);
	}

	@Override
	public Expression visitLess(LessContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLess(ctx);
	}

	
}