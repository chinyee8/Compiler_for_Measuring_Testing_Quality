// Generated from java-escape by ANTLR 4.11.1

	package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link exprParser}.
 */
public interface exprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link exprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(exprParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link exprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(exprParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassBody}
	 * labeled alternative in {@link exprParser#body}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(exprParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassBody}
	 * labeled alternative in {@link exprParser#body}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(exprParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link exprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(exprParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link exprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(exprParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link exprParser#assi}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(exprParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link exprParser#assi}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(exprParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Method}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void enterMethod(exprParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Method}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void exitMethod(exprParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mReturnMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMReturnMethod(exprParser.MReturnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mReturnMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMReturnMethod(exprParser.MReturnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mVoidMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMVoidMethod(exprParser.MVoidMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mVoidMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMVoidMethod(exprParser.MVoidMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnMethod}
	 * labeled alternative in {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 */
	void enterReturnMethod(exprParser.ReturnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnMethod}
	 * labeled alternative in {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 */
	void exitReturnMethod(exprParser.ReturnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidMethod}
	 * labeled alternative in {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 */
	void enterVoidMethod(exprParser.VoidMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidMethod}
	 * labeled alternative in {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 */
	void exitVoidMethod(exprParser.VoidMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(exprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(exprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(exprParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(exprParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnMethodCall}
	 * labeled alternative in {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void enterReturnMethodCall(exprParser.ReturnMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnMethodCall}
	 * labeled alternative in {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void exitReturnMethodCall(exprParser.ReturnMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(exprParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(exprParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodBody}
	 * labeled alternative in {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(exprParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodBody}
	 * labeled alternative in {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(exprParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathNumber}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMathNumber(exprParser.MathNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathNumber}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMathNumber(exprParser.MathNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterAddition(exprParser.AdditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Addition}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitAddition(exprParser.AdditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMultiplication(exprParser.MultiplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Multiplication}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMultiplication(exprParser.MultiplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterSubtraction(exprParser.SubtractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Subtraction}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitSubtraction(exprParser.SubtractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MathDouble}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMathDouble(exprParser.MathDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathDouble}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMathDouble(exprParser.MathDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Division}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterDivision(exprParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitDivision(exprParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(exprParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(exprParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondBoolean}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondBoolean(exprParser.CondBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondBoolean}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondBoolean(exprParser.CondBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterDisjunction(exprParser.DisjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitDisjunction(exprParser.DisjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterLessThan(exprParser.LessThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessThan}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitLessThan(exprParser.LessThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNegation(exprParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNegation(exprParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(exprParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(exprParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotEqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualTo(exprParser.NotEqualToContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotEqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualTo(exprParser.NotEqualToContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondNumber}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondNumber(exprParser.CondNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondNumber}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondNumber(exprParser.CondNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MoreThan}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterMoreThan(exprParser.MoreThanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MoreThan}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitMoreThan(exprParser.MoreThanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterImplication(exprParser.ImplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implication}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitImplication(exprParser.ImplicationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterEqualTo(exprParser.EqualToContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitEqualTo(exprParser.EqualToContext ctx);
}