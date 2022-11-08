package AntlrToObject;

import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameClassContext;
import model.GameBody;
import model.GameClass;

public class AntlrToGameClass extends exprBaseVisitor<GameClass>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	
	
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
}
