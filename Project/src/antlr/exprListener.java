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
	 * Enter a parse tree produced by {@link exprParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(exprParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(exprParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(exprParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(exprParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#assi}.
	 * @param ctx the parse tree
	 */
	void enterAssi(exprParser.AssiContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#assi}.
	 * @param ctx the parse tree
	 */
	void exitAssi(exprParser.AssiContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void enterMymethod(exprParser.MymethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 */
	void exitMymethod(exprParser.MymethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMethod_type(exprParser.Method_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMethod_type(exprParser.Method_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 */
	void enterReturn_method(exprParser.Return_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 */
	void exitReturn_method(exprParser.Return_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 */
	void enterVoid_method(exprParser.Void_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 */
	void exitVoid_method(exprParser.Void_methodContext ctx);
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
	 * Enter a parse tree produced by {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void enterR_method_call(exprParser.R_method_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 */
	void exitR_method_call(exprParser.R_method_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(exprParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(exprParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 */
	void enterMethod_body(exprParser.Method_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 */
	void exitMethod_body(exprParser.Method_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(exprParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link exprParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(exprParser.CondContext ctx);
}