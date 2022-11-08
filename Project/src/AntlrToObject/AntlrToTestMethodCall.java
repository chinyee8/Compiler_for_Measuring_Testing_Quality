package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.TestMethodCallContext;
import model.Call_Parameter;
import model.TestMethodCall;

public class AntlrToTestMethodCall extends exprBaseVisitor<TestMethodCall> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToTestMethodCall(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}

	@Override
	public TestMethodCall visitTestMethodCall(TestMethodCallContext ctx) {
		String className = ctx.getChild(0).getText();
		String methodName = ctx.getChild(2).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors);
		Call_Parameter callParam = callParamVisitor.visit(ctx.getChild(4));
		return new TestMethodCall(className, methodName, callParam);
		
	}
}
