package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.TestCaseContext;
import model.Assignment;
import model.Declaration;
import model.MyMethods;
import model.TestCase;
import model.TestMethodCall;
import model.Values;

public class AntlrToTestCase extends exprBaseVisitor<TestCase>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	private List<MyMethods> mymethod;
	
	public AntlrToTestCase(List<String> semanticError, HashMap<String, Values> variableMap) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
//		this.mymethod = ;
	}
	public AntlrToTestCase() {
		
	}
	
	
	@Override
	public TestCase visitTestCase(TestCaseContext ctx) {
		String testName = ctx.TEST_NAME().getText();
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<TestMethodCall> t_method_call = new ArrayList<>();
		
		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap, this.mymethod);
		AntlrToTestMethodCall testVisitor = new AntlrToTestMethodCall(semanticErrors, this.variableMap);
		
		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
		}
		
		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}
		
		for(int i = 0; i < ctx.t_method_call().size() ; i++) {
			t_method_call.add(testVisitor.visit(ctx.t_method_call(i)));
		}
		
		return new TestCase(testName, decl, assi, t_method_call);
	}
	
	//controlflow
	public TestCase control(TestCaseContext child) {
		// TODO Auto-generated method stub
		return null;
	}
}
