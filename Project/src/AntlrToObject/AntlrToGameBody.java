package AntlrToObject;

import java.util.ArrayList;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameBodyContext;
import model.Assignment;
import model.Declaration;
import model.GameBody;
import model.MyMethods;

public class AntlrToGameBody extends exprBaseVisitor<GameBody>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
//	public HashMap<String, >
	
	public AntlrToGameBody(List<String> semanticError) {
		this.semanticErrors = semanticError;
	}
	
	@Override
	public GameBody visitGameBody(GameBodyContext ctx) {
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<MyMethods> mymethod = new ArrayList<>();
		
		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors);
		AntlrToMyMethods mmVisitor = new AntlrToMyMethods(semanticErrors); 
		
		for(int i = 0; i < ctx.decl().size(); i++) {
			decl.add(declVisitor.visit(ctx.decl(i)));
		}
		
		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}
		
		for(int i = 0; i < ctx.mymethod().size(); i++) {
			mymethod.add(mmVisitor.visit(ctx.mymethod(i)));
		}
		
		return new GameBody(decl, assi, mymethod);
	}
}
