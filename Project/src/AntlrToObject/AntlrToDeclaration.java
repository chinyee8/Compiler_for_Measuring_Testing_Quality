package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.DeclarationContext;
import model.Declaration;
import model.Values;

public class AntlrToDeclaration extends exprBaseVisitor<Declaration>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;

	
	public ArrayList<Integer>orderOfFlow;
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines; 
	
	public AntlrToDeclaration(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}
		public AntlrToDeclaration(List<String> semanticErrors,HashMap<String, Values> variableMap ) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	@Override
	public Declaration visitDeclaration(DeclarationContext ctx) {
		String varName = ctx.VAR_NAME().getText();
		String dataType = ctx.DATA_TYPE().getText();
		
		return new Declaration(varName, dataType);
	}
	
	
	
	public Declaration control(DeclarationContext ctx) {
		return null;
	}
}
