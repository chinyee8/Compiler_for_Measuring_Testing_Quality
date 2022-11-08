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
		this.semanticErrors = semanticErrors;
	}
	
	@Override
	public IfStatement visitIfStatement(IfStatementContext ctx) {

		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors);
		Condition cond = condVisitor.visit(ctx.cond());
		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.method_body(0));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.method_body(1));

		return new IfStatement(cond,ifBody,elseBody);

	}
}
