package AntlrToObject;

import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.TestMethodCallContext;
import model.Call_Parameter;
import model.TestMethodCall;
import model.Values;

public class AntlrToTestMethodCall extends exprBaseVisitor<TestMethodCall> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	
	public AntlrToTestMethodCall(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}

	@Override
	public TestMethodCall visitTestMethodCall(TestMethodCallContext ctx) {
		String className = ctx.getChild(0).getText();
		String methodName = ctx.getChild(2).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.getChild(4));
		return new TestMethodCall(className, methodName, callParam);
		
	}
}
