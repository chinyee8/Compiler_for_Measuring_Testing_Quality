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
	 * Visit a parse tree produced by {@link exprParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(exprParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(exprParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#assi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssi(exprParser.AssiContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#mymethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMymethod(exprParser.MymethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_type(exprParser.Method_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#return_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_method(exprParser.Return_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#void_method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid_method(exprParser.Void_methodContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(exprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(exprParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#r_method_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR_method_call(exprParser.R_method_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(exprParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#method_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_body(exprParser.Method_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link exprParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(exprParser.CondContext ctx);
}