package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.ProgramContext;
import antlr.exprParser.TestCaseContext;
import model.MyMethods;
import model.Program;
import model.TestMethodCall;
import model.Values;
public class AntlrToProgram extends exprBaseVisitor<Program> {
	public List<String> semanticErrors;
	public List<Integer> linesCovered;

	//control flow fields //store all AntlrTo___ into fields to get line numbers
	public int[] rangeOfLines;
	public ArrayList<String>[] tokensMappedToLines; //raw input text at each line (index correspond to line number - 1) --> to print into html
	public ArrayList<Integer> orderOfFlow;	//order of which lines are executed in control flow 
	public AntlrToGameClass gController;
	public ArrayList<AntlrToTestCase> tController;
	public HashMap<String, Values> variableMap; //testcase variable map
	public TestMethodCall t_method_call;
	
	public AntlrToProgram() {
	}
	
	public AntlrToProgram(TestMethodCall t) {
		this.t_method_call = t;
	}

	
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		semanticErrors = new ArrayList<>();
		this.variableMap = new HashMap<>();
		AntlrToGameClass cVisitor = new AntlrToGameClass(semanticErrors);
		this.variableMap = new HashMap<>();
		AntlrToTestCase tVisitor = new AntlrToTestCase(semanticErrors, this.variableMap);

		if(ctx.getChild(0) instanceof GameClassContext) {
			prog.addGameClass(cVisitor.visit(ctx.getChild(0)));
		}else if(ctx.getChild(0) instanceof TestCaseContext){
			prog.addTestCase(tVisitor.visit(ctx.getChild(0)));
		}


		return prog;
	}

	public Program control(ProgramContext ctx) {
		
		Program prog = new Program();
//		this.rangeOfLines = new int[2];
//		Token start = ctx.getStart();
//		Token end = ctx.getStop();
//		this.rangeOfLines[0]=start.getLine()-1;
//		this.rangeOfLines[1]=end.getLine()-1;
//		this.tokensMappedToLines = new ArrayList [end.getLine()-start.getLine()+1];
//
//
//		//initialize all arraylists
//		for(int i = 0; i < this.tokensMappedToLines.length; i++) {
//			this.tokensMappedToLines[i] = new ArrayList<String>();
//		}
//		this.orderOfFlow = new ArrayList<>();

		if(ctx.getChild(0) instanceof GameClassContext) {
			AntlrToGameClass cController = new AntlrToGameClass(this.t_method_call);
			prog.addGameClass(cController.control((GameClassContext)ctx.getChild(0)));
			this.gController = cController;
			this.variableMap = new HashMap<>();
			//to be added

		}
//		else {
//			for(int i = 0; i < ctx.getChildCount(); i++) {
//				if(i == ctx.getChildCount()-1) {
//
//				}else {
//					if(ctx.getChild(i) instanceof TestCaseContext) {
//						AntlrToTestCase tController = new AntlrToTestCase();
//						prog.addTestCase(tController.control((TestCaseContext)ctx.getChild(i)));	
//						this.tController.add(tController);
//
//					}
//				}
//			}
//		}

		return prog;
	}

}
