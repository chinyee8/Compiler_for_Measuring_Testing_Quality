package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import antlr.exprBaseVisitor;
import antlr.exprParser.GameBodyContext;
import model.Assignment;
import model.Declaration;
import model.GameBody;
import model.MyMethods;
import model.Values;
import model.*;

public class AntlrToGameBody extends exprBaseVisitor<GameBody>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	
	public AntlrToGameBody(List<String> semanticError) {
		this.semanticErrors = semanticError;
		this.variableMap = new HashMap<>();
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
			variableMap.put(decl.get(i).varName, decl.get(i).defaultValue);
		}
		
		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
			if(variableMap.containsKey(assi.get(i).varName)) {
				if(assi.get(i).expr instanceof MethodCall) {
					if(assi.get(i).expr instanceof ReturnMethodCall) {
						
					}
					else if (assi.get(i).expr instanceof VoidMethodCall) {
						
					}
				}
				else if (assi.get(i).expr instanceof Values){
					
				}
			}
			else {
				//report semantic error uninitialized var
			}
		}
		
		for(int i = 0; i < ctx.mymethod().size(); i++) {
			mymethod.add(mmVisitor.visit(ctx.mymethod(i)));
		}
		
		return new GameBody(decl, assi, mymethod);
	}
}
