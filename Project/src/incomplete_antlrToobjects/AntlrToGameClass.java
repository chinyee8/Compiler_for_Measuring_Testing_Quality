package incomplete_antlrToobjects;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.AdditionContext;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.CallEmptyParameterContext;
import antlr.exprParser.CallMultiParameterContext;
import antlr.exprParser.CallParamCharContext;
import antlr.exprParser.CallParamCondContext;
import antlr.exprParser.CallParamDoubleContext;
import antlr.exprParser.CallParamMathContext;
import antlr.exprParser.CallParamNumContext;
import antlr.exprParser.CallParamStringContext;
import antlr.exprParser.CallParamVarNameContext;
import antlr.exprParser.CallParameterContext;
import antlr.exprParser.CondBoolContext;
import antlr.exprParser.CondEqualContext;
import antlr.exprParser.CondNotEqualContext;
import antlr.exprParser.CondParenthesisContext;
import antlr.exprParser.CondVarNameContext;
import antlr.exprParser.ConjunctionContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.DisjunctionContext;
import antlr.exprParser.DivisionContext;
import antlr.exprParser.EmptyParamContext;
import antlr.exprParser.EqualToContext;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.GameClassContext;
import antlr.exprParser.IfStatementContext;
import antlr.exprParser.LessContext;
import antlr.exprParser.LessOrEqualContext;
import antlr.exprParser.MathDoubleContext;
import antlr.exprParser.MathNumberContext;
import antlr.exprParser.MathParenthesisContext;
import antlr.exprParser.MathVarNameContext;
import antlr.exprParser.MoreContext;
import antlr.exprParser.MoreOrEqualContext;
import antlr.exprParser.MultiParamChildContext;
import antlr.exprParser.MultiParamContext;
import antlr.exprParser.MultipleInputContext;
import antlr.exprParser.MultiplicationContext;
import antlr.exprParser.MyMethodBodyContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import antlr.exprParser.NegationContext;
import antlr.exprParser.NotEqualToContext;
import antlr.exprParser.ParamsContext;
import antlr.exprParser.RMethodCallContext;
import antlr.exprParser.ReturnMethodCallContext;
import antlr.exprParser.SingleParamContext;
import antlr.exprParser.SubtractionContext;
import antlr.exprParser.TestCaseContext;
import antlr.exprParser.TestMethodCallContext;
import antlr.exprParser.ValueBoolContext;
import antlr.exprParser.ValueCharContext;
import antlr.exprParser.ValueDoubleContext;
import antlr.exprParser.ValueMathContext;
import antlr.exprParser.ValueNumContext;
import antlr.exprParser.ValueStringContext;
import antlr.exprParser.ValuesContext;
import antlr.exprParser.VoidMethodCallContext;
import model.Assignment;
import model.Declaration;
import model.Expr;
import model.GameBody;
import model.GameClass;
import model.MethodType;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;

public class AntlrToGame extends exprBaseVisitor<Game>{
	
	public List<String> semanticErrors; 
	//public List<Integer> linesCovered;
	
	
	public AntlrToGame(List<String> semanticError) {
		this.semanticErrors = semanticError;
	}
	
	public Game visitGameClass(GameClassContext ctx) {
		AntlrToGameBody gbVisitor = new AntlrToGameBody(semanticErrors);
		String className = ctx.getChild(1).getText();
		GameBody gameBody = gbVisitor.visit(ctx.getChild(5));
		
		return new GameClass(className, gameBody);
	}
	
//	public List<Declaration> decl; 
//	public List<Assignment> assi; 
//	public List<MyMethods> methods; 	
//	
//	public List<String> semanticErrors; 
//	//public List<Integer> linesCovered;
//	
//	AntlrToExpr exprVisitor;
//	AntlrToMethodType methodTypeVisitor;
//	
//	
//	public AntlrToGameBody(List<String> semanticError) {
//		decl = new ArrayList<>();
//		assi = new ArrayList<>();
//		methods = new ArrayList<>();
//		
//		this.semanticErrors = semanticError;
//		exprVisitor = new AntlrToExpr(semanticErrors);
//		methodTypeVisitor = new AntlrToMethodType(semanticErrors);
//	}
//
//	public GameBody visitDeclaration(DeclarationContext ctx) {
//		String varName = ctx.getChild(0).getText();
//		String dataType = ctx.getChild(2).getText();
//		Declaration newDecl = new Declaration(varName, dataType);
//		decl.add(newDecl);
//		return new GameBody(decl,assi,methods);
//	}
//	
//	public GameBody visitAssignment(AssignmentContext ctx) {
//		String varName = ctx.getChild(0).getText();
//		
//		Expr expr = exprVisitor.visit(ctx.getChild(2));
//		Assignment newAssi = new Assignment(varName, expr);
//		assi.add(newAssi);
//		
//		//also need to add error for undeclared variable's assignment
//		return new GameBody(decl,assi,methods);
//	}
//	
//	public GameBody visitMyMethods(MyMethodsContext ctx) {
//		MyMethods newMM = null; // initialize
//		String methodName = ctx.getChild(1).getText();
//		
//		MethodType methodType = methodTypeVisitor.visit(ctx.getChild(2));
//		
//		//distinguish the method type
//		if ( methodTypeVisitor.getDataType() == "VOID" ) { // void method type
//			newMM = new MyMethods(methodName, (MyVoidMethod)methodType);
//		}
//		else if ( methodTypeVisitor.getDataType() == "INT" || 
//				methodTypeVisitor.getDataType() == "DOUBLE" || 
//				methodTypeVisitor.getDataType() == "BOOLEAN" || 
//				methodTypeVisitor.getDataType() == "STRING" || 
//				methodTypeVisitor.getDataType() == "CHAR") { // returnable method type
//			newMM = new MyMethods(methodName, (MyReturnMethod)methodType);
//		}
//		else { // invalid method type... if there is another type checker, this can be removed
//			semanticErrors.add("Error: invalid method type.");
//		}
//		methods.add(newMM);
//		return new GameBody(decl,assi,methods);
//	}
} 
