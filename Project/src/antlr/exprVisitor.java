// Generated from java-escape by ANTLR 4.11.1

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link exprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface exprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link exprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(exprParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GameClass}
	 * labeled alternative in {@link exprParser#game}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameClass(exprParser.GameClassContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GameBody}
	 * labeled alternative in {@link exprParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGameBody(exprParser.GameBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link exprParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(exprParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link exprParser#assi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(exprParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RMethodCall}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRMethodCall(exprParser.RMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Values}
	 * labeled alternative in {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(exprParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MyMethods}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyMethods(exprParser.MyMethodsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MyReturnM}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyReturnM(exprParser.MyReturnMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MyVoidM}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyVoidM(exprParser.MyVoidMContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MyReturnMethod}
	 * labeled alternative in {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyReturnMethod(exprParser.MyReturnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MyVoidMethod}
	 * labeled alternative in {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyVoidMethod(exprParser.MyVoidMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MyMethodBody}
	 * labeled alternative in {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyMethodBody(exprParser.MyMethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParam(exprParser.SingleParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParam(exprParser.MultiParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyParam}
	 * labeled alternative in {@link exprParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyParam(exprParser.EmptyParamContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Params}
	 * labeled alternative in {@link exprParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(exprParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiParam1}
	 * labeled alternative in {@link exprParser#multi_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParam1(exprParser.MultiParam1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiParam2}
	 * labeled alternative in {@link exprParser#multi_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiParam2(exprParser.MultiParam2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code TestCase}
	 * labeled alternative in {@link exprParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestCase(exprParser.TestCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestMethodCall}
	 * labeled alternative in {@link exprParser#t_method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestMethodCall(exprParser.TestMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestChar}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestChar(exprParser.TestCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestEmpty}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestEmpty(exprParser.TestEmptyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestVarName}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestVarName(exprParser.TestVarNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestMath}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestMath(exprParser.TestMathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestNum}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestNum(exprParser.TestNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestCond}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestCond(exprParser.TestCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestDouble}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestDouble(exprParser.TestDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestInputs}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestInputs(exprParser.TestInputsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TestString}
	 * labeled alternative in {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestString(exprParser.TestStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(exprParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueNum}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueNum(exprParser.ValueNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueDouble}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueDouble(exprParser.ValueDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueString}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueString(exprParser.ValueStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueChar}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueChar(exprParser.ValueCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueBool}
	 * labeled alternative in {@link exprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueBool(exprParser.ValueBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnMethodCall}
	 * labeled alternative in {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnMethodCall(exprParser.ReturnMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathNumber}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathNumber(exprParser.MathNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(exprParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(exprParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(exprParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathDouble}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathDouble(exprParser.MathDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathParenthesis}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathParenthesis(exprParser.MathParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MathVarName}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathVarName(exprParser.MathVarNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(exprParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessOrEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessOrEqual(exprParser.LessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(exprParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualTo(exprParser.NotEqualToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondVarName}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondVarName(exprParser.CondVarNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondEqual(exprParser.CondEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualTo(exprParser.EqualToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code More}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMore(exprParser.MoreContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(exprParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondBool}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondBool(exprParser.CondBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MoreOrEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoreOrEqual(exprParser.MoreOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondNotEqual}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondNotEqual(exprParser.CondNotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(exprParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondParenthesis}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondParenthesis(exprParser.CondParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(exprParser.LessContext ctx);
}