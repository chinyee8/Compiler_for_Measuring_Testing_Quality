package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.ProgramContext;
import antlr.exprParser.TestCaseContext;
import model.Program;
public class AntlrToProgram extends exprBaseVisitor<Program> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;

	//control flow fields 
	public int[] rangeOfLines;
	private ArrayList<String>[] tokensMappedToLines;

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

	public Program control(ProgramContext ctx) {
		Program prog = new Program();
		this.rangeOfLines = new int[2];
		Token start = ctx.getStart();
		Token end = ctx.getStop();
		this.rangeOfLines[0]=start.getLine();
		this.rangeOfLines[1]=end.getLine();
		this.tokensMappedToLines = new ArrayList [end.getLine()-start.getLine()+1];

		
		//initialize all arraylists
		for(int i = 0; i < this.tokensMappedToLines.length; i++) {
			this.tokensMappedToLines[i] = new ArrayList<String>();
		}
		
		AntlrToGameClass cController = new AntlrToGameClass(this.tokensMappedToLines);
		AntlrToTestCase tController = new AntlrToTestCase();

		if(ctx.getChild(0) instanceof GameClassContext) {
			prog.addGameClass(cController.control((GameClassContext)ctx.getChild(0)));
		}else {
			for(int i = 0; i < ctx.getChildCount(); i++) {
				if(i == ctx.getChildCount()-1) {

				}else {
					if(ctx.getChild(i) instanceof TestCaseContext) {
						prog.addTestCase(tController.control((TestCaseContext)ctx.getChild(i)));	
					}
				}
			}
		}
		
		return prog;
	}
	
}
