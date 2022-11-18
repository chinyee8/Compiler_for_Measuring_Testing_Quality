package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.VoidMethodCallContext;
import model.Assignment;
import model.Declaration;
import model.Expr;
import model.IfStatement;
import model.MethodCall;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.ReturnMethodCall;
import model.Values;
import model.VoidMethodCall;

public class AntlrToMyMethodBody extends exprBaseVisitor<MyMethodBody>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public Map<String, Values> local_methodvar;
	public List<MyMethods> mymethod;

	public AntlrToMyMethodBody(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> mymethod) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.mymethod = mymethod;
		this.local_methodvar = new HashMap<>();

	}

	@Override
	public MyMethodBody visitMyMethodBody(MyMethodBodyContext ctx) {
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<IfStatement> ifstatement = new ArrayList<>();
		List<MethodCall> methodCall = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap, this.mymethod);
		AntlrToIfStatement ifVisitor = new AntlrToIfStatement(semanticErrors, this.variableMap, this.mymethod);
		AntlrToMethodCall methodcallVisitor = new AntlrToMethodCall(semanticErrors, this.variableMap);

		this.local_methodvar.putAll(variableMap);
		
		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
			local_methodvar.put(decl.get(i).varName, decl.get(i).defaultValue);
		}

		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}
		
		for(int i = 0; i < ctx.if_statement().size(); i++){
			  ifstatement.add(ifVisitor.visit(ctx.if_statement(i)));
		}

		for(int i = 0; i < ctx.getChildCount(); i++) { 
			 if(ctx.getChild(i) instanceof ReturnMethodCallContext 
					|| ctx.getChild(i) instanceof VoidMethodCallContext) {
				methodCall.add(methodcallVisitor.visit(ctx.getChild(i)));
			}
		}
		
		

		return new MyMethodBody(decl, assi, ifstatement, methodCall);

	}
	
	
}
