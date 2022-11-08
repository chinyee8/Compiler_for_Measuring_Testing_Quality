package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;

public class AntlrToMyMethods extends exprBaseVisitor<MyMethods>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;


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

}
