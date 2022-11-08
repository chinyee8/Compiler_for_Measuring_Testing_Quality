package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.IfStatementContext;
import model.Condition;
import model.IfStatement;
import model.MyMethodBody;
public class AntlrToIfStatement extends exprBaseVisitor<IfStatement>  {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToIfStatement(List<String> semanticErrors) {
		this.semanticErrors = new ArrayList<>();
	}
	
	public IfStatement VisitIfStatement(IfStatementContext ctx) {
		
		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors);
		Condition cond = condVisitor.visit(ctx.getChild(2));
		
		AntlrToMyMethodBody ifBodyVisitor = new AntlrToMyMethodBody(semanticErrors);
		MyMethodBody ifBody = ifBodyVisitor.visit(ctx.getChild(5));
		
		AntlrToMyMethodBody elseBodyVisitor = new AntlrToMyMethodBody(semanticErrors);
		MyMethodBody elseBody = elseBodyVisitor.visit(ctx.getChild(9));
		
		return new IfStatement(cond,ifBody,elseBody);
	}
}
