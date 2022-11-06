package appAdd;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.AdditionContext;
import antlr.exprParser.AssiExprValuesContext;
import antlr.exprParser.AssiRMethodCallContext;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.CondBoolContext;
import antlr.exprParser.CondEqualContext;
import antlr.exprParser.CondNotEqualContext;
import antlr.exprParser.CondParenthesisContext;
import antlr.exprParser.CondVarNameContext;
import antlr.exprParser.ConjunctionContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.DisjunctionContext;
import antlr.exprParser.DivisionContext;
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
import antlr.exprParser.MultiplicationContext;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyMultiParameterContext;
import antlr.exprParser.MyNoParameterContext;
import antlr.exprParser.MyParameterContext;
import antlr.exprParser.MyReturnMContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMContext;
import antlr.exprParser.MyVoidMethodContext;
import antlr.exprParser.NegationContext;
import antlr.exprParser.NotEqualToContext;
import antlr.exprParser.PMultiContext;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.SubtractionContext;
import antlr.exprParser.TestCaseContext;
import antlr.exprParser.TestCharContext;
import antlr.exprParser.TestCondContext;
import antlr.exprParser.TestDoubleContext;
import antlr.exprParser.TestEmptyContext;
import antlr.exprParser.TestInputsContext;
import antlr.exprParser.TestMathContext;
import antlr.exprParser.TestMethodCallContext;
import antlr.exprParser.TestNumContext;
import antlr.exprParser.TestStringContext;
import antlr.exprParser.TestVarNameContext;
import antlr.exprParser.ValueBoolContext;
import antlr.exprParser.ValueCharContext;
import antlr.exprParser.ValueDoubleContext;
import antlr.exprParser.ValueNumContext;
import antlr.exprParser.ValueStringContext;
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
	public Expression visitAssiRMethodCall(AssiRMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssiRMethodCall(ctx);
	}

	@Override
	public Expression visitAssiExprValues(AssiExprValuesContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssiExprValues(ctx);
	}

	@Override
	public Expression visitMyMethods(MyMethodsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMethods(ctx);
	}

	@Override
	public Expression visitMyReturnM(MyReturnMContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyReturnM(ctx);
	}

	@Override
	public Expression visitMyVoidM(MyVoidMContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyVoidM(ctx);
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
	public Expression visitMyParameter(MyParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyParameter(ctx);
	}

	@Override
	public Expression visitMyMultiParameter(MyMultiParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMultiParameter(ctx);
	}

	@Override
	public Expression visitMyNoParameter(MyNoParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyNoParameter(ctx);
	}

	@Override
	public Expression visitPMulti(PMultiContext ctx) {
		// TODO Auto-generated method stub
		return super.visitPMulti(ctx);
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
	public Expression visitTestChar(TestCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestChar(ctx);
	}

	@Override
	public Expression visitTestEmpty(TestEmptyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestEmpty(ctx);
	}

	@Override
	public Expression visitTestVarName(TestVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestVarName(ctx);
	}

	@Override
	public Expression visitTestMath(TestMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestMath(ctx);
	}

	@Override
	public Expression visitTestNum(TestNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestNum(ctx);
	}

	@Override
	public Expression visitTestCond(TestCondContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestCond(ctx);
	}

	@Override
	public Expression visitTestDouble(TestDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestDouble(ctx);
	}

	@Override
	public Expression visitTestInputs(TestInputsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestInputs(ctx);
	}

	@Override
	public Expression visitTestString(TestStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestString(ctx);
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
	public Expression visitReturnMethodCall(ReturnMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturnMethodCall(ctx);
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