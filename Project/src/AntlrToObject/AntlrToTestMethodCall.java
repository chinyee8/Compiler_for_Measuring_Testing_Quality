package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.TestMethodCallContext;
import model.CallParameter;
import model.Declaration;
import model.TestMethodCall;

public class AntlrToTestMethodCall extends exprBaseVisitor<TestMethodCall> {

	public TestMethodCall VisitTestMethodCall(TestMethodCallContext ctx) {
		String className = ctx.getChild(1).getText();
		String methodName = ctx.getChild(3).getText();
		AntlrToCallParameter callParamVisitor = new AntlrToCallParameter();
		CallParameter callParam = callParamVisitor.visit(ctx.getChild(4));
		return new TestMethodCall(className, methodName, callParam);
		
	}
}
