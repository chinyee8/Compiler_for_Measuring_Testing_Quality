package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.exprBaseVisitor;
import antlr.exprParser.AssignmentContext;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.GameBodyContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyVoidMethodContext;
import model.*;

public class AntlrToGameBody extends exprBaseVisitor<GameBody>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;
	public List<Declaration> decl;
	public List<Assignment> assi;
	public List<MyMethods> mymethod;
	public List<MyMethods> global_mymethods;
	//controller fields
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines;
	public ArrayList<Integer> orderOfFlow;
	public ArrayList<AntlrToDeclaration> dControllers;
	public ArrayList<AntlrToAssignment> aControlleres;
	public ArrayList<AntlrToMyMethods> mmControllers;
	public HashMap<String, Expr> controlVariableMap;
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;

	public AntlrToGameBody() {

	}
	public AntlrToGameBody(ArrayList<String>[] m, ArrayList<Integer> order) {
		this.tokensMappedToLines = m;
		this.orderOfFlow = order;
		this.variableMap = new HashMap<>();
		this.dControllers = new ArrayList<>();
		this.aControlleres = new ArrayList<>();
		this.mmControllers = new ArrayList<>();

		this.decl = new ArrayList<>();
		this.assi = new ArrayList<>();
		this.mymethod = new ArrayList<>();
	}
	public AntlrToGameBody(List<String> semanticError) {
		this.semanticErrors = semanticError;
		this.variableMap = new HashMap<>();
		this.global_mymethods = new ArrayList<>();
	}

	public AntlrToGameBody(List<String> semanticError, MethodCall t_method_call, Map<String, Values> inputValues) {
		// TODO Auto-generated constructor stub
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.variableMap = new HashMap<>();
		this.dControllers = new ArrayList<>();
		this.aControlleres = new ArrayList<>();
		this.mmControllers = new ArrayList<>();

		this.decl = new ArrayList<>();
		this.assi = new ArrayList<>();
		this.mymethod = new ArrayList<>();
		
		this.semanticErrors = semanticError;


	}
	@Override
	public GameBody visitGameBody(GameBodyContext ctx) {
		List<Declaration> decl = new ArrayList<>();
		List<Assignment> assi = new ArrayList<>();
		List<MyMethods> mymethod = new ArrayList<>();

		AntlrToDeclaration declVisitor = new AntlrToDeclaration(semanticErrors, this.variableMap);
		AntlrToAssignment assiVisitor = new AntlrToAssignment(semanticErrors, this.variableMap, this.global_mymethods);
		AntlrToMyMethods mmVisitor = new AntlrToMyMethods(semanticErrors, this.variableMap, this.global_mymethods); 

		for(int i = 0; i < ctx.decl().size(); i++) {			
//			decl.add(declVisitor.visit(ctx.decl(i)));
			semanticErrors.add("Error: no global variable are allowed");
//			variableMap.put(decl.get(i).varName, decl.get(i).defaultValue); //store default values for each decl into a map
		}


		for(int i = 0; i < ctx.assi().size(); i++) {
//			assi.add(assiVisitor.visit(ctx.assi(i)));
		}

		for(int i = 0; i < ctx.mymethod().size(); i++) {
			MyMethods myMeth = mmVisitor.visit(ctx.mymethod(i));
//			if(myMeth.methodType instanceof MyReturnMethod) {
//				MyMethodBody myMethBody = ((MyReturnMethod)myMeth.methodType).method_body;
//				for(Assignment a: myMethBody.assiList) {
//					if(a.expr instanceof ValueMath) {
//						String mathType = getMATHTYPE(((ValueMath)a.expr).math);
//						if(mathType.equals("NOT SAME")) {
//							semanticErrors.add("Error: " + ((ValueMath)a.expr).math.toString() + ", LHS and RHS must have same data type");
//						}
//					}
//				}
//			}
			this.global_mymethods.add(myMeth);
			mymethod.add(myMeth);

		}

		this.decl = decl;
		this.assi = assi;
		this.mymethod = mymethod;

		//check for semanticerrors:
		for(Assignment i: assi) {
			if(variableMap.containsKey(i.varName)) {
				//At Values to variableMap for both r_method_call and value
				if(checkIfAssignmentTypeMatchesRHS(i, i.expr, decl)) {
					if(i.expr instanceof Values) {
						variableMap.put(i.varName, ((Values)i.expr).getValues());
					}else if(i.expr instanceof ReturnMethodCall) {
						variableMap.put(i.varName, callExpr(((ReturnMethodCall)i.expr), i.varName));

					}
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
		
		boolean containsMethod = false;
		if(this.t_method_call != null) {
			for(MyMethods m: this.mymethod) {
				if(m.methodName.equals(this.t_method_call.getName())) {
					if(m.methodType instanceof MyReturnMethod) {
						List<String> testMCParameter = ((TestMethodCall)this.t_method_call).call_parameter.getCallParams();
						Map<String, String> methodParameter = ((MyReturnMethod)m.methodType).parameter.getParams();
						if(((TestMethodCall)this.t_method_call).call_parameter.getCallParams().size() == ((MyReturnMethod)m.methodType).parameter.getParams().size()) {
							containsMethod = checkIfSameParameters(testMCParameter, methodParameter);
							if(containsMethod) {
								((MyReturnMethod)m.methodType).getValue(inputValues);
							}
						}
					}else if(m.methodType instanceof MyVoidMethod) {
						List<String> testMCParameter = ((TestMethodCall)this.t_method_call).call_parameter.getCallParams();
						Map<String, String> methodParameter = ((MyVoidMethod)m.methodType).parameter.getParams();
						if(((TestMethodCall)this.t_method_call).call_parameter.getCallParams().size() == ((MyVoidMethod)m.methodType).parameter.getParams().size()) {
							containsMethod = checkIfSameParameters(testMCParameter, methodParameter);
							if(containsMethod) {
								//dk what to do wtih this yet
							}
						}
					}
				}
			}
		}
				
		
		return new GameBody(decl, assi, mymethod);
	}
	
	

	private boolean checkIfSameParameters(List<String> testMCParameter, Map<String, String> methodParameter) {
		boolean contains = true;
		int i = 0;
		for(Map.Entry<String, Values> in : this.inputValues.entrySet()) {
			if(!in.getValue().getType().equals(methodParameter.get(i))) {
				contains = false;
				semanticErrors.add("Error: dataType of " + testMCParameter.get(i) + "from test_methodcall is not the same as mymethod");
			}
				
			i++;
		}
		
		return contains;
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
			if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, this.mymethod)) { //if rhs methodcall is declared 
				String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
				for(MyMethods m: this.mymethod) { //grab method from DeclaredMethodsList, find matching method, check for return data type against decType
					if(m.methodName.equals(rhsMethodName) && m.methodType instanceof MyReturnMethod) {
						List<String> RHSparams = ((ReturnMethodCall)rhs).call_parameter.getCallParams();
						Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
						if(RHSparams.size() != methodparams.size()) {
							semanticErrors.add("Error: " + ((ReturnMethodCall)rhs).toString() + " must have the same number of parameters as mymethod " + m.methodName);
						}else {

							if(RHSparams.size() > 0) {
								boolean contains = false;
								for(String r : RHSparams) {
									if(!this.variableMap.containsKey(r)) {
										semanticErrors.add("Error: " + r + " is not declared");
										contains = true;
									}
								}

								if(contains) {

								}else {
									int i = 0;
									for(Map.Entry<String, String> map: methodparams.entrySet()){
										if(!(this.variableMap.get(RHSparams.get(i)).getType().equals(map.getValue()))){
											semanticErrors.add("Error: dataType of " + RHSparams.get(i) + " in " +  ((ReturnMethodCall)rhs).toString() + " is not the same as dataType of " + map.getKey() + " in mymethod" + m.methodName);
										}
										i++;
									}
								}
							}

						}

						if(m.methodType instanceof MyReturnMethod) {
							return ((MyReturnMethod)m.methodType).dataType.equals(decType);
						}
						else { 						//if m.methodType instanceof MyVoidMethod it would have been detected earlier ignore else case
							semanticErrors.add("void type checking error");
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

	private Values callExpr(ReturnMethodCall r, String varName) {
		for(MyMethods m : this.mymethod) {
			if(m.methodName.equals(r.methodName) && m.methodType instanceof MyReturnMethod) {
				boolean noerror = true;
				List<String> RHSparams = r.call_parameter.getCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
				if(RHSparams.size() == methodparams.size() && RHSparams.size() > 0) {
					boolean contains = true;
					Map<String, Values> lists = new LinkedHashMap<>();
					for(String s : RHSparams) {
						if(!this.variableMap.containsKey(s)) {
							contains = false;
						}else {
							lists.put(s, this.variableMap.get(s));
						}
					}

					if(contains) {
						int i = 0;
						for(Map.Entry<String, String> map: methodparams.entrySet()){
							if(!(this.variableMap.get(RHSparams.get(i)).getType().equals(map.getValue()))){
								noerror = false;
							}
							i++;
						}
					}
					
					if(noerror) {
						return ((MyReturnMethod)m.methodType).getValue(lists);
					}
				}
			}

		}

		return variableMap.get(varName);

	}




	//control flow underneath
	public GameBody control(GameBodyContext ctx) {
		//		this.rangeOfLines = new int[2];
		//		Token start = ctx.getStart();
		//		Token end = ctx.getStop();
		//		this.rangeOfLines[0]=start.getLine()-1;
		//		this.rangeOfLines[1]=end.getLine()-1;

		for(int i = 0; i < ctx.decl().size(); i++) {			
			AntlrToDeclaration declController = new AntlrToDeclaration();
			this.dControllers.add(declController);
			this.decl.add(declController.control((DeclarationContext)ctx.decl(i)));
			this.variableMap.put(this.decl.get(i).varName, this.decl.get(i).defaultValue); //store default values for each decl into a map


		}


		for(int i = 0; i < ctx.assi().size(); i++) {
			AntlrToAssignment assiController = new AntlrToAssignment();
			assi.add(assiController.control((AssignmentContext)ctx.assi(i)));
			this.controlVariableMap.put(assi.get(i).varName, assi.get(i).expr);
		}

		for(int i = 0; i < ctx.mymethod().size(); i++) {
			AntlrToMyMethods mmController = new AntlrToMyMethods(semanticErrors, variableMap, mymethod, this.t_method_call, this.inputValues); 
			MyMethods m = mmController.control((MyMethodsContext)ctx.mymethod(i));
			mymethod.add(m);
		}


		return null;
	}

	public ArrayList<String> getTextOfNode(ParseTree t, ArrayList<String> result) {
		if(t instanceof TerminalNode) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add(t.getText());
			return temp;
		}

		else {
			ArrayList<String> temp = new ArrayList<>();
			for(int i = 0; i < t.getChildCount(); i++) {
				ArrayList<String> temp2 = getTextOfNode(t.getChild(i), result);
				for(String j: temp2) {
					temp.add(j);
				}
			}
			return temp;
		}
	}
	
	private String getMATHTYPE(Mathematics m) {
		String result = "";
		
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Division) {
			Division a = (Division) m;
			String left = getMATHTYPE(a.math1);
			String right = getMATHTYPE(a.math2);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMATHTYPE(a.math);
		}else if(m instanceof MathNumber) {
			result = "INT";
		}else if(m instanceof MathDouble) {
			result = "DOUBLE";
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			result = a.val.getType();
		}
		
		return result;
	}
}
