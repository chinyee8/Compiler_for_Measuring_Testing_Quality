package AntlrToObject;

import antlr.exprBaseVisitor;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.VoidMethodCallContext;
import model.CallParameter;
import model.MethodCall;
import model.ReturnMethodCall;
import model.VoidMethodCall;

public class AntlrToMethodCall extends exprBaseVisitor<MethodCall> {
	public MethodCall visitVoidMethodCall(VoidMethodCallContext ctx) { 
		
		String className = ctx.getChild(0).getText();
		String methodName = ctx.getChild(1).getText();
		AntlrToCallParameter callParamVisitor = new AntlrToCallParameter();
		CallParameter callParam = callParamVisitor.visit(ctx.getChild(3));
		return new VoidMethodCall(className, methodName, callParam);
		
	}
	
	public MethodCall visitReturnMethodCall(ReturnMethodCallContext ctx) {
		String methodName = ctx.getChild(0).getText();
		AntlrToCallParameter callParamVisitor = new AntlrToCallParameter();
		CallParameter callParam = callParamVisitor.visit(ctx.getChild(2));
		return new ReturnMethodCall(methodName, callParam);
	}
}
