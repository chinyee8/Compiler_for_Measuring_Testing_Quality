package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.ProgramContext;
import antlr.exprParser.TestCaseContext;
import model.MethodCall;
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
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public List<String> methodCallParamOrder;
	
	//defCoverage
	public Map<String, Boolean> def;
	public Map<Map<Integer, Map<String, Boolean>>, List<Integer>>  def_use;
	public Map<Integer, Map<String, Boolean>> linesDef;
	public List<Integer> linesUse;
	public List<String> lines;
	public int totalNotUsed;

	public AntlrToProgram() {
	}
	
	public AntlrToProgram(MethodCall t, Map<String, Values> inputValues, List<String> methodCallParamOrder) {
		this.t_method_call = t;
		this.inputValues = inputValues;
		this.methodCallParamOrder =  methodCallParamOrder;
	}

	//defCoverage
	public AntlrToProgram(MethodCall t, Map<String, Values> inputValues) {
		this.t_method_call = t;
		this.inputValues = inputValues;
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
			semanticErrors = new ArrayList<>();
			AntlrToGameClass cController = new AntlrToGameClass(semanticErrors, this.t_method_call, this.inputValues, this.methodCallParamOrder);
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

	//Cy's defCoverage
	public Program defControl(ProgramContext ctx) {
		Program prog = new Program();
		
		if(ctx.getChild(0) instanceof GameClassContext) {
			semanticErrors = new ArrayList<>();
			def = new HashMap<>();
			def_use = new LinkedHashMap<>();
			this.variableMap = new HashMap<>();
			linesDef = new HashMap<>();
			linesUse = new ArrayList<>();
			lines = new ArrayList<>();
			totalNotUsed=0;

			AntlrToGameClass cController = new AntlrToGameClass(semanticErrors, this.t_method_call, this.inputValues, def, def_use, linesDef, linesUse, lines, totalNotUsed);
			prog.addGameClass(cController.defControl((GameClassContext)ctx.getChild(0)));
			totalNotUsed = cController.totalNotUsed;
		}
		return prog;
	}

}
