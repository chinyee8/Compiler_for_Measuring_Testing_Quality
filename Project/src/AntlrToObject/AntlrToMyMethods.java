package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import antlr.exprBaseVisitor;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import model.Declaration;
import model.IfStatement;
import model.MethodCall;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.TestMethodCall;
import model.Values;

public class AntlrToMyMethods extends exprBaseVisitor<MyMethods>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;

	public ArrayList<Integer>orderOfFlow;
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines;
	public List<MyMethods> mymethod; 
	public MethodCall t_method_call;
	Map<String, Values> inputValues;
	
	public AntlrToMyMethods(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}
	
	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.mymethod = mymethod;
	}

	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod, MethodCall t_method_call, Map<String, Values> inputValues) {
		// TODO Auto-generated constructor stub
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.mymethod = mymethod;
	}

	@Override
	public MyMethods visitMyMethods(MyMethodsContext ctx) {
		String methodName = ctx.METHODNAME().getText();
		AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.mymethod);

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			MyReturnMethod methodType = (MyReturnMethod) mtVisitor.visit(ctx.getChild(2));
			
			Map <String, String> parameter = ((MyReturnMethod)methodType).parameter.getParams();
			for(IfStatement i : ((MyReturnMethod)methodType).method_body.ifStatList) {
					MyMethodBody ifmethod = i.getIfBody();
					for(Declaration d : ifmethod.declList) {
						if(parameter.containsKey(d.varName)) {
							if(!semanticErrors.contains("Error: " + d.varName + " is a parameter of mymethod")) {
								semanticErrors.add("Error: " + d.varName + " is a parameter of mymethod");	
							}
						}
					}
				
			}
			
			return new MyMethods(methodName, methodType);
		}
		MyVoidMethod methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
		Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();
		for(IfStatement i : ((MyVoidMethod)methodType).method_body.ifStatList) {
				MyMethodBody ifmethod = i.getIfBody();
				for(Declaration d : ifmethod.declList) {
					if(parameter.containsKey(d.varName)) {
						if(!semanticErrors.contains("Error: " + d.varName + " is a parameter of mymethod")) {
							semanticErrors.add("Error: " + d.varName + " is a parameter of mymethod");	
						}
					}
				}
			
		}
	
		
		return new MyMethods(methodName, methodType);
	}
	
	
	public MyMethods control(MyMethodsContext ctx) {
		String methodName = ctx.METHODNAME().getText();
		if(methodName.equals(this.t_method_call.getName())) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(this.t_method_call);
			
			if(ctx.getChild(2) instanceof MyReturnMethodContext) {
				MyReturnMethod methodType = (MyReturnMethod) mtVisitor.controlR((MyReturnMethodContext) ctx.getChild(2));
				return new MyMethods(methodName, methodType);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.controlV((MyVoidMethodContext)ctx.getChild(2));
			return new MyMethods(methodName, methodType);
		}
		else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.mymethod);

			if(ctx.getChild(2) instanceof MyReturnMethodContext) {
				MyReturnMethod methodType = (MyReturnMethod) mtVisitor.visit(ctx.getChild(2));
				return new MyMethods(methodName, methodType);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			return new MyMethods(methodName, methodType);


		}
	}

}
