package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.ProgramContext;
import model.Program;
import antlr.*;
public class AntlrToProgram extends exprBaseVisitor<Program> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		semanticErrors = new ArrayList<>();
		
		AntlrToGameClass gameClassVisitor = new AntlrToGameClass(semanticErrors);
		AntlrToTestCase testCaseVisitor = new AntlrToTestCase(semanticErrors);
		
		int gameClassIndex = 0;
		int testCaseIndex = 0;
		
		for(int i = 0; i < ctx.getChildCount(); i++) {
			if(i == ctx.getChildCount()-1) {
				
			}
			else {
				prog.addGameClass(gameClassVisitor.visit(ctx.getChild(gameClassIndex++)));
				prog.addTestCase(testCaseVisitor.visit(ctx.getChild(testCaseIndex++)));
			}
		}
		
		return prog;
	}
	
	
}
