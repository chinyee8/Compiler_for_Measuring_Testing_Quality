package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.ParamsContext;
import model.Params;

public class AntlrToParams extends exprBaseVisitor<Params>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToParams(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}

	@Override
	public Params visitParams(ParamsContext ctx) {
		String dataType = ctx.DATA_TYPE().getText();
		String varName = ctx.VAR_NAME().getText();
		return new Params(dataType, varName);
	}
	
	
}
