package model;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssiContext;
import antlr.exprParser.BodyContext;
import antlr.exprParser.CondContext;
import antlr.exprParser.DeclContext;
import antlr.exprParser.ExprContext;
import antlr.exprParser.If_statementContext;
import antlr.exprParser.Method_bodyContext;
import antlr.exprParser.Method_typeContext;
import antlr.exprParser.MymethodContext;
import antlr.exprParser.R_method_callContext;
import antlr.exprParser.Return_methodContext;
import antlr.exprParser.ValueContext;
import antlr.exprParser.Void_methodContext;

public class AntlrToExpression extends exprBaseVisitor<Expression>{

	@Override
	public Expression visitBody(BodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitBody(ctx);
	}

	@Override
	public Expression visitDecl(DeclContext ctx) {
		// TODO Auto-generated method stub
		return super.visitDecl(ctx);
	}

	@Override
	public Expression visitAssi(AssiContext ctx) {
		// TODO Auto-generated method stub
		return super.visitAssi(ctx);
	}

	@Override
	public Expression visitMymethod(MymethodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMymethod(ctx);
	}

	@Override
	public Expression visitMethod_type(Method_typeContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethod_type(ctx);
	}

	@Override
	public Expression visitReturn_method(Return_methodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitReturn_method(ctx);
	}

	@Override
	public Expression visitVoid_method(Void_methodContext ctx) {
		// TODO Auto-generated method stub
		return super.visitVoid_method(ctx);
	}

	@Override
	public Expression visitExpr(ExprContext ctx) {
		// TODO Auto-generated method stub
		return super.visitExpr(ctx);
	}

	@Override
	public Expression visitValue(ValueContext ctx) {
		// TODO Auto-generated method stub
		return super.visitValue(ctx);
	}

	@Override
	public Expression visitR_method_call(R_method_callContext ctx) {
		// TODO Auto-generated method stub
		return super.visitR_method_call(ctx);
	}

	@Override
	public Expression visitIf_statement(If_statementContext ctx) {
		// TODO Auto-generated method stub
		return super.visitIf_statement(ctx);
	}

	@Override
	public Expression visitMethod_body(Method_bodyContext ctx) {
		// TODO Auto-generated method stub
		return super.visitMethod_body(ctx);
	}

	@Override
	public Expression visitCond(CondContext ctx) {
		// TODO Auto-generated method stub
		return super.visitCond(ctx);
	}

}
