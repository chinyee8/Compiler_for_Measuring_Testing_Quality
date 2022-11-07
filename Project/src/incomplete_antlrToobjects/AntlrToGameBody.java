package incomplete_antlrToobjects;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.MyMethodsContext;
import model.Assignment;
import model.Declaration;
import model.Expr;
import model.GameBody;
import model.MethodType;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;

public class AntlrToGameBody extends exprBaseVisitor<GameBody>{
	
	public List<Declaration> decl; 
	public List<Assignment> assi; 
	public List<MyMethods> methods; 	
	
	public List<String> semanticErrors; 
	//public List<Integer> linesCovered;
	
	AntlrToExpr exprVisitor;
	AntlrToMethodType methodTypeVisitor;
	
	
	public AntlrToGameBody(List<String> semanticError) {
		decl = new ArrayList<>();
		assi = new ArrayList<>();
		methods = new ArrayList<>();
		
		this.semanticErrors = semanticError;
		exprVisitor = new AntlrToExpr(semanticErrors);
		methodTypeVisitor = new AntlrToMethodType(semanticErrors);
	}

	public GameBody visitDeclaration(DeclarationContext ctx) {
		String varName = ctx.getChild(0).getText();
		String dataType = ctx.getChild(2).getText();
		Declaration newDecl = new Declaration(varName, dataType);
		decl.add(newDecl);
		return new GameBody(decl,assi,methods);
	}
	
	public GameBody visitAssignment(AssignmentContext ctx) {
		String varName = ctx.getChild(0).getText();
		
		Expr expr = exprVisitor.visit(ctx.getChild(2));
		Assignment newAssi = new Assignment(varName, expr);
		assi.add(newAssi);
		
		//also need to add error for undeclared variable's assignment
		return new GameBody(decl,assi,methods);
	}
	
	public GameBody visitMyMethods(MyMethodsContext ctx) {
		MyMethods newMM = null; // initialize
		String methodName = ctx.getChild(1).getText();
		
		MethodType methodType = methodTypeVisitor.visit(ctx.getChild(2));
		
		//distinguish the method type
		if ( methodTypeVisitor.getDataType() == "VOID" ) { // void method type
			newMM = new MyMethods(methodName, (MyVoidMethod)methodType);
		}
		else if ( methodTypeVisitor.getDataType() == "INT" || 
				methodTypeVisitor.getDataType() == "DOUBLE" || 
				methodTypeVisitor.getDataType() == "BOOLEAN" || 
				methodTypeVisitor.getDataType() == "STRING" || 
				methodTypeVisitor.getDataType() == "CHAR") { // returnable method type
			newMM = new MyMethods(methodName, (MyReturnMethod)methodType);
		}
		else { // invalid method type... if there is another type checker, this can be removed
			semanticErrors.add("Error: invalid method type.");
		}
		methods.add(newMM);
		return new GameBody(decl,assi,methods);
	}
	
}
