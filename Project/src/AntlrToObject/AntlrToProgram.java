package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.ProgramContext;
import model.Program;
public class AntlrToProgram extends exprBaseVisitor<Program> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;

	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		semanticErrors = new ArrayList<>();

		AntlrToGameClass cVisitor = new AntlrToGameClass(semanticErrors);
		AntlrToTestCase tVisitor = new AntlrToTestCase(semanticErrors);

		if(ctx.getChild(0) instanceof GameClassContext) {
			prog.addGameClass(cVisitor.visit(ctx.getChild(0)));
		}else {
			for(int i = 0; i < ctx.getChildCount(); i++) {
				if(i == ctx.getChildCount()-1) {

				}else {
					prog.addTestCase(tVisitor.visit(ctx.getChild(i)));
				}
			}
		}


		return prog;
	}


}
