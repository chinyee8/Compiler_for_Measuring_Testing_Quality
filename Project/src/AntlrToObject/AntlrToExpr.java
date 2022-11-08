package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.RMethodCallContext;
import antlr.exprParser.ValuesContext;
import model.Expr;
import model.MethodCall;
import model.RMethodCall;
import model.ReturnMethodCall;
import model.Values;

public class AntlrToExpr extends exprBaseVisitor<Expr> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToExpr(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}
	
	
	@Override
	public Expr visitRMethodCall(RMethodCallContext ctx) {
		AntlrToMethodCall mVisitor = new AntlrToMethodCall(semanticErrors);
		MethodCall r_method_call = mVisitor.visit(ctx.getChild(0)); 
		return new RMethodCall((ReturnMethodCall) r_method_call);
	}
	
	@Override
	public Expr visitValues(ValuesContext ctx) {
		AntlrToValue vVisitor = new AntlrToValue(semanticErrors);
		Values value = vVisitor.visit(ctx.getChild(0));
		
				
		return value;
	}
}
