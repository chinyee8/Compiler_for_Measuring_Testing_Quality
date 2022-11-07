package AntlrToObject;

import antlr.exprBaseVisitor;
import antlr.exprParser.IfStatementContext;
import model.Condition;
import model.IfStatement;
import model.MyMethodBody;
public class AntlrToIfStatement extends exprBaseVisitor<IfStatement>  {
	
	public IfStatement VisitIfStatement(IfStatementContext ctx) {
		
		AntlrToCondition condVisitor = new AntlrToCondition();
		Condition cond = condVisitor.visit(ctx.getChild(2));
		
		AntlrToMyMethodBody ifBodyVisitor = new AntlrToMyMethodBody();
		MyMethodBody ifBody = ifBodyVisitor.visit(ctx.getChild(5));
		
		AntlrToMyMethodBody elseBodyVisitor = new AntlrToMyMethodBody();
		MyMethodBody elseBody = elseBodyVisitor.visit(ctx.getChild(9));
		
		return new IfStatement(cond,ifBody,elseBody);
	}
}
