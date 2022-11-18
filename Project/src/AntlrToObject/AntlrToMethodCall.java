package AntlrToObject;

import java.util.HashMap;
import java.util.List;

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

	public AntlrToMethodCall(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	@Override
	public MethodCall visitVoidMethodCall(VoidMethodCallContext ctx) { 
		
		String voidCall = ctx.VOIDCALL().getText();
		String methodName = ctx.getChild(1).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new VoidMethodCall(voidCall, methodName, callParam);
		
	}
	
	@Override
	public MethodCall visitReturnMethodCall(ReturnMethodCallContext ctx) {
		String methodName = ctx.getChild(0).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.call_parameter());
		return new ReturnMethodCall(methodName, callParam);
	}
}
