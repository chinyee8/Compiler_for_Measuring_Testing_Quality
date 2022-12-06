package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.EmptyParamContext;
import antlr.exprParser.MultiParamContext;
import antlr.exprParser.SingleParamContext;
import model.EmptyParam;
import model.MultiParam;
import model.MultiParamChild;
import model.Parameter;
import model.Params;
import model.SingleParam;

public class AntlrToParameter extends exprBaseVisitor<Parameter>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToParameter(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}
	
	public AntlrToParameter() {
	}

	@Override
	public Parameter visitSingleParam(SingleParamContext ctx) {
		AntlrToParams pVisitor = new AntlrToParams(semanticErrors);
		Params param = pVisitor.visit(ctx.getChild(0));
		return new SingleParam(param);
	}

	@Override
	public Parameter visitMultiParam(MultiParamContext ctx) {
		AntlrToParams pVisitor = new AntlrToParams(semanticErrors);
		Params param = pVisitor.visit(ctx.getChild(0));
		
		AntlrToMultiParamChild mVisitor = new AntlrToMultiParamChild(semanticErrors);
		List<MultiParamChild> multi_param = new ArrayList<>();
		for(int i = 0; i < ctx.multi_param().size(); i++) {
			multi_param.add(mVisitor.visit(ctx.multi_param(i)));
			
		}
		
		return new MultiParam(param, multi_param);
	}

	@Override
	public Parameter visitEmptyParam(EmptyParamContext ctx) {
		return new EmptyParam();
	}
	
}
