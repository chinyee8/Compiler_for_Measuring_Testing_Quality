package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

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
import model.TestCase;

public class AntlrToTest extends exprBaseVisitor<TestCase>{
	List<String> vars;
	// can variable and method has the same name as class?
	List<String> semanticErrors;
	
	public AntlrToTest(List<String> semanticErrors) {
		this.vars = new ArrayList<>();
		this.semanticErrors = semanticErrors;
	}

	@Override
	public TestCase visitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDeclaration(ctx);
	}

	@Override
	public TestCase visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssignment(ctx);
	}

	@Override
	public TestCase visitRMethodCall(RMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitRMethodCall(ctx);
	}

	@Override
	public TestCase visitValues(ValuesContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValues(ctx);
	}

	@Override
	public TestCase visitMyMethods(MyMethodsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMethods(ctx);
	}

	@Override
	public TestCase visitMyReturnMethod(MyReturnMethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyReturnMethod(ctx);
	}

	@Override
	public TestCase visitMyVoidMethod(MyVoidMethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyVoidMethod(ctx);
	}

	@Override
	public TestCase visitMyMethodBody(MyMethodBodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMyMethodBody(ctx);
	}

	@Override
	public TestCase visitSingleParam(SingleParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSingleParam(ctx);
	}

	@Override
	public TestCase visitMultiParam(MultiParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiParam(ctx);
	}

	@Override
	public TestCase visitEmptyParam(EmptyParamContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEmptyParam(ctx);
	}

	@Override
	public TestCase visitParams(ParamsContext ctx) {
		// TODO Auto-generated method stub
		return super.visitParams(ctx);
	}

	@Override
	public TestCase visitMultiParamChild(MultiParamChildContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiParamChild(ctx);
	}

	@Override
	public TestCase visitTestCase(TestCaseContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestCase(ctx);
	}

	@Override
	public TestCase visitTestMethodCall(TestMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitTestMethodCall(ctx);
	}

	@Override
	public TestCase visitReturnMethodCall(ReturnMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturnMethodCall(ctx);
	}

	@Override
	public TestCase visitVoidMethodCall(VoidMethodCallContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVoidMethodCall(ctx);
	}

	@Override
	public TestCase visitCallParameter(CallParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParameter(ctx);
	}

	@Override
	public TestCase visitCallMultiParameter(CallMultiParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallMultiParameter(ctx);
	}

	@Override
	public TestCase visitCallEmptyParameter(CallEmptyParameterContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallEmptyParameter(ctx);
	}

	@Override
	public TestCase visitCallParamMath(CallParamMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamMath(ctx);
	}

	@Override
	public TestCase visitCallParamCond(CallParamCondContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamCond(ctx);
	}

	@Override
	public TestCase visitCallParamVarName(CallParamVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamVarName(ctx);
	}

	@Override
	public TestCase visitCallParamNum(CallParamNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamNum(ctx);
	}

	@Override
	public TestCase visitCallParamChar(CallParamCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamChar(ctx);
	}

	@Override
	public TestCase visitCallParamString(CallParamStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamString(ctx);
	}

	@Override
	public TestCase visitCallParamDouble(CallParamDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCallParamDouble(ctx);
	}

	@Override
	public TestCase visitMultipleInput(MultipleInputContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultipleInput(ctx);
	}

	@Override
	public TestCase visitIfStatement(IfStatementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIfStatement(ctx);
	}

	@Override
	public TestCase visitValueNum(ValueNumContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueNum(ctx);
	}

	@Override
	public TestCase visitValueDouble(ValueDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueDouble(ctx);
	}

	@Override
	public TestCase visitValueString(ValueStringContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueString(ctx);
	}

	@Override
	public TestCase visitValueChar(ValueCharContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueChar(ctx);
	}

	@Override
	public TestCase visitValueBool(ValueBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueBool(ctx);
	}

	@Override
	public TestCase visitValueMath(ValueMathContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValueMath(ctx);
	}

	@Override
	public TestCase visitMathNumber(MathNumberContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathNumber(ctx);
	}

	@Override
	public TestCase visitAddition(AdditionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAddition(ctx);
	}

	@Override
	public TestCase visitMultiplication(MultiplicationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMultiplication(ctx);
	}

	@Override
	public TestCase visitSubtraction(SubtractionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitSubtraction(ctx);
	}

	@Override
	public TestCase visitMathDouble(MathDoubleContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathDouble(ctx);
	}

	@Override
	public TestCase visitMathParenthesis(MathParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathParenthesis(ctx);
	}

	@Override
	public TestCase visitMathVarName(MathVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMathVarName(ctx);
	}

	@Override
	public TestCase visitDivision(DivisionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDivision(ctx);
	}

	@Override
	public TestCase visitLessOrEqual(LessOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLessOrEqual(ctx);
	}

	@Override
	public TestCase visitNegation(NegationContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNegation(ctx);
	}

	@Override
	public TestCase visitNotEqualTo(NotEqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitNotEqualTo(ctx);
	}

	@Override
	public TestCase visitCondVarName(CondVarNameContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondVarName(ctx);
	}

	@Override
	public TestCase visitCondEqual(CondEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondEqual(ctx);
	}

	@Override
	public TestCase visitEqualTo(EqualToContext ctx) {
		// TODO Auto-generated method stub
		return super.visitEqualTo(ctx);
	}

	@Override
	public TestCase visitMore(MoreContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMore(ctx);
	}

	@Override
	public TestCase visitDisjunction(DisjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDisjunction(ctx);
	}

	@Override
	public TestCase visitCondBool(CondBoolContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondBool(ctx);
	}

	@Override
	public TestCase visitMoreOrEqual(MoreOrEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMoreOrEqual(ctx);
	}

	@Override
	public TestCase visitCondNotEqual(CondNotEqualContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondNotEqual(ctx);
	}

	@Override
	public TestCase visitConjunction(ConjunctionContext ctx) {
		// TODO Auto-generated method stub
		return super.visitConjunction(ctx);
	}

	@Override
	public TestCase visitCondParenthesis(CondParenthesisContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCondParenthesis(ctx);
	}

	@Override
	public TestCase visitLess(LessContext ctx) {
		// TODO Auto-generated method stub
		return super.visitLess(ctx);
	}
	
	
}
