package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.Token;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.MyMethodsContext;
import model.Assignment;
import model.Declaration;
import model.GameBody;
import model.MyMethods;
import model.Values;
import model.*;

public class AntlrToGameBody extends exprBaseVisitor<GameBody>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public static HashMap<String, Values> variableMap;
	public static List<Declaration> decl;
	public static List<Assignment> assi;
	public static List<MyMethods> mymethod;
	//controller fields
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines;
	public ArrayList<Integer> orderOfFlow;
	public ArrayList<AntlrToDeclaration> dControllers;
	public ArrayList<AntlrToAssignment> aControlleres;
	public ArrayList<AntlrToMyMethods> mmControllers;
	
	public AntlrToGameBody(ArrayList<String>[] m, ArrayList<Integer> order) {
		this.tokensMappedToLines = m;
		this.orderOfFlow = order;
	}
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
			variableMap.put(decl.get(i).varName, decl.get(i).defaultValue); //store default values for each decl into a map
		}
		
		
		for(int i = 0; i < ctx.assi().size(); i++) {
			assi.add(assiVisitor.visit(ctx.assi(i)));
		}
		
		for(int i = 0; i < ctx.mymethod().size(); i++) {
			mymethod.add(mmVisitor.visit(ctx.mymethod(i)));

		}
		
		this.decl = decl;
		this.assi = assi;
		this.mymethod = mymethod;
		//check for semanticerrors:
		for(Assignment i: assi) {
			if(variableMap.containsKey(i.varName)) {
				if(checkIfAssignmentTypeMatchesRHS(i, i.expr, decl)) {
					variableMap.put(i.varName, callExpr(i.expr));
				}
				else {
					this.semanticErrors.add("Error: variable " + i.varName + " return type does not match expression return type.");
				}
			}
			else {
				//report semantic error uninitialized var
				this.semanticErrors.add("Error: variable " + i.varName + " is not declared.");
			}
		}
		return new GameBody(decl, assi, mymethod);
	}
	
	private boolean checkIfMyMethodContainsReturnMethodCall(ReturnMethodCall r, List<MyMethods> mymethod) {
		for(MyMethods i: mymethod) {
			if(i.methodName.equals(r.methodName)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkIfAssignmentTypeMatchesRHS(Assignment a, Expr rhs, List<Declaration> dList) {
		String decType = "";
		for(Declaration d: dList) { //find dec type from declarations of game body
			if(d.varName.equals(a.varName)) {
				decType = d.dataType;
			}
		}
		if(rhs instanceof VoidMethodCall ) {
			return false;
		}
		else if(rhs instanceof Values) {
			if(((Values) rhs).getType().equals(decType)) {
				return true; //need to get type for "MATH" -->ValueMath
			}else if(((Values)rhs).getType().equals("MATH")) {
				if(decType.equals("INT") || decType.equals("DOUBLE")) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		else if(rhs instanceof ReturnMethodCall) {
			if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, AntlrToGameBody.mymethod)) { //if rhs methodcall is declared 
				String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
				for(MyMethods m: AntlrToGameBody.mymethod) { //grab method from DeclaredMethodsList, find matching method, check for return data type against decType
					if(m.methodName.equals(rhsMethodName)) {
						if(m.methodType instanceof MyReturnMethod) {
							return ((MyReturnMethod)m.methodType).dataType.equals(decType);
						}
						else { 						//if m.methodType instanceof MyVoidMethod it would have been detected earlier ignore else case
							System.out.println("void type checking error");
							return false;
						}
					}
				}
				return false;
			}
			else { //if method not declared
				this.semanticErrors.add("Return Method Call on RHS is not declared: " + a.varName + " cannot be assigned to: " + rhs.toString());
				return false;
			}
		}
		else return false;
	}
	
	private Values callExpr(Expr r) {
		//fill in later, step into body of methodcall and create a return type
		
		return null;
	}
	
	
	//control flow underneath
	public GameBody control(GameBodyContext ctx) {
		this.rangeOfLines = new int[2];
		Token start = ctx.getStart();
		Token end = ctx.getStop();
		this.rangeOfLines[0]=start.getLine();
		this.rangeOfLines[1]=end.getLine();
		
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<MyMethods> mymethod = new ArrayList<>();
		
		
		for(int i = 0; i < ctx.decl().size(); i++) {			
			this.variableMap.put(decl.get(i).varName, decl.get(i).defaultValue); //store default values for each decl into a map
			//create one Controller for each object to store its lines
			AntlrToDeclaration declController = new AntlrToDeclaration(this.tokensMappedToLines, this.orderOfFlow);
			this.decl.add(declController.control((DeclarationContext)ctx.decl(i)));
			this.dControllers.add(declController);
			
		}
		
		
		for(int i = 0; i < ctx.assi().size(); i++) {
			AntlrToAssignment assiController = new AntlrToAssignment(this.tokensMappedToLines, this.orderOfFlow);
			assi.add(assiController.control((AssignmentContext)ctx.assi(i)));
		}
		
		for(int i = 0; i < ctx.mymethod().size(); i++) {
			AntlrToMyMethods mmController = new AntlrToMyMethods(this.tokensMappedToLines, this.orderOfFlow); 
			mymethod.add(mmController.control((MyMethodsContext)ctx.mymethod(i)));

		}
		
		this.decl = decl;
		this.assi = assi;
		this.mymethod = mymethod;
		return null;
	}
}
