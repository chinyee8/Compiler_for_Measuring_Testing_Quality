package AntlrToObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.GameClassContext;
import model.GameBody;
import model.GameClass;
import model.MethodCall;
import model.TestMethodCall;
import model.Values;

public class AntlrToGameClass extends exprBaseVisitor<GameClass>{
	public List<String> semanticErrors; 
	
	//controller fields
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines;
	public ArrayList<Integer> orderOfFlow;
	public AntlrToGameBody gbController;
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public List<String> methodCallParamOrder;
	
	public AntlrToGameClass() {
		
	}
	public AntlrToGameClass(ArrayList<String>[] tokenLines, ArrayList<Integer> order) {
		this.tokensMappedToLines = tokenLines;
		this.orderOfFlow = order;
	}
	public AntlrToGameClass(List<String> semanticError) {
		this.semanticErrors = semanticError;
	}
	
	public AntlrToGameClass(List<String> semanticError, MethodCall t_method_call2, Map<String, Values> inputValues, List<String> methodCallParamOrder) {
		this.t_method_call = t_method_call2;
		this.semanticErrors = semanticError;
		this.inputValues = inputValues;
		this.methodCallParamOrder = methodCallParamOrder;
	}
	@Override
	public GameClass visitGameClass(GameClassContext ctx) {
		String className = ctx.CLASS_NAME().getText();
		AntlrToGameBody gbVisitor = new AntlrToGameBody(semanticErrors);
		GameBody gamebody = gbVisitor.visit(ctx.body());
		return new GameClass(className, gamebody);
	}
	
	
	public GameClass control(GameClassContext ctx) {
//		this.rangeOfLines = new int[2];
//		Token start = ctx.getStart();
//		Token end = ctx.getStop();
//		this.rangeOfLines[0]=start.getLine()-1;
//		this.rangeOfLines[1]=end.getLine()-1;
//		for(int i = 0; i < ctx.getChildCount()-1; i++) {
//			if(ctx.getChild(i) instanceof TerminalNode) {
//				this.tokensMappedToLines[start.getLine()-1].add(ctx.getChild(i).getText());
//			}
//			
//		}
//		//add first line executed to order
//		this.orderOfFlow.add(start.getLine()-1);
//		this.tokensMappedToLines[end.getLine()-1].add(ctx.getChild(6).getText());
		String className = ctx.CLASS_NAME().getText();
		AntlrToGameBody gbController = new AntlrToGameBody(semanticErrors, this.t_method_call, this.inputValues, this.methodCallParamOrder);
		GameBody gamebody = gbController.control((GameBodyContext)ctx.getChild(5));
		this.gbController = gbController;
		//after all the other lines added to order, add last line to close class body
//		this.orderOfFlow.add(end.getLine()-1);
		return new GameClass(className, gamebody);
	}

}
