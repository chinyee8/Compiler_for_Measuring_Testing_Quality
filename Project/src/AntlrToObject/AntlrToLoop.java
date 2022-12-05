package AntlrToObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.Deterministic_LoopContext;
import antlr.exprParser.MyMethodBodyContext;
import model.Loop;
import model.MyMethodBody;
import model.MyMethods;
import model.Values;

public class AntlrToLoop extends exprBaseVisitor<Loop>{

	List<String> semanticErrors;
	HashMap<String, Values> variableMap;
	List<MyMethods> global_mymethods;
	List<MyMethodBody> mb;
	
	public AntlrToLoop(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> mymethods) {
		// TODO Auto-generated constructor stub
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = mymethods;
		this.mb = new LinkedList<>();
	}


	@Override
	public Loop visitDeterministic_Loop(Deterministic_LoopContext ctx) {
		// TODO Auto-generated method stub
		int iterationGoal = Integer.valueOf(Integer.valueOf(ctx.getChild(2).getText()));
		if(iterationGoal < 0) {
			Token t = ctx.NUM().getSymbol();
			int line = t.getLine();
			int column = t.getCharPositionInLine();
			this.semanticErrors.add("Error [ Line "+line +", "+ column+" ] : Number of iteration in loop must be positive");
		}
		AntlrToMyMethodBody mbVisitor = new AntlrToMyMethodBody(this.semanticErrors, this.variableMap, this.global_mymethods);
		MyMethodBody mb = null;
		if(ctx.getChild(5) instanceof MyMethodBodyContext) {
			mb = mbVisitor.visit(ctx.getChild(5));
		}
		
		for(int i = 0; i < iterationGoal; i++) {
			this.mb.add(mb);
		}
		
		return new Loop(iterationGoal, this.mb, mb, this.semanticErrors, this.variableMap);
	}

	
	public Loop control(Deterministic_LoopContext ctx) {
		int iterationGoal = Integer.valueOf(Integer.valueOf(ctx.getChild(2).getText()));
		AntlrToMyMethodBody mbVisitor = new AntlrToMyMethodBody(this.semanticErrors, this.variableMap, this.global_mymethods);
//		for(int i = 0; i < iterationGoal; i++) {
			MyMethodBody mb = mbVisitor.control((MyMethodBodyContext) ctx.getChild(5));
//			this.methodBodiesList.add(mb);
//		}
			
			for(int i = 0; i < iterationGoal; i++) {
				this.mb.add(mb);
			}
		return new Loop(iterationGoal, this.mb, mb, this.semanticErrors, this.variableMap );
	}
}
