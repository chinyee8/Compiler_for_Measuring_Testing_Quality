package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.GameClassContext;
import model.GameBody;
import model.GameClass;

public class AntlrToGameClass extends exprBaseVisitor<GameClass>{
	public List<String> semanticErrors; 
	
	//controller fields
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
		
	
	
	public AntlrToGameClass(ArrayList<String>[] tokenLines) {
		this.tokensMappedToLines = tokenLines;
	}
	public AntlrToGameClass(List<String> semanticError) {
		this.semanticErrors = semanticError;
	}
	
	@Override
	public GameClass visitGameClass(GameClassContext ctx) {
		String className = ctx.CLASS_NAME().getText();
		AntlrToGameBody gbVisitor = new AntlrToGameBody(semanticErrors);
		GameBody gamebody = gbVisitor.visit(ctx.body());
		return new GameClass(className, gamebody);
	}
	
	
	public GameClass control(GameClassContext ctx) {
		String className = ctx.CLASS_NAME().getText();
		AntlrToGameBody gbController = new AntlrToGameBody(this.tokensMappedToLines);
		GameBody gamebody = gbController.control((GameBodyContext)ctx.getChild(5));
		
		return new GameClass(className, gamebody);
	}

}
