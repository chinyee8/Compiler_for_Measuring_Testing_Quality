package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.IfStatementContext;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.ReturnMethodCallContext;
import model.Assignment;
import model.Declaration;
import model.IfStatement;
import model.MethodCall;
import model.MyMethodBody;

public class AntlrToMyMethodBody extends exprBaseVisitor<MyMethodBody>{
	public List<String> semanticErrors;
	public List<Integer> linesCovered;

	public AntlrToMyMethodBody(List<String> semanticErrors) {
		this.semanticErrors = new ArrayList<>();
	}

	@Override
	public MyMethodBody visitMyMethodBody(MyMethodBodyContext ctx) {
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<IfStatement> ifstatement = new ArrayList<>();
		List<MethodCall> methodCall = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors);
		AntlrToIfStatement ifVisitor = new AntlrToIfStatement(semanticErrors);
		AntlrToMethodCall methodcallVisitor = new AntlrToMethodCall(semanticErrors);

		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
		}

		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}
		
		for(int i = 0; i < ctx.if_statement().size(); i++){
			  ifstatement.add(ifVisitor.visit(ctx.getChild(i)));
		}

		for(int i = 0; i < ctx.getChildCount(); i++) { 
			 if(ctx.getChild(i) instanceof ReturnMethodCallContext 
					|| ctx.getChild(i) instanceof ReturnMethodCallContext) {
				methodCall.add(methodcallVisitor.visit(ctx.getChild(i)));
			}
		}

		return new MyMethodBody(decl, assi, ifstatement, methodCall);

	}


}
