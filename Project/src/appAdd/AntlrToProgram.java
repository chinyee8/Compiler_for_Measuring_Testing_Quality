package appAdd;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.ProgramContext;

public class AntlrToProgram extends exprBaseVisitor<Program> {
	public List<String> semanticErrors;

	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		semanticErrors = new ArrayList<>();
		
		AntlrToExpression exprVisitor = new AntlrToExpression(semanticErrors);
		for(int i = 0; i < ctx.getChildCount(); i++) {
			if(i == ctx.getChildCount()-1) {
				
			}else {
				prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
			}
		}
		
		return prog;
	}
	
	
}
