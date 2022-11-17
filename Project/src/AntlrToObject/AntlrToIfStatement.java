package AntlrToObject;

import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.IfStatementContext;
import model.Condition;
import model.IfStatement;
import model.MyMethodBody;
import model.Values;
public class AntlrToIfStatement extends exprBaseVisitor<IfStatement>  {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public AntlrToIfStatement(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	@Override
	public IfStatement visitIfStatement(IfStatementContext ctx) {

		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors, this.variableMap);
		Condition cond = condVisitor.visit(ctx.cond());
		
		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors,this.variableMap);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.getChild(5));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.getChild(9));

		return new IfStatement(cond,ifBody,elseBody);

	}
}
