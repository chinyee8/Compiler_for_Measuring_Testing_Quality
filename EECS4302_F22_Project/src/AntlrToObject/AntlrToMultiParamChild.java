package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.MultiParamChildContext;
import model.MultiParamChild;
import model.Params;

public class AntlrToMultiParamChild extends exprBaseVisitor<MultiParamChild>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToMultiParamChild(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}

	@Override
	public MultiParamChild visitMultiParamChild(MultiParamChildContext ctx) {
		AntlrToParams pVisitor = new AntlrToParams(semanticErrors);
		Params params = pVisitor.visit(ctx.param());
		return new MultiParamChild(params);
	}
	
	
}
