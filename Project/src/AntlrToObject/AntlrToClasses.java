package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.TestCaseContext;
import model.Assignment;
import model.Classes;
import model.Declaration;
import model.GameBody;
import model.GameClass;
import model.TestCase;
import model.TestMethodCall;

public class AntlrToClasses extends exprBaseVisitor<Classes>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	
	
	public AntlrToClasses(List<String> semanticError) {
		this.semanticErrors = semanticError;
	}
	
	@Override
	public GameClass visitGameClass(GameClassContext ctx) {
		String className = ctx.CLASS_NAME().getText();
		AntlrToGameBody gbVisitor = new AntlrToGameBody(semanticErrors);
		GameBody gamebody = gbVisitor.visit(ctx.body());
		return new GameClass(className, gamebody);
	}
	
	@Override
	public Classes visitTestCase(TestCaseContext ctx) {
		String testName = ctx.TEST_NAME().getText();
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<TestMethodCall> t_method_call = new ArrayList<>();
		
		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors);
		AntlrToTestMethodCall testVisitor = new AntlrToTestMethodCall(semanticErrors);
		
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
}
