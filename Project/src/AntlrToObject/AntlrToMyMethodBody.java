package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.MyMethodBodyContext;
import model.Assignment;
import model.Declaration;
import model.IfStatement;
import model.MethodType;
import model.MyMethodBody;
import model.MyMethods;

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
		List<MethodType> methodtype = new ArrayList<>();
		
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
		
		for(int i = 0; i < ctx.if_statement().size(); i++) {
			ifstatement.add(ifVisitor.visit(ctx.if_statement(i)));
		}
		
		for(int i = 0; i < ctx.r) // need to separate r_methodcall and v_methodcall in line 38
		
		
		
	}
	
	
}
