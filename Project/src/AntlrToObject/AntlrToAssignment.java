package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.RMethodCallContext;
import antlr.exprParser.ValuesContext;
import model.Assignment;
import model.Expr;
import model.MyMethods;
import model.Values;

public class AntlrToAssignment extends exprBaseVisitor<Assignment>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	
	//control flow fields
	public ArrayList<Integer>orderOfFlow;
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines;
	public List<MyMethods> global_mymethods; 
	
	
	public AntlrToAssignment(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}
	
	public AntlrToAssignment(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
	}
	
	public AntlrToAssignment(List<String> semanticErrors, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
	}

	public AntlrToAssignment() {
		// TODO Auto-generated constructor stub
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
		
		String varName = ctx.VAR_NAME().getText();
		AntlrToExpr eController = new AntlrToExpr(this.variableMap);
		Expr expr = null;
		if(ctx.getChild(2) instanceof RMethodCallContext) {
			expr = eController.controlR((RMethodCallContext)ctx.getChild(2));

		}
		else if (ctx.getChild(2) instanceof ValuesContext) {
			expr = eController.visit((ValuesContext)ctx.getChild(2));

		}
			
		return new Assignment(varName, expr); 
	}
}
