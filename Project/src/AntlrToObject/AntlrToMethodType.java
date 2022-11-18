package AntlrToObject;

import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import model.MethodType;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Parameter;
import model.Values;

public class AntlrToMethodType extends exprBaseVisitor<MethodType> {
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public List<MyMethods> mymethod;

	public AntlrToMethodType(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.mymethod = mymethod;
	}

	@Override
	public MethodType visitMyReturnMethod(MyReturnMethodContext ctx) {
		String dataType = ctx.DATA_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.mymethod);
		MyMethodBody method_body = method_bodyVisitor.visit(ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText();
		
		return new MyReturnMethod(dataType, parameter, method_body, varName);
	}
	
	@Override
	public MethodType visitMyVoidMethod(MyVoidMethodContext ctx) {
		String void_type = ctx.VOID_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.mymethod);
		MyMethodBody method_body = method_bodyVisitor.visit(ctx.method_body());
		return new MyVoidMethod(void_type, parameter, method_body);
	}

}
