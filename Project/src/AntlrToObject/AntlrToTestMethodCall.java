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
		String methodName = ctx.getChild(0).getText();
		AntlrToCall_Parameter callParamVisitor = new AntlrToCall_Parameter(semanticErrors, this.variableMap);
		Call_Parameter callParam = callParamVisitor.visit(ctx.getChild(2));
		return new TestMethodCall(methodName, callParam);
		
	}
}
