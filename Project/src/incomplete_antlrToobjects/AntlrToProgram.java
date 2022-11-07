package incomplete_antlrToobjects;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.ProgramContext;
import model.Game;
import model.Program;
import model.TestCase;
import antlr.*;
public class AntlrToProgram extends exprBaseVisitor<Program> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		semanticErrors = new ArrayList<>();
		
		AntlrToGame gameClassVisitor = new AntlrToGame(semanticErrors);
		AntlrToTestCase testCaseVisitor = new AntlrToTestCase(semanticErrors);
		
		if(ctx.getChild(0) instanceof Game) {
			prog.addGameClass(gameClassVisitor.visit(ctx.getChild(0))); 
			
		}else if(ctx.getChild(0) instanceof TestCase) {
			
			for(int i = 0; i < ctx.getChildCount(); i++) {
				if(i == ctx.getChildCount()-1) {
					
				}
				else {
					prog.addTestCase(testCaseVisitor.visit(ctx.getChild(i)));
				}
			}
		}
		
		
		
		return prog;
	}
	
	
}
