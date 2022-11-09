package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssignmentContext;
import model.Assignment;
import model.Expr;

public class AntlrToAssignment extends exprBaseVisitor<Assignment>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToAssignment(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}
	
	@Override
	public Assignment visitAssignment(AssignmentContext ctx) {
		String varName = ctx.VAR_NAME().getText();
		AntlrToExpr eVisitor = new AntlrToExpr(semanticErrors);
		Expr expr = eVisitor.visit(ctx.getChild(2));
		
		return new Assignment(varName, expr); 
	}
}
