package AntlrToObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

import antlr.exprBaseVisitor;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import model.Call_Parameter;
import model.MethodCall;
import model.MethodType;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Parameter;
import model.TestMethodCall;
import model.Values;

public class AntlrToMethodType extends exprBaseVisitor<MethodType> {
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public List<MyMethods> global_mymethods;
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public List<String> methodCallParamOrder;
	
	public AntlrToMethodType(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
	}

	public AntlrToMethodType(MethodCall t_method_call, Map<String, Values> inputValues, List<String> methodCallParamOrder) {
		// TODO Auto-generated constructor stub
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.methodCallParamOrder = methodCallParamOrder;
	}

	@Override
	public MethodType visitMyReturnMethod(MyReturnMethodContext ctx) {
		String dataType = ctx.DATA_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.global_mymethods);
		MyMethodBody method_body = method_bodyVisitor.visit(ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText();
		
		return new MyReturnMethod(dataType, parameter, method_body, varName);
	}
	
	@Override
	public MethodType visitMyVoidMethod(MyVoidMethodContext ctx) {
		String void_type = ctx.VOID_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.global_mymethods);
		MyMethodBody method_body = method_bodyVisitor.visit(ctx.method_body());
		return new MyVoidMethod(void_type, parameter, method_body);
	}

	public MyReturnMethod controlR(MyReturnMethodContext ctx) {
		// TODO Auto-generated method stub
		String dataType = ctx.DATA_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter();
		Parameter parameter = pVisitor.visit(ctx.parameter());
		
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(t_method_call, inputValues);
		MyMethodBody method_body = method_bodyVisitor.visit(ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText();
		
		return new MyReturnMethod(dataType, parameter, method_body, varName);
		}

	public HashMap<String, Values> transform(Call_Parameter c){
//		if (c instanceof )
		
		return null;
		
	}
	public MyVoidMethod controlV(ParseTree ctx) {
//		String void_type = ctx.VOID_TYPE().getText();
//		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
//		Parameter parameter = pVisitor.visit(ctx.parameter());
//		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.global_mymethods);
//		MyMethodBody method_body = method_bodyVisitor.visit(ctx.method_body());
//		return new MyVoidMethod(void_type, parameter, method_body);
		
		return null;
	}
	
	

}
