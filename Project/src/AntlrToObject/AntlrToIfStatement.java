package AntlrToObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antlr.exprBaseVisitor;
import antlr.exprParser.IfStatementContext;
import model.Addition;
import model.CondBool;
import model.CondEqual;
import model.CondNotEqual;
import model.CondParenthesis;
import model.CondVarName;
import model.Condition;
import model.Conjunction;
import model.Disjunction;
import model.Division;
import model.EqualTo;
import model.IfStatement;
import model.Less;
import model.LessOrEqual;
import model.MathDouble;
import model.MathNumber;
import model.MathParenthesis;
import model.MathVarName;
import model.Mathematics;
import model.More;
import model.MoreOrEqual;
import model.Multiplication;
import model.MyMethodBody;
import model.MyMethods;
import model.Negation;
import model.NotEqualTo;
import model.Subtraction;
import model.ValueBool;
import model.Values;
public class AntlrToIfStatement extends exprBaseVisitor<IfStatement>  {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public List<MyMethods> global_mymethods;
	public HashMap<String, Values> local_methodVar;

	public AntlrToIfStatement(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, HashMap<String, Values> local_methodVar) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.local_methodVar = local_methodVar;
	}

	@Override
	public IfStatement visitIfStatement(IfStatementContext ctx) {

		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors, this.variableMap);
		Condition cond = condVisitor.visit(ctx.cond());

		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors,this.variableMap, this.global_mymethods, this.local_methodVar);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.getChild(5));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.getChild(9));

		return new IfStatement(cond,ifBody,elseBody, semanticErrors);

	}

	
}
