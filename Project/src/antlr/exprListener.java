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
	 * Enter a parse tree produced by {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(exprParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(exprParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#test}.
	 * @param ctx the parse tree
	 */
	void enterTest(exprParser.TestContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#test}.
	 * @param ctx the parse tree
	 */
	void exitTest(exprParser.TestContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#t_method_call}.
	 * @param ctx the parse tree
	 */
	void enterT_method_call(exprParser.T_method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#t_method_call}.
	 * @param ctx the parse tree
	 */
	void exitT_method_call(exprParser.T_method_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(exprParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(exprParser.InputContext ctx);
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
	 * Enter a parse tree produced by the {@code x}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterX(exprParser.XContext ctx);
	/**
	 * Exit a parse tree produced by the {@code x}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitX(exprParser.XContext ctx);
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
	 * Enter a parse tree produced by the {@code MathParenthesis}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void enterMathParenthesis(exprParser.MathParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MathParenthesis}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 */
	void exitMathParenthesis(exprParser.MathParenthesisContext ctx);
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
	 * Enter a parse tree produced by the {@code a}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterA(exprParser.AContext ctx);
	/**
	 * Exit a parse tree produced by the {@code a}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitA(exprParser.AContext ctx);
	/**
	 * Enter a parse tree produced by the {@code b}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterB(exprParser.BContext ctx);
	/**
	 * Exit a parse tree produced by the {@code b}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitB(exprParser.BContext ctx);
	/**
	 * Enter a parse tree produced by the {@code c}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterC(exprParser.CContext ctx);
	/**
	 * Exit a parse tree produced by the {@code c}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitC(exprParser.CContext ctx);
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
	 * Enter a parse tree produced by the {@code d}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterD(exprParser.DContext ctx);
	/**
	 * Exit a parse tree produced by the {@code d}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitD(exprParser.DContext ctx);
	/**
	 * Enter a parse tree produced by the {@code e}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterE(exprParser.EContext ctx);
	/**
	 * Exit a parse tree produced by the {@code e}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitE(exprParser.EContext ctx);
	/**
	 * Enter a parse tree produced by the {@code f}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterF(exprParser.FContext ctx);
	/**
	 * Exit a parse tree produced by the {@code f}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitF(exprParser.FContext ctx);
	/**
	 * Enter a parse tree produced by the {@code g}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterG(exprParser.GContext ctx);
	/**
	 * Exit a parse tree produced by the {@code g}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitG(exprParser.GContext ctx);
	/**
	 * Enter a parse tree produced by the {@code h}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterH(exprParser.HContext ctx);
	/**
	 * Exit a parse tree produced by the {@code h}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitH(exprParser.HContext ctx);
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
	 * Enter a parse tree produced by the {@code i}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterI(exprParser.IContext ctx);
	/**
	 * Exit a parse tree produced by the {@code i}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitI(exprParser.IContext ctx);
	/**
	 * Enter a parse tree produced by the {@code j}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterJ(exprParser.JContext ctx);
	/**
	 * Exit a parse tree produced by the {@code j}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitJ(exprParser.JContext ctx);
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
	 * Enter a parse tree produced by the {@code CondParenthesis}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCondParenthesis(exprParser.CondParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondParenthesis}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCondParenthesis(exprParser.CondParenthesisContext ctx);
}