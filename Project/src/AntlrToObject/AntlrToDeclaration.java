package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.DeclarationContext;
import model.Declaration;

public class AntlrToDeclaration extends exprBaseVisitor<Declaration>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	public AntlrToDeclaration(List<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}
	
	@Override
	public Declaration visitDeclaration(DeclarationContext ctx) {
		String varName = ctx.VAR_NAME().getText();
		String dataType = ctx.DATA_TYPE().getText();
		
		return new Declaration(varName, dataType);
	}
}
