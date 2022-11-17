package AntlrToObject;

import java.util.ArrayList;
import java.util.List;
import antlr.exprBaseVisitor;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import model.Declaration;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;

public class AntlrToMyMethods extends exprBaseVisitor<MyMethods>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;

	public ArrayList<Integer>orderOfFlow;
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines; 
	
	public AntlrToMyMethods(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}
	
	public AntlrToMyMethods(List<String> semanticError) {
		this.semanticErrors = semanticError;
	}

	@Override
	public MyMethods visitMyMethods(MyMethodsContext ctx) {
		String methodName = ctx.METHODNAME().getText();
		AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors);

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
