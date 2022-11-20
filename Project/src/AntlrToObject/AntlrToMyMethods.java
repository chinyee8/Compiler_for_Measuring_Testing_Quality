package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import antlr.exprBaseVisitor;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import model.Declaration;
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
	public TestMethodCall t_method_call;
	public AntlrToMyMethods(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}
	
	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.mymethod = mymethod;
	}

	AntlrToMyMethods(TestMethodCall t_method_call) {
		// TODO Auto-generated constructor stub
		this.t_method_call = t_method_call;
	}

	@Override
	public MyMethods visitMyMethods(MyMethodsContext ctx) {
		String methodName = ctx.METHODNAME().getText();
		AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.mymethod);

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			MyReturnMethod methodType = (MyReturnMethod) mtVisitor.visit(ctx.getChild(2));
			return new MyMethods(methodName, methodType);
		}
		MyVoidMethod methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
		return new MyMethods(methodName, methodType);


	}
	
	
	public MyMethods control(MyMethodsContext ctx) {
		return null;
	}

}
