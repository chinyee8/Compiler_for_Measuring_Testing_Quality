package AntlrToObject;

import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.Token;

import Operations.ConditionCoverage;
import antlr.exprBaseVisitor;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.VoidMethodCallContext;
import model.Call_Parameter;
import model.MethodCall;
import model.MyMethods;
import model.ReturnMethodCall;
import model.Values;
import model.VoidMethodCall;

public class AntlrToMethodCall extends exprBaseVisitor<MethodCall> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	//condition coverage
	public ConditionCoverage condCov;

	public AntlrToMethodCall(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	//condition coverage
	public AntlrToMethodCall(List<String> semanticErrors, HashMap<String, Values> variableMap, ConditionCoverage condCov) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.condCov = condCov;
	}
	
	@Override
	public MethodCall visitVoidMethodCall(VoidMethodCallContext ctx) { 
		Token token = ctx.VOIDCALL().getSymbol();
		int line = token.getLine();
		String voidCall = ctx.VOIDCALL().getText();
		String methodName = ctx.getChild(1).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new VoidMethodCall(voidCall, methodName, callParam, line);
		
	}
	
	@Override
	public MethodCall visitReturnMethodCall(ReturnMethodCallContext ctx) {
		Token token = ctx.METHODNAME().getSymbol();
		int line = token.getLine();
		String methodName = ctx.getChild(0).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new ReturnMethodCall(methodName, callParam, line);
	}
	
	//Condition Coverage
	public MethodCall visitConditionCoverageV(VoidMethodCallContext ctx) { 
		
		String voidCall = ctx.VOIDCALL().getText();
		String methodName = ctx.getChild(1).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new VoidMethodCall(voidCall, methodName, callParam, 0);
		
	}
	//Condition Coverage
	public MethodCall visitConditionCoverageR(ReturnMethodCallContext ctx) {
		String methodName = ctx.getChild(0).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new ReturnMethodCall(methodName, callParam, 0);
	}
	
	public MethodCall controlV(VoidMethodCallContext ctx) { 
		
		String voidCall = ctx.VOIDCALL().getText();
		String methodName = ctx.getChild(1).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new VoidMethodCall(voidCall, methodName, callParam, 0);
		
	}
	
	public MethodCall controlR(ReturnMethodCallContext ctx) {
		String methodName = ctx.getChild(0).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new ReturnMethodCall(methodName, callParam, 0);
	}
	
	
}
