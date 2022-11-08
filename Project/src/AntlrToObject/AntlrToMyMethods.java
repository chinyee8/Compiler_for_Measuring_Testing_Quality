package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.MyMethodsContext;
import model.MethodType;
import model.MyMethods;

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
		MethodType methodType = mtVisitor.visit(ctx.method_type());
	}

}
