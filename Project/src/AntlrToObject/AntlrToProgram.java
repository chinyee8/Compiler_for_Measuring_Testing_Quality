package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import Operations.ConditionCoverage;
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
	public List<MyMethods> global_methods;

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
	public Values testValue;
	public List<Program> progReturn = new LinkedList<>();
	public List<MethodCall> testKey = new LinkedList<>();
	public Map<String, Values> testVarMap = new LinkedHashMap<String, Values>();
	public Map< Integer,String> assignedTo = new LinkedHashMap<>();
	public Map< Integer,Values> assignedValues = new LinkedHashMap<>();

	// Condition Coverage member variable
	public ConditionCoverage condCov;

	
	public AntlrToProgram() {
	}
	
	public AntlrToProgram(MethodCall t, Map<String, Values> inputValues, List<String> methodCallParamOrder) {
		this.t_method_call = t;
		this.inputValues = inputValues;
		this.methodCallParamOrder =  methodCallParamOrder;
	}

	//defCoverage
	public AntlrToProgram(MethodCall t, List<MyMethods> global_methods, Map<String, Values> inputValues, ConditionCoverage condCov) {
		this.t_method_call = t;
		this.inputValues = inputValues;
		this.global_methods = global_methods;
		
		this.condCov = condCov; // condition coverage
	}
	
	// Condition Coverage
	public AntlrToProgram(ConditionCoverage condCov) {
		this.condCov = condCov;
		/*
		if (!condCov.isComponentState()) {
			this.t_method_call = condCov.getTestMethod().getKey();
			this.inputValues = condCov.getTestMethod().getValue();
		}*/
	}


	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		semanticErrors = new ArrayList<>();
		this.variableMap = new HashMap<>();
		this.global_methods = new ArrayList<>();
		AntlrToGameClass cVisitor = new AntlrToGameClass(semanticErrors, global_methods);
		this.variableMap = new HashMap<>();
		AntlrToTestCase tVisitor = new AntlrToTestCase(semanticErrors, variableMap, condCov);

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
			this.variableMap = new HashMap<>();
			this.testValue = null;
			AntlrToGameClass cController = new AntlrToGameClass(semanticErrors, this.t_method_call, this.inputValues, global_methods, testValue, condCov); // condition coverage
			prog.addGameClass(cController.defControl((GameClassContext)ctx.getChild(0)));
			this.testValue = cController.testValue;
		}
		return prog;
	}
	
	public Program testControl(ProgramContext ctx, ParseTree progAST, List<MyMethods> global_methods2, String check, Map<MethodCall, List<String>> methodCallParamOrder2) {
		Program prog = new Program();
		semanticErrors = new ArrayList<>();
		this.variableMap = new HashMap<>();
		
		AntlrToTestCase tVisitor = new AntlrToTestCase(semanticErrors, variableMap, condCov); // condition coverage
		prog.addTestCase(tVisitor.testcontrol((TestCaseContext)ctx.getChild(0), progAST, global_methods2, check, methodCallParamOrder2));
		this.progReturn = tVisitor.getProgReturn();
		this.testKey = tVisitor.getTestKey();
		this.assignedTo = tVisitor.getAssignedTo();
		this.assignedValues = tVisitor.getAssignedValues();
		return prog;
	}
	
	// Condition Coverage
	public void visitConditionCoverage(ProgramContext ctx) {
	
		semanticErrors = new ArrayList<>();
		AntlrToGameClass ifVisitor = new AntlrToGameClass(condCov);

		if(ctx.getChild(0) instanceof GameClassContext) {
			ifVisitor.visitConditionCoverage((GameClassContext)ctx.getChild(0));
		}
	}

}
