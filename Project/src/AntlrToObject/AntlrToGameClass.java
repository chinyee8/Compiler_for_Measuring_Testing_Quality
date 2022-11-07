package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.AdditionContext;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.CallEmptyParameterContext;
import antlr.exprParser.CallMultiParameterContext;
import antlr.exprParser.CallParamCharContext;
import antlr.exprParser.CallParamCondContext;
import antlr.exprParser.CallParamDoubleContext;
import antlr.exprParser.CallParamMathContext;
import antlr.exprParser.CallParamNumContext;
import antlr.exprParser.CallParamStringContext;
import antlr.exprParser.CallParamVarNameContext;
import antlr.exprParser.CallParameterContext;
import antlr.exprParser.CondBoolContext;
import antlr.exprParser.CondEqualContext;
import antlr.exprParser.CondNotEqualContext;
import antlr.exprParser.CondParenthesisContext;
import antlr.exprParser.CondVarNameContext;
import antlr.exprParser.ConjunctionContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.DisjunctionContext;
import antlr.exprParser.DivisionContext;
import antlr.exprParser.EmptyParamContext;
import antlr.exprParser.EqualToContext;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.IfStatementContext;
import antlr.exprParser.LessContext;
import antlr.exprParser.LessOrEqualContext;
import antlr.exprParser.MathDoubleContext;
import antlr.exprParser.MathNumberContext;
import antlr.exprParser.MathParenthesisContext;
import antlr.exprParser.MathVarNameContext;
import antlr.exprParser.MoreContext;
import antlr.exprParser.MoreOrEqualContext;
import antlr.exprParser.MultiParamChildContext;
import antlr.exprParser.MultiParamContext;
import antlr.exprParser.MultipleInputContext;
import antlr.exprParser.MultiplicationContext;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import antlr.exprParser.NegationContext;
import antlr.exprParser.NotEqualToContext;
import antlr.exprParser.ParamsContext;
import antlr.exprParser.RMethodCallContext;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.SingleParamContext;
import antlr.exprParser.SubtractionContext;
import antlr.exprParser.TestCaseContext;
import antlr.exprParser.TestMethodCallContext;
import antlr.exprParser.ValueBoolContext;
import antlr.exprParser.ValueCharContext;
import antlr.exprParser.ValueDoubleContext;
import antlr.exprParser.ValueMathContext;
import antlr.exprParser.ValueNumContext;
import antlr.exprParser.ValueStringContext;
import antlr.exprParser.ValuesContext;
import antlr.exprParser.VoidMethodCallContext;
import model.GameBody;
import model.GameClass;

public class AntlrToGameClass extends exprBaseVisitor<GameClass>{
	
	public List<String> semanticErrors; 
	//public List<Integer> linesCovered;
	
	public AntlrToGameClass(List<String> semanticError) {
		this.semanticErrors = semanticError;
	}
	
	public GameClass visitGameClass(GameClassContext ctx) {
		AntlrToGameBody gbVisitor = new AntlrToGameBody(semanticErrors);
		String className = ctx.getChild(1).getText();
		GameBody gameBody = gbVisitor.visit(ctx.getChild(5));
		
		return new GameClass(className, gameBody);
	}
} 
