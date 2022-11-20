package AntlrToObject;

import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.exprBaseVisitor;
import antlr.exprParser.RMethodCallContext;
import antlr.exprParser.ValuesContext;
import model.Expr;
import model.MethodCall;
import model.Values;

public class AntlrToExpr extends exprBaseVisitor<Expr> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	
	
	public AntlrToExpr(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	
	public AntlrToExpr() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Expr visitRMethodCall(RMethodCallContext ctx) {
		AntlrToMethodCall mVisitor = new AntlrToMethodCall(semanticErrors, this.variableMap);
		MethodCall ReturnMethodCall = mVisitor.visit(ctx.getChild(0)); 
		return ReturnMethodCall;
	}
	
	@Override
	public Expr visitValues(ValuesContext ctx) {
		AntlrToValue vVisitor = new AntlrToValue(semanticErrors, this.variableMap);
		Values value = vVisitor.visit(ctx.getChild(0));
		
				
		return value;
	}


	public Expr controlR(RMethodCallContext ctx) {
		AntlrToMethodCall mVisitor = new AntlrToMethodCall(semanticErrors, this.variableMap);
		MethodCall ReturnMethodCall = mVisitor.visit(ctx.getChild(0)); 
		return ReturnMethodCall;
	}
	
	public Expr controlV(ValuesContext ctx) {
		AntlrToValue vVisitor = new AntlrToValue(semanticErrors, this.variableMap);
		Values value = vVisitor.visit(ctx.getChild(0));
		
				
		return value;
	}
}
