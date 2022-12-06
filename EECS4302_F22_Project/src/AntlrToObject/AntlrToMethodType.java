package AntlrToObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import Operations.ConditionCoverage;
import antlr.exprBaseVisitor;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import model.*;

public class AntlrToMethodType extends exprBaseVisitor<MethodType> {
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public List<MyMethods> global_mymethods;
	public MethodCall t_method_call; //transform
	public Map<String, Values> inputValues; //transform
	public List<String> methodCallParamOrder; //transform
	public Values returnValue;
	
	//defCoverage
	
	
	// condition coverage
	public ConditionCoverage condCov;

	public AntlrToMethodType(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
	}

	public AntlrToMethodType(MethodCall t_method_call, Map<String, Values> inputValues, List<String> methodCallParamOrder, List<MyMethods> global_mymethods, HashMap<String, Values> varMap) {
		// TODO Auto-generated constructor stub
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.methodCallParamOrder = methodCallParamOrder;
		this.global_mymethods = global_mymethods;
		this.variableMap = varMap;
	}
	// Condition Coverage
	public AntlrToMethodType(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, ConditionCoverage condCov) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;

		this.methodCallParamOrder = condCov.getMethodCallParamOrder();
		this.condCov = condCov;
		/*
		if (!condCov.isComponentState()) {
			this.t_method_call = condCov.getTestMethod().getKey();
			this.inputValues = condCov.getTestMethod().getValue();
		}*/
	}
	
	//defCoverage
	public AntlrToMethodType(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, MethodCall t_method_call, Map<String, Values> inputValues) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;

	}

	@Override
	public MethodType visitMyReturnMethod(MyReturnMethodContext ctx) {
		String dataType = ctx.DATA_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.global_mymethods);
		MyMethodBody method_body = method_bodyVisitor.visit(ctx.method_body());
		//ifVisitor.visitConditionCoverage((MyMethodBodyContext)ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText();
		Token token = ctx.VAR_NAME().getSymbol();
		int line = token.getLine();
		
		return new MyReturnMethod(dataType, parameter, method_body, varName, line);
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

	// Condition Coverage
	public void visitConditionCoverage(MyReturnMethodContext ctx) {
		
		String dataType = ctx.DATA_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter arguments = pVisitor.visit(ctx.parameter());
	
		if(!condCov.isComponentState() && condCov.isCalledMethod()) {
			HashMap<String, Values> parameterTransformation = transform(arguments);
			this.variableMap.putAll(parameterTransformation);
		}

		AntlrToMyMethodBody ifVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.global_mymethods, condCov);
		ifVisitor.visitConditionCoverage((MyMethodBodyContext)ctx.method_body());
		
	}
	// Condition Coverage
	public void visitConditionCoverage(MyVoidMethodContext ctx) {
		String void_type = ctx.VOID_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter arguments = pVisitor.visit(ctx.parameter());
		
		HashMap<String, Values> parameterTransformation = transform(arguments);
		this.variableMap.putAll(parameterTransformation);
		
		AntlrToMyMethodBody ifVisitor = new AntlrToMyMethodBody(semanticErrors, this.variableMap, this.global_mymethods, condCov);
		ifVisitor.visitConditionCoverage((MyMethodBodyContext)ctx.method_body());

	}
	
	public MyReturnMethod controlR(MyReturnMethodContext ctx) {
		// TODO Auto-generated method stub
		String dataType = ctx.DATA_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter();
		Parameter arguments = pVisitor.visit(ctx.parameter());
		
		HashMap<String, Values> parameterTransformation = transform(arguments);
		this.variableMap.putAll(parameterTransformation);
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(this.variableMap, this.returnValue, this.global_mymethods);
		MyMethodBody method_body = method_bodyVisitor.control((MyMethodBodyContext)ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText(); //return variable
		Values returnValue = this.variableMap.get(varName);
		this.returnValue = returnValue;
		Token token = ctx.VAR_NAME().getSymbol();
		int line = token.getLine();
		
		return new MyReturnMethod(dataType, arguments, method_body, varName, this.returnValue, line);
		}

	public HashMap<String, Values> transform(Parameter argument){ //transform call parameters into method arguments
		List<String> orderOfArguments = null;
		HashMap<String, Values> newMap = new HashMap();
		if(argument instanceof SingleParam) {
			argument.getParams(); //leave unassigned: to get other functions in method called
			orderOfArguments = ((SingleParam)argument).orderOfParams();
		}
		else if(argument instanceof EmptyParam) {
			argument.getParams();
			orderOfArguments = ((MultiParam)argument).orderOfParams();

		}
		else if(argument instanceof MultiParam) {
			argument.getParams();
			orderOfArguments = ((MultiParam)argument).orderOfParams();

		}
		for(int i = 0; i < orderOfArguments.size(); i++) {
			newMap.put(orderOfArguments.get(i), this.inputValues.get(this.methodCallParamOrder.get(i)));
		}
		
		return newMap;
		
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

	public MyReturnMethod defControlR(MyReturnMethodContext ctx) {
		String dataType = ctx.DATA_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues); 
		MyMethodBody method_body = method_bodyVisitor.defControl((MyMethodBodyContext)ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText();
		Token token = ctx.VAR_NAME().getSymbol();
		int line = token.getLine();
		
		return new MyReturnMethod(dataType, parameter, method_body, varName, line);
	}

	public MyVoidMethod defControlV(MyVoidMethodContext ctx) {
		String void_type = ctx.VOID_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues); 
		MyMethodBody method_body = method_bodyVisitor.defControl((MyMethodBodyContext)ctx.method_body());
		return new MyVoidMethod(void_type, parameter, method_body);
	}

	
	
	

}
