package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssignmentContext;
import model.Assignment;
import model.Expr;
import model.Values;

public class AntlrToAssignment extends exprBaseVisitor<Assignment>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;

	//control flow fields
	public ArrayList<Integer>orderOfFlow;
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines; 
	
	
	public AntlrToAssignment(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}
	
	public AntlrToAssignment(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}
	
	@Override
	public Assignment visitAssignment(AssignmentContext ctx) {
		String varName = ctx.VAR_NAME().getText();
		AntlrToExpr eVisitor = new AntlrToExpr(semanticErrors, this.variableMap);
		Expr expr = eVisitor.visit(ctx.getChild(2));
		
		return new Assignment(varName, expr); 
	}
	
	
	//controlller
	public Assignment control(AssignmentContext ctx) {
		
		return null;
	}
}
