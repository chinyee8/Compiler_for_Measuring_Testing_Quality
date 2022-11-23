package AntlrToObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antlr.exprBaseVisitor;
import antlr.exprParser.IfStatementContext;
import antlr.exprParser.MyMethodBodyContext;
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
import model.MethodCall;
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
	
	//DefCoverage
		public Map<String, Boolean> def;
		public Map<Map<Integer, Map<String, Boolean>>, List<Integer>>  def_use;
		public Map<Integer, Map<String, Boolean>> linesDef;
		public List<Integer> linesUse;
		public MethodCall t_method_call;
		public Map<String, Values> inputValues;
		public List<String> lines;
		public int totalNotUsed;

	public AntlrToIfStatement(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, HashMap<String, Values> local_methodVar) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.local_methodVar = local_methodVar;
	}
	
	//defCoverage
	public AntlrToIfStatement(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, MethodCall t_method_call, Map<String, Values> inputValues, Map<String, Boolean> def, Map<Map<Integer, Map<String, Boolean>>, List<Integer>>  def_use,Map<Integer, Map<String, Boolean>> linesDef, HashMap<String, Values> local_methodVar, List<Integer> linesUse, List<String> lines, int totalNotUsed) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.def = def;
		this.def_use = def_use;
		this.linesDef = linesDef;
		this.local_methodVar = local_methodVar;
		this.linesUse = linesUse;
		this.lines = lines;
		this.totalNotUsed = totalNotUsed;
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

	
	public IfStatement control(IfStatementContext ctx) {
		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors, this.variableMap);
		Condition cond = condVisitor.visit(ctx.cond());

		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors,this.variableMap, this.global_mymethods, this.local_methodVar);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.getChild(5));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.getChild(9));

		
		IfStatement temp = new IfStatement(cond,ifBody,elseBody, semanticErrors);
		boolean ifEvaluator = temp.evaluated(cond, variableMap);
		if(ifEvaluator) {
			AntlrToMyMethodBody BodyController = new AntlrToMyMethodBody(this.semanticErrors, this.variableMap, this.global_mymethods, this.local_methodVar);
			MyMethodBody newIfBody = BodyController.control((MyMethodBodyContext) ctx.getChild(5));
			return new IfStatement(cond, newIfBody, elseBody, semanticErrors);
		}
		else {
			AntlrToMyMethodBody BodyController = new AntlrToMyMethodBody(this.semanticErrors, this.variableMap, this.global_mymethods, this.local_methodVar);
			MyMethodBody newElseBody = BodyController.control((MyMethodBodyContext) ctx.getChild(9));
			return new IfStatement(cond, newElseBody, elseBody, semanticErrors);
		}
	}

	public IfStatement defControl(IfStatementContext ctx) {
		AntlrToCondition condVisitor = new AntlrToCondition(semanticErrors, this.variableMap);
		Condition cond = condVisitor.visit(ctx.cond());

		AntlrToMyMethodBody BodyVisitor = new AntlrToMyMethodBody(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues, def, def_use, linesDef, this.local_methodVar, linesUse, lines, totalNotUsed);

		MyMethodBody ifBody = BodyVisitor.visit(ctx.getChild(5));
		MyMethodBody elseBody = BodyVisitor.visit(ctx.getChild(9));

		return new IfStatement(cond,ifBody,elseBody, semanticErrors);
	}
	
}
