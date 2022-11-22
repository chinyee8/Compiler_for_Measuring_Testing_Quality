package AntlrToObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;

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
	public Map<String, Boolean> def;
	public Map<Map<Integer, Map<String, Boolean>>, List<Integer>>  def_use;
	public Map<Integer, Map<String, Boolean>> linesDef;
	public List<Integer> linesUse;
	public List<String> lines;

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
	
	//defCoverage
		public AntlrToMethodType(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, MethodCall t_method_call, Map<String, Values> inputValues, Map<String, Boolean> def, Map<Map<Integer, Map<String, Boolean>>, List<Integer>>  def_use,Map<Integer, Map<String, Boolean>> linesDef, List<Integer> linesUse, List<String> lines) {
			this.semanticErrors = semanticError;
			this.variableMap = variableMap;
			this.global_mymethods = global_mymethods;
			this.t_method_call = t_method_call;
			this.inputValues = inputValues;
			this.def = def;
			this.def_use = def_use;
			this.linesDef = linesDef;
			this.linesUse = linesUse;
			this.lines = lines;
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
		Parameter arguments = pVisitor.visit(ctx.parameter());
		
		HashMap<String, Values> parameterTransformation = transform(arguments);
		this.variableMap.putAll(parameterTransformation);
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(this.variableMap, this.returnValue, this.global_mymethods);
		MyMethodBody method_body = method_bodyVisitor.control((MyMethodBodyContext)ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText(); //return variable
		Values returnValue = this.variableMap.get(varName);
		this.returnValue = returnValue;
		return new MyReturnMethod(dataType, arguments, method_body, varName, this.returnValue);
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
		
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues, def, def_use, linesDef, linesUse, lines);
		MyMethodBody method_body = method_bodyVisitor.defControl((MyMethodBodyContext)ctx.method_body());
		
		String varName = ctx.VAR_NAME().getText();
		
		return new MyReturnMethod(dataType, parameter, method_body, varName);
	}

	public MyVoidMethod defControlV(MyVoidMethodContext ctx) {
		String void_type = ctx.VOID_TYPE().getText();
		AntlrToParameter pVisitor = new AntlrToParameter(semanticErrors);
		Parameter parameter = pVisitor.visit(ctx.parameter());
		AntlrToMyMethodBody method_bodyVisitor = new AntlrToMyMethodBody(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues, def, def_use, linesDef, linesUse, lines);
		MyMethodBody method_body = method_bodyVisitor.defControl((MyMethodBodyContext)ctx.method_body());
		return new MyVoidMethod(void_type, parameter, method_body);
	}

	
	
	

}
