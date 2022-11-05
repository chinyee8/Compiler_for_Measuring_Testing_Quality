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
	 * Visit a parse tree produced by the {@code ClassBody}
	 * labeled alternative in {@link exprParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(exprParser.ClassBodyContext ctx);
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
	 * Visit a parse tree produced by {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(exprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Method}
	 * labeled alternative in {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(exprParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mReturnMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMReturnMethod(exprParser.MReturnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mVoidMethod}
	 * labeled alternative in {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMVoidMethod(exprParser.MVoidMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnMethod}
	 * labeled alternative in {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnMethod(exprParser.ReturnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidMethod}
	 * labeled alternative in {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidMethod(exprParser.VoidMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodBody}
	 * labeled alternative in {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(exprParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(exprParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#test}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTest(exprParser.TestContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#t_method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT_method_call(exprParser.T_method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(exprParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(exprParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(exprParser.ValueContext ctx);
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
	 * Visit a parse tree produced by the {@code x}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(exprParser.XContext ctx);
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
	 * Visit a parse tree produced by the {@code Division}
	 * labeled alternative in {@link exprParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(exprParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code a}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA(exprParser.AContext ctx);
	/**
	 * Visit a parse tree produced by the {@code b}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitB(exprParser.BContext ctx);
	/**
	 * Visit a parse tree produced by the {@code c}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(exprParser.CContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(exprParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code d}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitD(exprParser.DContext ctx);
	/**
	 * Visit a parse tree produced by the {@code e}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(exprParser.EContext ctx);
	/**
	 * Visit a parse tree produced by the {@code f}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(exprParser.FContext ctx);
	/**
	 * Visit a parse tree produced by the {@code g}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitG(exprParser.GContext ctx);
	/**
	 * Visit a parse tree produced by the {@code h}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitH(exprParser.HContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotEqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqualTo(exprParser.NotEqualToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code i}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitI(exprParser.IContext ctx);
	/**
	 * Visit a parse tree produced by the {@code j}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJ(exprParser.JContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualTo}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualTo(exprParser.EqualToContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Disjunction}
	 * labeled alternative in {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(exprParser.DisjunctionContext ctx);
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
}