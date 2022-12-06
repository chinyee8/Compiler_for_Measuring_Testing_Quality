package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.LabelUI;

import org.antlr.v4.runtime.Token;

import Operations.ConditionCoverage;
import antlr.exprBaseVisitor;
import antlr.exprParser.Deterministic_LoopContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import model.Addition;
import model.Assignment;
import model.CallParamBoolean;
import model.CallParamChar;
import model.CallParamDouble;
import model.CallParamNum;
import model.CallParamString;
import model.CallParamVarName;
import model.CondBool;
import model.CondEqual;
import model.CondNotEqual;
import model.CondParenthesis;
import model.CondVarName;
import model.Condition;
import model.Conjunction;
import model.Declaration;
import model.Disjunction;
import model.Division;
import model.EqualTo;
import model.Expr;
import model.IfStatement;
import model.Input_List;
import model.Less;
import model.LessOrEqual;
import model.Loop;
import model.MathDouble;
import model.MathNumber;
import model.MathParenthesis;
import model.MathVarName;
import model.Mathematics;
import model.MethodCall;
import model.MethodType;
import model.More;
import model.MoreOrEqual;
import model.Multiplication;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Negation;
import model.NotEqualTo;
import model.Parameter;
import model.ReturnMethodCall;
import model.Subtraction;
import model.TestMethodCall;
import model.ValueBool;
import model.ValueChar;
import model.ValueDouble;
import model.ValueMath;
import model.ValueNum;
import model.ValueString;
import model.Values;
import model.VoidMethodCall;

public class AntlrToMyMethods extends exprBaseVisitor<MyMethods>{
	public List<String> semanticErrors; 
	public List<Integer> linesCovered;
	public HashMap<String, Values> variableMap;

	public ArrayList<Integer>orderOfFlow;
	public ArrayList<String>[] tokensMappedToLines; //index of array + 1 correspond to line number in program 
	public int[] rangeOfLines;
	public List<MyMethods> global_mymethods; 
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public List<String> methodCallParamOrder;
	public HashMap<String, Values> local_variableMap;
	//def Coverage
	public Values testValue;

	// Condition Coverage member variable
	public ConditionCoverage condCov;


	public AntlrToMyMethods(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}

	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = mymethod;
	}

	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod, MethodCall t_method_call, Map<String, Values> inputValues, List<String> methodCallParamOrder) {
		this.methodCallParamOrder = methodCallParamOrder;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = mymethod;
	}

	//defCoverage
	public AntlrToMyMethods(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, MethodCall t_method_call, Map<String, Values> inputValues, Values testValue, ConditionCoverage condCov) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.testValue = testValue;

		this.condCov = condCov;
	}

	// Condition Coverage
	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod, ConditionCoverage condCov) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = mymethod;
		this.condCov = condCov;
		/*
		if (!condCov.isComponentState()) {
			this.t_method_call = condCov.getTestMethod().getKey();
			this.inputValues = condCov.getTestMethod().getValue();
		}*/
	}

	@Override
	public MyMethods visitMyMethods(MyMethodsContext ctx) {
		local_variableMap = new HashMap<>();

		Token token = ctx.METHODNAME().getSymbol();
		int line = token.getLine();
		String methodName = ctx.METHODNAME().getText();
		for(MyMethods m : global_mymethods) {
			if(m.methodName.equals(methodName)) {
				semanticErrors.add("Error[Line:" + m.line +"]: " + " mymethods " + methodName + " already exist");
			}
		}

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			MethodType methodType = (MyReturnMethod)mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyReturnMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			if(t_method_call instanceof ReturnMethodCall) {
				checkTestMethodCallParameter(parameter, methodType, methodName, line);
			}

			((MyReturnMethod)methodType).putReturnValue(local_variableMap.get(((MyReturnMethod)methodType).varName));

			return new MyMethods(methodName, (MyReturnMethod)methodType, line);

		} else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			MethodType methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();

			return new MyMethods(methodName, (MyVoidMethod)methodType, line);
		}

	}

	// Condition Coverage
	public void visitConditionCoverage(MyMethodsContext ctx) {

		AntlrToMethodType ifVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods, condCov);
		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			ifVisitor.visitConditionCoverage((MyReturnMethodContext)ctx.getChild(2));
		}
		else {
			ifVisitor.visitConditionCoverage((MyVoidMethodContext)ctx.getChild(2));
		}

	}


	public MyMethods control(MyMethodsContext ctx) {
		String methodName = ctx.METHODNAME().getText();
		if(methodName.equals(this.t_method_call.getName())) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(this.t_method_call, this.inputValues, this.methodCallParamOrder, this.global_mymethods, this.variableMap);

			if(ctx.getChild(2) instanceof MyReturnMethodContext) {
				MyReturnMethod methodType = (MyReturnMethod) mtVisitor.controlR((MyReturnMethodContext) ctx.getChild(2));
				return new MyMethods(methodName, methodType, 0);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.controlV((MyVoidMethodContext)ctx.getChild(2));
			return new MyMethods(methodName, methodType, 0);
		}
		else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			if(ctx.getChild(2) instanceof MyReturnMethodContext) {
				MyReturnMethod methodType = (MyReturnMethod) mtVisitor.visit(ctx.getChild(2));
				return new MyMethods(methodName, methodType, 0);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			return new MyMethods(methodName, methodType, 0);


		}
	}



	//defCoverage
	public MyMethods defControl(MyMethodsContext ctx) {
		local_variableMap = new HashMap<>();
		Token token = ctx.METHODNAME().getSymbol();
		int line  = token.getLine();
		String methodName = ctx.METHODNAME().getText();

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues);

			MethodType methodType = (MyReturnMethod)mtVisitor.defControlR((MyReturnMethodContext)ctx.getChild(2));
			Map <String, String> parameter = ((MyReturnMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			if(t_method_call instanceof ReturnMethodCall) {
				checkTestMethodCallParameter(parameter, methodType, methodName, line);
			}
			String temp = condCov.getCalledMethod(); //condition coverage
			condCov.setCalledMethod(methodName); //condition coverage
			
			getDefCoverage(methodName,((MyReturnMethod)methodType).method_body);
			
			condCov.setCalledMethod(temp); //condition coverage

			for(MyMethods mm : this.global_mymethods) {
				if(mm.methodType instanceof MyReturnMethod) {
					if(mm.methodName.equals(methodName)) {
						declareParameter(((MyReturnMethod)mm.methodType).parameter.getParams());
						if(t_method_call instanceof ReturnMethodCall) {
							checkTestMethodCallParameter(((MyReturnMethod)mm.methodType).parameter.getParams(), mm.methodType, methodName, line);
						}
						
						getDefCoverage(methodName,((MyReturnMethod)mm.methodType).method_body);

						if(local_variableMap.containsKey(((MyReturnMethod)mm.methodType).varName)) {
							((MyReturnMethod)mm.methodType).setJackieReturnCovered(true);
							((MyReturnMethod)mm.methodType).putReturnValue(local_variableMap.get(((MyReturnMethod)mm.methodType).varName));
							
							if(t_method_call instanceof ReturnMethodCall) {
								if(t_method_call.getName().equals(methodName)){
									this.testValue = local_variableMap.get(((MyReturnMethod)mm.methodType).varName);
								}
							}
						}else {
							semanticErrors.add("Error [Line " + ((MyReturnMethod)mm.methodType).jackieReturnLine + "] : " + (((MyReturnMethod)mm.methodType).varName) + " is not declared");
						}

						
					}
				}
			}
			
			if(local_variableMap.containsKey(((MyReturnMethod)methodType).varName)) {
				((MyReturnMethod)methodType).setJackieReturnCovered(true);
				((MyReturnMethod)methodType).putReturnValue(local_variableMap.get(((MyReturnMethod)methodType).varName));
				
				if(t_method_call instanceof ReturnMethodCall) {
					if(t_method_call.getName().equals(methodName)){
						this.testValue = local_variableMap.get(((MyReturnMethod)methodType).varName);
					}
				}
			}else {
				semanticErrors.add("Error [Line " + ((MyReturnMethod)methodType).jackieReturnLine + "] : " + (((MyReturnMethod)methodType).varName) + " is not declared");
			}
			

			return new MyMethods(methodName, (MyReturnMethod)methodType, 0);
		}else {

			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues);

			MethodType methodType = (MyVoidMethod) mtVisitor.defControlV((MyVoidMethodContext)ctx.getChild(2));
			Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			if(t_method_call instanceof VoidMethodCall) {
				checkTestMethodCallParameter(parameter, methodType, methodName, line);
			}

			getDefCoverage(methodName,((MyVoidMethod)methodType).method_body);			

			return new MyMethods(methodName, (MyVoidMethod)methodType, 0);
		}
	}

	private void checkMethodBody(String methodName, MyMethodBody method_body, Map<String, String> parameter, boolean needCheck) {
		checkDeclaration(method_body, parameter); 
		checkAssignment(method_body, parameter); 
		checkIfStatement(methodName, method_body, parameter, needCheck);
		checkLoop(methodName,method_body, parameter, needCheck);
		checkVoidCall(method_body);		
	}

	private void checkDeclaration(MyMethodBody method_body, Map<String, String> parameter){
		for(Declaration d : method_body.declList) {
			if(parameter.containsKey(d.varName)) {
				semanticErrors.add("Error [Line:" + d.line +"]: " + " variable " + d.varName + " already exist in the parameters");
			}else {
				if(local_variableMap.containsKey(d.varName)) {
					semanticErrors.add("Error [Line:" + d.line +"]: " + " variable " + d.varName + " already declared");
				}else {
					local_variableMap.put(d.varName, d.defaultValue);	
				}
			}
		}
	}

	private void checkAssignment(MyMethodBody method_body, Map<String, String> parameter) {
		for(Assignment a: method_body.assiList) {
			if(!local_variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error [Line:" + a.line +"]: " + " variable " + a.varName + " is not declared yet");
			}else {
				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						checkMath((ValueMath)a.expr, a, false);
					}else {
						if(local_variableMap.containsKey(a.varName)) {
							if(local_variableMap.get(a.varName).getType().equals(((Values)a.expr).getValues().getType())) {
								local_variableMap.put(a.varName, ((Values)a.expr).getValues());	
							}else {
								semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
							}
						}
					}
				}else if(a.expr instanceof ReturnMethodCall) {
					ReturnMethodCall rmc = (ReturnMethodCall) a.expr;

					for(MyMethods mm : this.global_mymethods) {
						if(mm.methodType instanceof MyReturnMethod) {
							if(mm.methodName.equals(rmc.methodName)) {
								MyReturnMethod mrm = (MyReturnMethod) mm.methodType;
								if(mrm.parameter.getParams().size() == rmc.call_parameter.getTestCallParams().size()) {
									int i = 0;
									for(Map.Entry<String, String> s: mrm.parameter.getParams().entrySet()) {
										int j = 0;
										for(Input_List list : rmc.call_parameter.getTestCallParams()) {
											if(i == j) {
												if(list instanceof CallParamVarName) {
													CallParamVarName a1 = (CallParamVarName) list;
													if(!this.local_variableMap.get(a1.varName).getType().equals(s.getValue())) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.varName + " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamDouble) {
													CallParamDouble a1 = (CallParamDouble) list;
													if(!s.getValue().equals("DOUBLE")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamNum) {
													CallParamNum a1 = (CallParamNum) list;
													if(!s.getValue().equals("INT")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.num+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamChar) {
													CallParamChar a1 = (CallParamChar) list;
													if(!s.getValue().equals("CHAR")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamString) {
													CallParamString a1 = (CallParamString) list;
													if(!s.getValue().equals("STRING")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamBoolean) {
													CallParamBoolean a1 = (CallParamBoolean) list;
													if(!s.getValue().equals("BOOLEAN")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}
											}
											j++;
										}
										i++;
									}
								}else {
									this.semanticErrors.add("Error [Line " + a.line + " ] : method call " + rmc.methodName + " must have the same number of parameters as mymethod " + mm.methodName);
								}
							}
						}
					}
				}else {
					this.semanticErrors.add("Error [Line:" + a.line +"]: " + " variable " + a.varName + " return type does not match expression return type.");
				}
			}
		}
	}

	private void checkIfStatement(String methodName, MyMethodBody methodbody , Map<String, String> parameter, boolean needCheck) {
		for(IfStatement i : methodbody.ifStatList) {
			if(getCondType(i.cond).equals("NO")) {
				if(!semanticErrors.contains("Error [Line:" + i.line +"]: " + " condition " + i.cond.toString() + " error. LHS and RHS must match")){
					semanticErrors.add("Error [Line:" + i.line +"]: " + " condition " + i.cond.toString() + " error. LHS and RHS must match");
				}
			}

			MyMethodBody ifBody = i.ifBody;
			MyMethodBody elseBody = i.elseBody;

			if(evaluated(i.cond, local_variableMap)) {
				checkIfBody(methodName,ifBody, methodbody, parameter, needCheck);

				checkIfBody(methodName,elseBody, methodbody, parameter, needCheck);

			}else {
				checkIfBody(methodName,ifBody, methodbody, parameter, needCheck);

				checkIfBody(methodName,elseBody, methodbody, parameter, needCheck);

			}	

		}

	}

	private void checkIfBody(String methodName,MyMethodBody ifBody, MyMethodBody methodbody , Map<String, String> parameter, boolean needCheck) {
		for(Declaration d : ifBody.declList) {
			if(parameter.containsKey(d.varName)) {
				if(!semanticErrors.contains("Error [Line:" + d.line +"]: " + d.varName + " is a parameter of mymethod")) {
					semanticErrors.add("Error [Line:" + d.line +"]: " + d.varName + " is a parameter of mymethod");	
				}
			}
		}

		checkDeclaration(ifBody, parameter);

		checkAssignment(ifBody, parameter);

		if(ifBody.ifStatList.size() > 0) {
			checkIfStatement(methodName,ifBody, parameter, needCheck);
		}

		if(ifBody.loops.size() > 0) {
			checkLoop(methodName,ifBody, parameter, needCheck);
		}

		if(ifBody.methodCall.size() > 0) {
			checkVoidCall(ifBody);
		}		
	}

	private void checkElseBody(String methodName,MyMethodBody elsemethod, MyMethodBody methodbody, Map<String, String> parameter, Boolean needCheck) {
		for(Declaration d : elsemethod.declList) {
			for(Declaration dl: methodbody.declList) {
				if(d.varName.equals(dl.varName)) {
					semanticErrors.add("Error [Line:" + d.line +"]: " + d.varName + " already been declared in mymethod");
				}
			}
		}

		for(Assignment a: elsemethod.assiList) {
			if(!local_variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error [Line:" + a.line +"]: " + " variable " + a.varName + " is not declared yet");
			}else {
				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						checkMath((ValueMath)a.expr, a, false);
					}else {
						if(local_variableMap.containsKey(a.varName)) {
							if(!local_variableMap.get(a.varName).getType().equals(((Values)a.expr).getValues().getType())) {
								semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
							}
						}
					}
				}else if(a.expr instanceof ReturnMethodCall) {
					ReturnMethodCall rmc = (ReturnMethodCall) a.expr;

					for(MyMethods mm : this.global_mymethods) {
						if(mm.methodType instanceof MyReturnMethod) {
							if(mm.methodName.equals(rmc.methodName)) {
								MyReturnMethod mrm = (MyReturnMethod) mm.methodType;
								if(mrm.parameter.getParams().size() == rmc.call_parameter.getTestCallParams().size()) {
									int i = 0;
									for(Map.Entry<String, String> s: mrm.parameter.getParams().entrySet()) {
										int j = 0;
										for(Input_List list : rmc.call_parameter.getTestCallParams()) {
											if(i == j) {
												if(list instanceof CallParamVarName) {
													CallParamVarName a1 = (CallParamVarName) list;
													if(!this.local_variableMap.get(a1.varName).getType().equals(s.getValue())) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.varName + " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamDouble) {
													CallParamDouble a1 = (CallParamDouble) list;
													if(!s.getValue().equals("DOUBLE")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamNum) {
													CallParamNum a1 = (CallParamNum) list;
													if(!s.getValue().equals("INT")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.num+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamChar) {
													CallParamChar a1 = (CallParamChar) list;
													if(!s.getValue().equals("CHAR")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamString) {
													CallParamString a1 = (CallParamString) list;
													if(!s.getValue().equals("STRING")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}else if(list instanceof CallParamBoolean) {
													CallParamBoolean a1 = (CallParamBoolean) list;
													if(!s.getValue().equals("BOOLEAN")) {
														semanticErrors.add("Error [Line " + a.line + "] : " + a1.input+ " does not have the same data type as " + s.getKey() + " from " + mm.methodName);
													}
												}
											}
											j++;
										}
										i++;
									}
								}else {
									this.semanticErrors.add("Error [ Line " + a.line + " ] : method call " + rmc.methodName + " must have the same number of parameters as mymethod " + mm.methodName);
								}
							}
						}
					}
				}else {
					this.semanticErrors.add("Error [Line:" + a.line +"]: " + " variable " + a.varName + " return type does not match expression return type.");
				}
			}
		}

		if(elsemethod.ifStatList.size() > 0) {
			checkIfStatement(methodName,elsemethod, parameter, needCheck);
		}

		if(elsemethod.loops.size() > 0) {
			checkLoop(methodName,elsemethod, parameter, needCheck);
		}

		if(elsemethod.methodCall.size() > 0) {
			checkVoidCall(elsemethod);
		}		
	}

	private void checkLoop(String methodName, MyMethodBody method_body, Map<String, String> parameter, boolean needCheck) {
		for(Loop l : method_body.loops) {
			int i = 0;
			for(MyMethodBody mb: l.loopbody) {
				if(i == 0) {
					checkDeclaration(mb, parameter);
				}

				checkAssignment(mb, parameter);

				if(mb.ifStatList.size() > 0) {
					checkIfStatement(methodName,mb, parameter, needCheck);
				}

				if(mb.loops.size() > 0) {
					checkLoop(methodName,mb, parameter, needCheck);
				}

				if(mb.methodCall.size() > 0) {
					checkVoidCall(mb);
				}	
				i++;
			}
		}
	}

	private void checkVoidCall(MyMethodBody method_body) {
		for( MethodCall m: method_body.methodCall) {
			if(m instanceof VoidMethodCall) {

			}else {
				semanticErrors.add("Error [Line:" + ((ReturnMethodCall)m).line +"]: " + " Only void method call is allowed");
			}
		}
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private void getDefCoverage(String methodName,MyMethodBody method_body) {
		for(Declaration d: method_body.declList) {
			d.setCovered(true);
			local_variableMap.put(d.varName, d.defaultValue);
		}

		for(Assignment a: method_body.assiList) {
			if(a.expr instanceof Values) {
				a.setCovered(true);
				if(((Values)a.expr) instanceof ValueMath) {
					checkMath((ValueMath)a.expr, a, true);
				}else {
					local_variableMap.put(a.varName, ((Values)a.expr).getValues());	
				}

			}else if(a.expr instanceof ReturnMethodCall) {
				a.setCovered(true);
				if(smtg(methodName,a.expr, a, true)) {
					this.local_variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
				}

			}
		}

		defCheckIf(methodName,method_body, true);
		defCheckLoop(methodName,method_body, true);
		defCheckVoid(methodName, method_body);

	}

	private void defCheckIf(String methodName, MyMethodBody method_body, boolean needCheck) {
		for(IfStatement ifs: method_body.ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;


			List<String> list = new ArrayList<>();
			list = getCondVariableList(ifs.cond, list);

			condCov.setIfStatString(methodName + ".jackieAsks[" + ifs.cond.toString() + "]"); // condition coverage

			ifs.setCoveredJackieIf(needCheck);
			//I really need to call eval() only once, so I changed this to be called once...
			boolean res = evaluated(ifs.cond, local_variableMap);
			condCov.addResult(); //condition coverage (get test values here)
			
			ifs.setCond(res);
			if(res) {
				getForIfBody(methodName, ifBody, needCheck);
			}else {
				getForIfBody(methodName, elseBody, needCheck);
			}


		}

	}

	private void getForIfBody(String methodName, MyMethodBody method_body, boolean needCheck) {
		Map<String, Values> local = new HashMap<>();
		local.putAll(local_variableMap);
		
		for(Declaration d: method_body.declList) {
			d.setCovered(needCheck);
//			local_variableMap.put(d.varName, d.defaultValue);
			local.put(d.varName, d.defaultValue);
		}

		for(Assignment a: method_body.assiList) {
			a.setCovered(needCheck);
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
//					checkMath((ValueMath)a.expr, a, true);
					local.put(a.varName, getMath(local, (ValueMath)a.expr, a, true) );
				}else {
					local.put(a.varName, ((Values)a.expr).getValues());	
				}

			}else if(a.expr instanceof ReturnMethodCall) {
				if(smtg2(local, methodName, a.expr, a, needCheck)) {
					local.put(a.varName, callExpr2(method_body, ((ReturnMethodCall)a.expr), a.varName, local));
				}
			}
		}

		if(method_body.ifStatList.size() > 0) {
			Map<String, Values> tmp = new HashMap<>();
			tmp = defCheckIflocal(local, methodName,method_body, needCheck);
			
			for(Map.Entry<String, Values> lo: local.entrySet()) {
				if(tmp.containsKey(lo.getKey())) {
					lo.setValue(tmp.get(lo.getKey()));
				}
			}
		}

		if(method_body.loops.size() > 0) {
			Map<String, Values> tmp = new HashMap<>();
			tmp = defCheckLoopLocal(local, methodName,method_body, needCheck);
			
			for(Map.Entry<String, Values> lo: local.entrySet()) {
				if(tmp.containsKey(lo.getKey())) {
					lo.setValue(tmp.get(lo.getKey()));
				}
			}
		}

		if(method_body.methodCall.size() > 0) {
			defCheckVoidLocal(methodName, method_body, local);
		}
		
		for(Map.Entry<String, Values> lo: local_variableMap.entrySet()) {
			if(local.containsKey(lo.getKey())) {
				lo.setValue(local.get(lo.getKey()));
			}
		}
	}
	
	private Map<String, Values> defCheckIflocal(Map<String, Values>localMain, String methodName, MyMethodBody method_body, boolean needCheck) {
		Map<String, Values> local = new HashMap<>();
		local.putAll(localMain);
		
		for(IfStatement ifs: method_body.ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;


			List<String> list = new ArrayList<>();
			list = getCondVariableList(ifs.cond, list);

			condCov.setIfStatString(methodName + ".jackieAsks[" + ifs.cond.toString() + "]"); // condition coverage

			ifs.setCoveredJackieIf(needCheck);
			//I really need to call eval() only once, so I changed this to be called once...
			boolean res = evaluated(ifs.cond, local);
			condCov.addResult(); //condition coverage (get test values here)
			
			ifs.setCond(res);
			if(res) {
				Map<String, Values> tmp = new HashMap<>();
				tmp = getForIfBodyLocal(local, methodName,ifBody, needCheck);
				
				for(Map.Entry<String, Values> lo: local.entrySet()) {
					if(tmp.containsKey(lo.getKey())) {
						lo.setValue(tmp.get(lo.getKey()));
					}
				}
			}else {
				Map<String, Values> tmp = new HashMap<>();
				tmp = getForIfBodyLocal(local, methodName,elseBody, needCheck);
				
				for(Map.Entry<String, Values> lo: local.entrySet()) {
					if(tmp.containsKey(lo.getKey())) {
						lo.setValue(tmp.get(lo.getKey()));
					}
				}
			}


		}

		return local;
	}
	
	private Map<String, Values> getForIfBodyLocal(Map<String, Values> localMain, String methodName, MyMethodBody method_body, boolean needCheck) {
		Map<String, Values> local = new HashMap<>();
		local.putAll(localMain);
		
		for(Declaration d: method_body.declList) {
			d.setCovered(needCheck);
//			local_variableMap.put(d.varName, d.defaultValue);
			local.put(d.varName, d.defaultValue);
		}

		for(Assignment a: method_body.assiList) {
			a.setCovered(needCheck);
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
//					checkMath((ValueMath)a.expr, a, true);
					local.put(a.varName, getMath(local, (ValueMath)a.expr, a, true) );
				}else {
					local.put(a.varName, ((Values)a.expr).getValues());	
				}

			}else if(a.expr instanceof ReturnMethodCall) {
				if(smtg2(local, methodName, a.expr, a, needCheck)) {
					local.put(a.varName, callExpr2(method_body, ((ReturnMethodCall)a.expr), a.varName, local));
				}
			}
		}

		if(method_body.ifStatList.size() > 0) {
			Map<String, Values> tmp = new HashMap<>();
			tmp = defCheckIflocal(local, methodName,method_body, needCheck);
			
			for(Map.Entry<String, Values> lo: local.entrySet()) {
				if(tmp.containsKey(lo.getKey())) {
					lo.setValue(tmp.get(lo.getKey()));
				}
			}
		}

		if(method_body.loops.size() > 0) {
			Map<String, Values> tmp = new HashMap<>();
			tmp = defCheckLoopLocal(local, methodName,method_body, needCheck);
			
			for(Map.Entry<String, Values> lo: local.entrySet()) {
				if(tmp.containsKey(lo.getKey())) {
					lo.setValue(tmp.get(lo.getKey()));
				}
			}
		}

		if(method_body.methodCall.size() > 0) {
			defCheckVoidLocal(methodName, method_body, local);
		}
		
		return local;
	}

	private void defCheckLoop(String methodName, MyMethodBody method_body, boolean needCheck) {
		for(Loop lo : method_body.loops) {
			lo.setForCovered(needCheck);
			if(lo.iterationGoal != 0) {
				for(int i = 0; i < lo.iterationGoal; i++) {
					getForIfBody(methodName, lo.body, needCheck);
				}
			}

		}
	}
	
	private Map<String, Values> defCheckLoopLocal(Map<String, Values> localMain, String methodName, MyMethodBody method_body, boolean needCheck) {
		Map<String, Values> local = new HashMap<>();
		local.putAll(localMain);
		
		for(Loop lo : method_body.loops) {
			lo.setForCovered(needCheck);
			if(lo.iterationGoal != 0) {
				for(int i = 0; i < lo.iterationGoal; i++) {
					
					Map<String, Values> tmp = new HashMap<>();
					tmp = getForIfBodyLocal(local, methodName, lo.body, needCheck);
					
					for(Map.Entry<String, Values> loc: local.entrySet()) {
						if(tmp.containsKey(loc.getKey())) {
							loc.setValue(tmp.get(loc.getKey()));
						}
					}

				}
			}

		}
		
		return local;
	}

	private void defCheckVoid(String methodName, MyMethodBody method_body) {
		for(MethodCall v: method_body.methodCall) {
			if(v instanceof VoidMethodCall) {
				List<String> params = ((VoidMethodCall)v).call_parameter.getCallParams();
				String parameter = ""; int i = 0;
				for(String s: params) {
					parameter+= s;
					if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
						parameter += ", ";
					}
					i++;
				}
				VoidMethodCall vmc = (VoidMethodCall) v;
				if(smtgVoid(methodName, vmc, true)) {
					vmc.setCovered(true);
					callVoidMethodCall(vmc, this.local_variableMap);
				}
			}
		}
	}
	
	private void defCheckVoidLocal(String methodName, MyMethodBody method_body, Map<String, Values> local) {
		for(MethodCall v: method_body.methodCall) {
			if(v instanceof VoidMethodCall) {
				List<String> params = ((VoidMethodCall)v).call_parameter.getCallParams();
				String parameter = ""; int i = 0;
				for(String s: params) {
					parameter+= s;
					if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
						parameter += ", ";
					}
					i++;
				}
				VoidMethodCall vmc = (VoidMethodCall) v;
				if(smtgVoid(methodName, vmc, true)) {
					vmc.setCovered(true);
					callVoidMethodCall(vmc, local);
				}
			}
		}
	}


	private boolean smtgVoid(String methodName, VoidMethodCall vmc, Boolean needCheck) {
		if(needCheck) {
			if (checkIfMyMethodContainsVoidMethodCall(vmc, this.global_mymethods)) { //if rhs methodcall is declared 
				String rhsMethodName = vmc.methodname; 
				for(MyMethods m: this.global_mymethods) { //grab method from DeclaredMethodsList, find matching method, check for return data type against type
					if(m.methodName.equals(rhsMethodName)) {

						List<Input_List> RHSparams = vmc.call_parameter.getTestCallParams();
						Map<String, String> methodparams = ((MyVoidMethod)m.methodType).parameter.getParams();
						if(RHSparams.size() != methodparams.size()) {
							semanticErrors.contains("Error [Line:" + vmc.line +"]: methodcall must have the same number of parameters as mymethod " + m.methodName);
						}else {
							Map<String, Values> callInputs = new LinkedHashMap<>();
							int i = 0;
							for(Map.Entry<String, String> map: methodparams.entrySet()){
								int j = 0;
								for(Input_List p: RHSparams) {
									if(i == j) {
										if(p instanceof CallParamVarName) {
											CallParamVarName a1 = (CallParamVarName) p;
											if(!this.local_variableMap.containsKey(a1.varName)) {
												semanticErrors.add("Error [Line:" + m.line +"]: " + a1.varName + " in mymethods" + m.methodName + " does not exist");
											}else {
												callInputs.put("" + i, this.local_variableMap.get(a1.varName));
											}
										}else if(p instanceof CallParamDouble) {
											CallParamDouble a1 = (CallParamDouble) p;
											callInputs.put("" + i, new ValueDouble(a1.input));		
										}else if(p instanceof CallParamNum) {
											CallParamNum a1 = (CallParamNum) p;
											callInputs.put("" + i, new ValueNum(a1.num));		
										}else if(p instanceof CallParamChar) {
											CallParamChar a1 = (CallParamChar) p;
											callInputs.put("" + i, new ValueChar(a1.input));		
										}else if(p instanceof CallParamString) {
											CallParamString a1 = (CallParamString) p;
											callInputs.put("" + i, new ValueString(a1.input));		
										}else if(p instanceof CallParamBoolean) {
											CallParamBoolean a1 = (CallParamBoolean) p;
											callInputs.put("" + i, new ValueBool(a1.input));		
										}
									}
									j++;
								}
								i++;
							}
						}

						if(m.methodType instanceof MyVoidMethod) {
							System.out.println("return type checking error");
							return false;
						}
					}
				}
				return false;
			}else if(vmc.methodname.equals(methodName)){
				this.semanticErrors.add("StackOverflowError [Line:" + vmc.line +"]: mymethod " + methodName + " cannot call itself : " + vmc.toString());
				return false;
			}
			else { //if method not declared
				this.semanticErrors.add("Error [Line:" + vmc.line +"]: Void Method Call is not declared");
				return false;
			}
		}else {
			return true;
		}
	}

	private boolean checkIfMyMethodContainsVoidMethodCall(VoidMethodCall vmc, List<MyMethods> mymethod) {
		for(MyMethods i: mymethod) {
			if(i.methodName.equals(vmc.methodname)) {
				return true;
			}
		}
		return false;
	}

	private Values callVoidMethodCall(VoidMethodCall vmc, Map<String, Values> vars2) {
		for(MyMethods m : this.global_mymethods) {
			if(m.methodName.equals(vmc.methodname) && m.methodType instanceof MyVoidMethod) {
				boolean noerror = true;
				List<Input_List> RHSparams = vmc.call_parameter.getTestCallParams();
				Map<String, String> methodparams = ((MyVoidMethod)m.methodType).parameter.getParams();
				if(RHSparams.size() == methodparams.size() && RHSparams.size() > 0) {

					Map<String, Values> lists = new LinkedHashMap<>();
					int num = 0;
					for(Input_List p: RHSparams) {

						if(p instanceof CallParamVarName) {
							CallParamVarName a = (CallParamVarName) p;
							if(this.local_variableMap.containsKey(a.varName)) {
								lists.put("" + num, this.local_variableMap.get(a.varName));
							}else {
								semanticErrors.add("Error [Line " + vmc.line + "] : " + a.varName + " is not declared");
							}
						}else if(p instanceof CallParamDouble) {
							CallParamDouble a = (CallParamDouble) p;
							lists.put("" + num, new ValueDouble(a.input));		
						}else if(p instanceof CallParamNum) {
							CallParamNum a = (CallParamNum) p;
							lists.put("" + num, new ValueNum(a.num));		
						}else if(p instanceof CallParamChar) {
							CallParamChar a = (CallParamChar) p;
							lists.put("" + num, new ValueChar(a.input));		
						}else if(p instanceof CallParamString) {
							CallParamString a = (CallParamString) p;
							lists.put("" + num, new ValueString(a.input));		
						}else if(p instanceof CallParamBoolean) {
							CallParamBoolean a = (CallParamBoolean) p;
							lists.put("" + num, new ValueBool(a.input));		
						}
						num++;
					}

					Values v = ((MyVoidMethod)m.methodType).getValue(lists);
					return v;
				}
			}

		}
		return null;
	}

	private void evaluateLoop(String methodName, MyMethodBody loopbody, boolean needCheck) {
		for(Declaration d: loopbody.declList) {
			d.setCovered(needCheck);
			local_variableMap.put(d.varName, d.defaultValue);
		}

		for(Assignment a: loopbody.assiList) {
			a.setCovered(needCheck);
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					checkMath((ValueMath)a.expr, a, true);
				}else {
					local_variableMap.put(a.varName, ((Values)a.expr).getValues());	
				}
			}else if(a.expr instanceof ReturnMethodCall) {
				if(smtg(methodName, a.expr, a, needCheck)) {
					this.local_variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
				}
			}
		}

		if(loopbody.ifStatList.size() > 0) {
			defCheckIf(methodName, loopbody, needCheck);
		}

		if(loopbody.loops.size() > 0) {
			defCheckLoop(methodName, loopbody, needCheck);
		}

		if(loopbody.methodCall.size() > 0) {
			defCheckVoid(methodName, loopbody);
		}		
	}

	private List<String> getCondVariableList(Condition c, List<String> list) {
		if(c instanceof Negation) {
			Negation e = (Negation) c;
			list = getCondVariableList(e.cond, list);
		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			list = getCondVariableList(e.cond, list);
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			list = getCondVariableList(e.cond1, list);
			list = getCondVariableList(e.cond2, list);
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			list = getCondVariableList(e.cond1, list);
			list = getCondVariableList(e.cond2, list);
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			list = getCondVariableList(e.cond1, list);
			list = getCondVariableList(e.cond2, list);
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			list = getCondVariableList(e.left, list);
			list = getCondVariableList(e.right, list);
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			list = getVariables(e.left, list);
			list = getVariables(e.right, list);
		}else if(c instanceof More) {
			More e = (More) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof Less) {
			Less e = (Less) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			if(!list.contains(e.varName)) {
				list.add(e.varName);
			}
		}
		return list;
	}

	private List<String> getVariables(Mathematics m, List<String> list) {
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			list= getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			list = getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			list = getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof Division) {
			Division a = (Division) m;
			list = getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(!list.contains(a.varName)) {
				list.add(a.varName);
			}
		}

		return list;
	}

	private void declareParameter(Map<String, String> parameter) {
		for(Map.Entry<String, String> p : parameter.entrySet()) {
			String dataType = p.getValue();

			if(dataType.equals("BOOLEAN")) {
				local_variableMap.put(p.getKey(), new ValueBool(false));
			}
			else if (dataType.equals("INT")) {
				local_variableMap.put(p.getKey(), new ValueNum(0));
			}
			else if (dataType.equals("DOUBLE")) {
				local_variableMap.put(p.getKey(), new ValueDouble((double)0));
			}
			else if (dataType.equals("STRING")) {
				local_variableMap.put(p.getKey(), new ValueString(""));
			}
			else if (dataType.equals("CHAR")) {
				local_variableMap.put(p.getKey(), new ValueChar('\u0000'));
			}
		}
	}

	private boolean checkIfMyMethodContainsReturnMethodCall(ReturnMethodCall r, List<MyMethods> mymethod) {
		for(MyMethods i: mymethod) {
			if(i.methodName.equals(r.methodName)) {
				return true;
			}
		}
		return false;
	}

	private void checkTestMethodCallParameter(Map<String, String> parameter, MethodType methodtype, String methodName, int line) {
		if(methodtype instanceof MyReturnMethod) {
			String rhsMethodName = this.t_method_call.getName(); 
			if(methodName.equals(rhsMethodName)) {

				List<Input_List> RHSparams = ((ReturnMethodCall)this.t_method_call).call_parameter.getTestCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)methodtype).parameter.getParams();
				if(RHSparams.size() != methodparams.size()) {
					semanticErrors.add("Error [Line:" + ((ReturnMethodCall)this.t_method_call).line +"]: " + ((ReturnMethodCall)this.t_method_call).toString() + " must have the same number of parameters as mymethod " + methodName);

				}else {
					int i = 0;
					for(Map.Entry<String, String> map: methodparams.entrySet()){
						int j = 0;
						for(Map.Entry<String, Values> input: inputValues.entrySet()) {
							if(i == j) {
								if(map.getValue().equals(input.getValue().getType())) {
									this.local_variableMap.put(map.getKey(), input.getValue());
								}else {
									semanticErrors.add("Error [Line:" + line +"]: parameter " + map.getKey() + " from mymethod "+methodName+" does not have the same datatype as methodcall from line " + ((ReturnMethodCall)this.t_method_call).line);
								}
							}
							j++;
						}
						i++;
					}
				}
			}

		}else if(methodtype instanceof MyVoidMethod) {
			String rhsMethodName = this.t_method_call.getName(); 
			if(methodName.equals(rhsMethodName)) {

				List<Input_List> RHSparams = ((VoidMethodCall)this.t_method_call).call_parameter.getTestCallParams();
				Map<String, String> methodparams = ((MyVoidMethod)methodtype).parameter.getParams();
				if(RHSparams.size() != methodparams.size()) {
					semanticErrors.add("Error [Line:" + line +"]: " + ((VoidMethodCall)this.t_method_call).toString() + " must have the same number of parameters as mymethod " + methodName);

				}else {
					int i = 0;
					for(Map.Entry<String, String> map: methodparams.entrySet()){
						int j = 0;
						for(Map.Entry<String, Values> input: inputValues.entrySet()) {
							if(i == j) {
								if(map.getValue().equals(input.getValue().getType())) {
									this.local_variableMap.put(map.getKey(), input.getValue());
								}else {
									semanticErrors.add("Error [Line:" + line +"]: parameter " + map.getKey() + " from mymethod "+methodName+" does not have the same datatype");
								}
							}
							j++;
						}
						i++;
					}
				}
			}
		}
	}

	private Values callExpr(ReturnMethodCall r, String varName) {
		for(MyMethods m : this.global_mymethods) {
			if(m.methodName.equals(r.methodName) && m.methodType instanceof MyReturnMethod) {
				boolean noerror = true;
				List<Input_List> RHSparams = r.call_parameter.getTestCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
				if(RHSparams.size() == methodparams.size() && RHSparams.size() > 0) {

					Map<String, Values> lists = new LinkedHashMap<>();
					int num = 0;
					for(Input_List p: RHSparams) {

						if(p instanceof CallParamVarName) {
							CallParamVarName a = (CallParamVarName) p;
							if(this.local_variableMap.containsKey(a.varName)) {
								lists.put("" + num, this.local_variableMap.get(a.varName));
							}else {
								semanticErrors.add("Error [Line " + r.line + "] : " + a.varName + " is not declared");
							}
						}else if(p instanceof CallParamDouble) {
							CallParamDouble a = (CallParamDouble) p;
							lists.put("" + num, new ValueDouble(a.input));		
						}else if(p instanceof CallParamNum) {
							CallParamNum a = (CallParamNum) p;
							lists.put("" + num, new ValueNum(a.num));		
						}else if(p instanceof CallParamChar) {
							CallParamChar a = (CallParamChar) p;
							lists.put("" + num, new ValueChar(a.input));		
						}else if(p instanceof CallParamString) {
							CallParamString a = (CallParamString) p;
							lists.put("" + num, new ValueString(a.input));		
						}else if(p instanceof CallParamBoolean) {
							CallParamBoolean a = (CallParamBoolean) p;
							lists.put("" + num, new ValueBool(a.input));		
						}
						num++;
					}
					//					boolean contains = true;
					//					Map<String, Values> lists = new LinkedHashMap<>();
					//					for(String s : RHSparams) {
					//						if(!this.local_variableMap.containsKey(s)) {
					//							contains = false;
					//						}else {
					//							lists.put(s, this.local_variableMap.get(s));
					//						}
					//					}
					//
					//					if(contains) {
					//						int i = 0;
					//						for(Map.Entry<String, String> map: methodparams.entrySet()){
					//							if(!(this.local_variableMap.get(RHSparams.get(i)).getType().equals(map.getValue()))){
					//								noerror = false;
					//							}
					//							i++;
					//						}
					//					}
					//
					//					if(noerror) {
					////						for(MyMethods gm : this.global_mymethods) {
					////							if(gm.methodName.equals(r.methodName)) {
					////								if(gm.methodType instanceof MyReturnMethod) {
					////
					////								}
					////							}
					////						}
					Values v = this.getValue(m.methodName,((MyReturnMethod)m.methodType), lists);
					return v;
					//					}
				}
			}

		}

		return this.local_variableMap.get(varName);

	}

	private Values getValue(String methodName, MyReturnMethod myReturnMethod, Map<String, Values> lists) {
		Values result = null;
		for(MyMethods mm : this.global_mymethods) {
			if(mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mrm = (MyReturnMethod) mm.methodType;
				if(mm.methodName.equals(methodName)){
					 result = getValues(mrm, mrm.method_body,  mrm.parameter , lists).get(mrm.varName);
				}
			}
		}
		return result;
	}

	private Map<String, Values> getValues(MyReturnMethod myReturnMethod, MyMethodBody method_body, Parameter parameter, Map<String, Values> lists) {
			int j = 0;
			for(Map.Entry<String, String> p : parameter.getParams().entrySet()) {
				int i = 0;
				for(Map.Entry<String, Values> l : lists.entrySet()) {
					if(i == j) {
						method_body.vars.put(p.getKey(), l.getValue());
					}
					i++;
				}
				j++;
			}
			getDeclaredList(method_body, method_body.vars, parameter);
			
			myReturnMethod.setJackieReturnCovered(true);

			return method_body.vars;
		
	}
	
	public void getDeclaredList(MyMethodBody method_body, Map<String, Values> vars2, Parameter parameter) {
		method_body.vars.putAll(vars2);

		for(Declaration d: method_body.declList) {
			d.setCovered(true);
			method_body.vars.put(d.varName, d.defaultValue);
		}

		for(Assignment a : method_body.assiList) {
			a.setCovered(true);
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					String type = getMATHTYPE(((ValueMath)a.expr).math);
					if(type == "DOUBLE") {
						double d = getDouble(method_body, ((ValueMath)a.expr).math, parameter);
						method_body.vars.put(a.varName, new ValueDouble(d));
					}else if(type == "INT") {
						int i = getInt(method_body,((ValueMath)a.expr).math, parameter);
						method_body.vars.put(a.varName, new ValueNum(i));
					}
				}else {
					method_body.vars.put(a.varName, ((Values)a.expr).getValues());
				}
			}else if(a.expr instanceof ReturnMethodCall) {
				method_body.vars.put(a.varName, callExpr2(method_body,((ReturnMethodCall)a.expr), a.varName, method_body.vars));
			}
		}

		for(IfStatement ifs: method_body.ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;


			List<String> convarlist = new ArrayList<>();
			convarlist = getCondVariableList(ifs.cond, convarlist);

			ifs.setCond(method_body.evaluated(ifs.cond, method_body.vars, parameter));

			ifs.setCoveredJackieIf(true);
			if(method_body.evaluated(ifs.cond, method_body.vars, parameter)) {
				method_body.vars.putAll(getList(ifBody, method_body.vars, parameter, true));
			}else {
				method_body.vars.putAll(getList(elseBody, method_body.vars, parameter, true));
			}
		}

		for(Loop lo: method_body.loops) {
			lo.setForCovered(true);
			if(lo.iterationGoal!= 0) {
				for(int i = 0; i < lo.iterationGoal; i++) {
					method_body.vars.putAll(getList(lo.body, method_body.vars, parameter, true));
				}
			}

		}

		for(MethodCall v : method_body.methodCall) {
			if(v instanceof VoidMethodCall) {
				VoidMethodCall vmc = (VoidMethodCall) v;
				vmc.setCovered(true);
				callVoidMethodCall(vmc, method_body.vars);
			}
		}
	}
	
	public Map<String, Values> getList(MyMethodBody body, Map<String, Values> vars2, Parameter parameter, boolean b) {
		body.vars.putAll(vars2);

		for(Declaration d: body.declList) {
			d.setCovered(b);
			body.vars.put(d.varName, d.defaultValue);
		}

		for(Assignment a : body.assiList) {
			a.setCovered(b);
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					String type = getMATHTYPEbody(((ValueMath)a.expr).math, body.vars);
					if(type == "DOUBLE") {
						double d = getDouble(body, ((ValueMath)a.expr).math, parameter);
						body.vars.put(a.varName, new ValueDouble(d));
					}else if(type == "INT") {
						int i = getInt(body, ((ValueMath)a.expr).math, parameter);
						body.vars.put(a.varName, new ValueNum(i));
					}
				}else {
					body.vars.put(a.varName, ((Values)a.expr).getValues());
				}
			}else if(a.expr instanceof ReturnMethodCall) {
				body.vars.put(a.varName, callExpr2(body, ((ReturnMethodCall)a.expr), a.varName, body.vars));
			}
		}

		for(IfStatement ifs: body.ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;


			List<String> convarlist = new ArrayList<>();
			convarlist = getCondVariableList(ifs.cond, convarlist);

			ifs.setCond(body.evaluated(ifs.cond, body.vars, parameter));

			ifs.setCoveredJackieIf(b);
			if(body.evaluated(ifs.cond, body.vars, parameter)) {
				body.vars.putAll(getList(ifBody, body.vars, parameter, b));

			}else {
				body.vars.putAll(getList(elseBody, body.vars, parameter, b));

			}
		}

		for(Loop lo: body.loops) {
			lo.setForCovered(b);
			if(lo.iterationGoal != 0) {
				for(int i = 0; i < lo.iterationGoal; i++) {
					body.vars.putAll(getList(body, body.vars, parameter, b));
				}
			}
		}

		return body.vars;
	}
	
	private String getMATHTYPEbody(Mathematics m, Map<String, Values> vars) {
		String result = "";

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			String left = getMATHTYPEbody(a.math1, vars);
			String right = getMATHTYPEbody(a.math2, vars);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			String left = getMATHTYPEbody(a.math1, vars);
			String right = getMATHTYPEbody(a.math2, vars);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			String left = getMATHTYPEbody(a.math1, vars);
			String right = getMATHTYPEbody(a.math2, vars);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Division) {
			Division a = (Division) m;
			String left = getMATHTYPEbody(a.math1, vars);
			String right = getMATHTYPEbody(a.math2, vars);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMATHTYPEbody(a.math, vars);
		}else if(m instanceof MathNumber) {
			result = "INT";
		}else if(m instanceof MathDouble) {
			result = "DOUBLE";
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(!vars.containsKey(a.varName)) {
				semanticErrors.add("Error [Line:" + a.line +"]: variable " + a.varName + " is not declared");
			}else if(vars.containsKey(a.varName)) {
				result = vars.get(a.varName).getType();
			}
		}

		return result;
	}

	private Values callExpr2(MyMethodBody method_body, ReturnMethodCall r, String varName, Map<String, Values> vars2) {
		method_body.vars.putAll(vars2);

		for(MyMethods m : this.global_mymethods) {
			if(m.methodName.equals(r.methodName) && m.methodType instanceof MyReturnMethod) {
				boolean noerror = true;
				List<Input_List> RHSparams = r.call_parameter.getTestCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
				if(RHSparams.size() == methodparams.size() && RHSparams.size() > 0) {

					Map<String, Values> lists = new LinkedHashMap<>();
					int num = 0;
					for(Input_List p: RHSparams) {

						if(p instanceof CallParamVarName) {
							CallParamVarName a = (CallParamVarName) p;
							if(method_body.vars.containsKey(a.varName)) {
								lists.put("" + num, method_body.vars.get(a.varName));
							}else {
								semanticErrors.add("Error [Line " + r.line + "] : " + a.varName + " is not declared");
							}
						}else if(p instanceof CallParamDouble) {
							CallParamDouble a = (CallParamDouble) p;
							lists.put("" + num, new ValueDouble(a.input));		
						}else if(p instanceof CallParamNum) {
							CallParamNum a = (CallParamNum) p;
							lists.put("" + num, new ValueNum(a.num));		
						}else if(p instanceof CallParamChar) {
							CallParamChar a = (CallParamChar) p;
							lists.put("" + num, new ValueChar(a.input));		
						}else if(p instanceof CallParamString) {
							CallParamString a = (CallParamString) p;
							lists.put("" + num, new ValueString(a.input));		
						}else if(p instanceof CallParamBoolean) {
							CallParamBoolean a = (CallParamBoolean) p;
							lists.put("" + num, new ValueBool(a.input));		
						}
						num++;
					}

					Values v = this.getValue(m.methodName, ((MyReturnMethod)m.methodType), lists);
					return v;
				}
			}

		}

		return method_body.vars.get(varName);

	}

	//	private void checkReturnVar(MyReturnMethod method) {
	//		if(!local_variableMap.containsKey(method.varName)) {
	//			semanticErrors.add("Error  [Line:" + method.line +"]: " +" return variable " + method.varName + " is not declared");
	//		}else {
	//			if(!local_variableMap.get(method.varName).getType().equals(method.dataType)) {
	//				semanticErrors.add("Error: " + method.varName + " should return " + method.dataType + " not " + local_variableMap.get(method.varName).getType());
	//			}else {
	//				method.putReturnValue(local_variableMap.get(method.varName));
	//			}
	//		}
	//
	//	}

	private void checkDeclAssi2(String methodName, MyMethodBody method_body, Map<String, String> parameter) {

		for(Declaration d : method_body.declList) {
			if(parameter.containsKey(d.varName)) {
				semanticErrors.add("Error [Line:" + d.line +"]: variable " + d.varName + " already exist in the parameters");
			}else {
				if(local_variableMap.containsKey(d.varName)) {
					semanticErrors.add("Error [Line:" + d.line +"]: variable " + d.varName + " already declared");
				}else {
					local_variableMap.put(d.varName, d.defaultValue);	
				}
			}
		}

		for(Assignment a: method_body.assiList) {
			if(!local_variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error [Line:" + a.line +"]: variable " + a.varName + " is not declared yet");
			}else {
				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						checkMath((ValueMath)a.expr, a, true);
					}else {
						if(local_variableMap.containsKey(a.varName)) {
							if(local_variableMap.get(a.varName).getType().equals(((Values)a.expr).getValues().getType())) {
								local_variableMap.put(a.varName, ((Values)a.expr).getValues());	
							}else {
								semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
							}
						}
					}
				}else if(a.expr instanceof ReturnMethodCall) {
					if(smtg(methodName, a.expr, a, true)) {
						this.local_variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
					}
				}else {
					this.semanticErrors.add("Error [Line:" + a.line +"]: variable " + a.varName + " return type does not match expression return type.");
				}
			}
		}
	}



	private boolean smtg(String methodName, Expr rhs, Assignment a, Boolean needCheck) {
		if(needCheck) {
			String type = "";
			for(Map.Entry<String, Values> d: local_variableMap.entrySet()) { //find dec type from declarations of game body
				if(d.getKey().equals(a.varName)) {
					type = d.getValue().getType();
				}
			}

			if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, this.global_mymethods)) { //if rhs methodcall is declared 
				String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
				for(MyMethods m: this.global_mymethods) { //grab method from DeclaredMethodsList, find matching method, check for return data type against type
					if(m.methodName.equals(rhsMethodName)) {

						List<Input_List> RHSparams = ((ReturnMethodCall)rhs).call_parameter.getTestCallParams();
						Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
						if(RHSparams.size() != methodparams.size()) {
							semanticErrors.contains("Error [Line:" + ((ReturnMethodCall)rhs).line +"]: methodcall must have the same number of parameters as mymethod " + methodName);
						}else {
							Map<String, Values> callInputs = new LinkedHashMap<>();
							int i = 0;
							for(Map.Entry<String, String> map: methodparams.entrySet()){
								int j = 0;
								for(Input_List p: RHSparams) {
									if(i == j) {
										if(p instanceof CallParamVarName) {
											CallParamVarName a1 = (CallParamVarName) p;
											if(!this.local_variableMap.containsKey(a1.varName)) {
												semanticErrors.add("Error [Line:" + m.line +"]: " + a1.varName + " in mymethods" + m.methodName + " does not exist");
											}else {
												callInputs.put("" + i, this.local_variableMap.get(a1.varName));
											}
										}else if(p instanceof CallParamDouble) {
											CallParamDouble a1 = (CallParamDouble) p;
											callInputs.put("" + i, new ValueDouble(a1.input));		
										}else if(p instanceof CallParamNum) {
											CallParamNum a1 = (CallParamNum) p;
											callInputs.put("" + i, new ValueNum(a1.num));		
										}else if(p instanceof CallParamChar) {
											CallParamChar a1 = (CallParamChar) p;
											callInputs.put("" + i, new ValueChar(a1.input));		
										}else if(p instanceof CallParamString) {
											CallParamString a1 = (CallParamString) p;
											callInputs.put("" + i, new ValueString(a1.input));		
										}else if(p instanceof CallParamBoolean) {
											CallParamBoolean a1 = (CallParamBoolean) p;
											callInputs.put("" + i, new ValueBool(a1.input));		
										}
									}
									j++;
								}
								i++;
							}
						}

						if(m.methodType instanceof MyReturnMethod) {
							return ((MyReturnMethod)m.methodType).dataType.equals(type);
						}
						else { 						//if m.methodType instanceof MyVoidMethod it would have been detected earlier ignore else case
							System.out.println("void type checking error");
							return false;
						}
					}
				}
				return false;
			}else if(((ReturnMethodCall)rhs).methodName.equals(methodName)){
				this.semanticErrors.add("StackOverflowError [Line:" + ((ReturnMethodCall)rhs).line +"]: mymethod " + methodName + " cannot call itself : " + rhs.toString());
				return false;
			}
			else { //if method not declared
				this.semanticErrors.add("Error [Line:" + ((ReturnMethodCall)rhs).line +"]: Return Method Call on RHS is not declared: " + a.varName + " cannot be assigned to: " + rhs.toString());
				return false;
			}
		}else {
			return true;
		}
	}
	
	private boolean smtg2(Map<String, Values> local, String methodName, Expr rhs, Assignment a, Boolean needCheck) {
		if(needCheck) {
			String type = "";
			for(Map.Entry<String, Values> d: local.entrySet()) { //find dec type from declarations of game body
				if(d.getKey().equals(a.varName)) {
					type = d.getValue().getType();
				}
			}

			if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, this.global_mymethods)) { //if rhs methodcall is declared 
				String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
				for(MyMethods m: this.global_mymethods) { //grab method from DeclaredMethodsList, find matching method, check for return data type against type
					if(m.methodName.equals(rhsMethodName)) {

						List<Input_List> RHSparams = ((ReturnMethodCall)rhs).call_parameter.getTestCallParams();
						Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
						if(RHSparams.size() != methodparams.size()) {
							semanticErrors.contains("Error [Line:" + ((ReturnMethodCall)rhs).line +"]: methodcall must have the same number of parameters as mymethod " + methodName);
						}else {
							Map<String, Values> callInputs = new LinkedHashMap<>();
							int i = 0;
							for(Map.Entry<String, String> map: methodparams.entrySet()){
								int j = 0;
								for(Input_List p: RHSparams) {
									if(i == j) {
										if(p instanceof CallParamVarName) {
											CallParamVarName a1 = (CallParamVarName) p;
											if(!local.containsKey(a1.varName)) {
												semanticErrors.add("Error [Line:" + m.line +"]: " + a1.varName + " in mymethods" + m.methodName + " does not exist");
											}else {
												callInputs.put("" + i, local.get(a1.varName));
											}
										}else if(p instanceof CallParamDouble) {
											CallParamDouble a1 = (CallParamDouble) p;
											callInputs.put("" + i, new ValueDouble(a1.input));		
										}else if(p instanceof CallParamNum) {
											CallParamNum a1 = (CallParamNum) p;
											callInputs.put("" + i, new ValueNum(a1.num));		
										}else if(p instanceof CallParamChar) {
											CallParamChar a1 = (CallParamChar) p;
											callInputs.put("" + i, new ValueChar(a1.input));		
										}else if(p instanceof CallParamString) {
											CallParamString a1 = (CallParamString) p;
											callInputs.put("" + i, new ValueString(a1.input));		
										}else if(p instanceof CallParamBoolean) {
											CallParamBoolean a1 = (CallParamBoolean) p;
											callInputs.put("" + i, new ValueBool(a1.input));		
										}
									}
									j++;
								}
								i++;
							}
						}

						if(m.methodType instanceof MyReturnMethod) {
							return ((MyReturnMethod)m.methodType).dataType.equals(type);
						}
						else { 						//if m.methodType instanceof MyVoidMethod it would have been detected earlier ignore else case
							System.out.println("void type checking error");
							return false;
						}
					}
				}
				return false;
			}else if(((ReturnMethodCall)rhs).methodName.equals(methodName)){
				this.semanticErrors.add("StackOverflowError [Line:" + ((ReturnMethodCall)rhs).line +"]: mymethod " + methodName + " cannot call itself : " + rhs.toString());
				return false;
			}
			else { //if method not declared
				this.semanticErrors.add("Error [Line:" + ((ReturnMethodCall)rhs).line +"]: Return Method Call on RHS is not declared: " + a.varName + " cannot be assigned to: " + rhs.toString());
				return false;
			}
		}else {
			return true;
		}
	}
	
	private Values getMath(Map<String, Values> local, ValueMath expr, Assignment a, boolean allowed) {
		String type = getMATHTYPE2(expr.math, local);

		if(type.equals("INT")) {
			if(allowed) {
				int i = getMathINT2(expr.math, local);

				if(local.containsKey(a.varName)) {
					if(local.get(a.varName).getType().equals("INT")) {
						local.put(a.varName, new ValueNum(i));	
					}else {
						semanticErrors.add("Error [Line:" + a.line +"]: "+ ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local.get(a.varName).getType());
					}
				}
			}else {
				if(local.containsKey(a.varName)) {
					if(!local.get(a.varName).getType().equals("INT")) {
						semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local.get(a.varName).getType());
					}
				}
			}

		}else if(type.equals("DOUBLE")) {
			if(allowed) {

				double d = getMATHDOUBLE2(expr.math, local);

				if(local.containsKey(a.varName)) {
					if(local.get(a.varName).getType().equals("DOUBLE")) {
						local.put(a.varName, new ValueDouble(d));
					}else {
						semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local.get(a.varName).getType());
					}
				}
			}else {
				if(local.containsKey(a.varName)) {
					if(!local.get(a.varName).getType().equals("DOUBLE")) {
						semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local.get(a.varName).getType());
					}
				}
			}
		}else if(type.equals("NOT SAME"))  {
			semanticErrors.add("Error  [Line:" + a.line +"]: the LHS datatype and RHS datatype of " + expr.toString() + " must be the same");
		}		

		return local.get(a.varName);
	}

	private void checkMath(ValueMath expr, Assignment a, boolean allowed) {
		String type = getMATHTYPE(expr.math);

		if(type.equals("INT")) {
			if(allowed) {
				int i = getMathINT(expr.math);

				if(local_variableMap.containsKey(a.varName)) {
					if(local_variableMap.get(a.varName).getType().equals("INT")) {
						local_variableMap.put(a.varName, new ValueNum(i));	
					}else {
						semanticErrors.add("Error [Line:" + a.line +"]: "+ ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
					}
				}
			}else {
				if(local_variableMap.containsKey(a.varName)) {
					if(!local_variableMap.get(a.varName).getType().equals("INT")) {
						semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
					}
				}
			}

		}else if(type.equals("DOUBLE")) {
			if(allowed) {

				double d = getMATHDOUBLE(expr.math);

				if(local_variableMap.containsKey(a.varName)) {
					if(local_variableMap.get(a.varName).getType().equals("DOUBLE")) {
						local_variableMap.put(a.varName, new ValueDouble(d));
					}else {
						semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
					}
				}
			}else {
				if(local_variableMap.containsKey(a.varName)) {
					if(!local_variableMap.get(a.varName).getType().equals("DOUBLE")) {
						semanticErrors.add("Error [Line:" + a.line +"]: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
					}
				}
			}
		}else if(type.equals("NOT SAME"))  {
			semanticErrors.add("Error  [Line:" + a.line +"]: the LHS datatype and RHS datatype of " + expr.toString() + " must be the same");
		}		


	}	

	private double getMATHDOUBLE(Mathematics m) {
		double result = 0.00;
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getMATHDOUBLE(a.math1);
			double right = getMATHDOUBLE(a.math2);
			if(right == 0) {
				semanticErrors.add("Error [Line:" + a.line +"]: undefined. Cannot divide by 0");
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMATHDOUBLE(a.math);
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(local_variableMap.containsKey(a.varName) && local_variableMap.get(a.varName) instanceof ValueDouble) {
				result = ((ValueDouble)local_variableMap.get(a.varName)).getNum();
			}
		}

		return result;		
	}
	
	private double getMATHDOUBLE2(Mathematics m, Map<String, Values> local) {
		double result = 0.00;
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			double left = getMATHDOUBLE2(a.math1, local);
			double right = getMATHDOUBLE2(a.math2, local);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			double left = getMATHDOUBLE2(a.math1, local);
			double right = getMATHDOUBLE2(a.math2, local);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			double left = getMATHDOUBLE2(a.math1, local);
			double right = getMATHDOUBLE2(a.math2, local);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getMATHDOUBLE2(a.math1, local);
			double right = getMATHDOUBLE2(a.math2, local);
			if(right == 0) {
				semanticErrors.add("Error [Line:" + a.line +"]: undefined. Cannot divide by 0");
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMATHDOUBLE2(a.math, local);
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(local.containsKey(a.varName) && local.get(a.varName) instanceof ValueDouble) {
				result = ((ValueDouble)local.get(a.varName)).getNum();
			}
		}

		return result;		
	}

	private int getMathINT(Mathematics m) {
		int result = 0;

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getMathINT(a.math1);
			int right = getMathINT(a.math2);
			if(right == 0) {
				semanticErrors.add("Error [Line:" + a.line +"]: undefined. Cannot divide by 0");
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMathINT(a.math);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(local_variableMap.containsKey(a.varName) && local_variableMap.get(a.varName) instanceof ValueNum) {
				result = ((ValueNum)local_variableMap.get(a.varName)).getNum();
			}
		}

		return result;
	}
	
	private int getMathINT2(Mathematics m, Map<String, Values> local) {
		int result = 0;

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			int left = getMathINT2(a.math1, local);
			int right = getMathINT2(a.math2, local);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			int left = getMathINT2(a.math1, local);
			int right = getMathINT2(a.math2, local);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			int left = getMathINT2(a.math1, local);
			int right = getMathINT2(a.math2, local);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getMathINT2(a.math1, local);
			int right = getMathINT2(a.math2, local);
			if(right == 0) {
				semanticErrors.add("Error [Line:" + a.line +"]: undefined. Cannot divide by 0");
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMathINT2(a.math, local);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(local.containsKey(a.varName) && local.get(a.varName) instanceof ValueNum) {
				result = ((ValueNum)local.get(a.varName)).getNum();
			}
		}

		return result;
	}

	private String getCondType(Condition c) {
		String result = "";

		if(c instanceof Negation) {
			Negation e = (Negation) c;
			result = getCondType(e.cond);
		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			result = getCondType(e.cond);
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			String left = getCondType(e.cond1);
			String right = getCondType(e.cond2);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			String left = getCondType(e.cond1);
			String right = getCondType(e.cond2);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			String left = getCondType(e.cond1);
			String right = getCondType(e.cond2);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}		
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			String left = getCondType(e.left);
			String right = getCondType(e.right);
			if(left.equals(right)) {
				result = left;
			}else {
				result = "NO";
			}
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
			result = "BOOLEAN";
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error [Line:" + e.line +"]: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error [Line:" + e.line +"]: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error [Line:" + e.line +"]: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			if(getMATHTYPE(e.left).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.left.toString() + " is not the same");
			}else if(getMATHTYPE(e.right).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.right.toString() + " is not the same");
			}else if(!getMATHTYPE(e.left).equals(getMATHTYPE(e.right))){
				semanticErrors.add("Error [Line:" + e.line +"]: " + e.left + " must have the same datatype as " + e.right);
			}
			result = "BOOLEAN";
		}else if(c instanceof More) {
			More e = (More) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error [Line:" + e.line +"]: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof Less) {
			Less e = (Less) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error [Line:" + e.line +"]: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error [Line:" + e.line +"]: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			if(!local_variableMap.containsKey(e.varName)) {
				semanticErrors.add("Error [Line:" + e.line +"]: variable " + e.varName + " does not exist");
			}else {
				Values val = local_variableMap.get(e.varName);

				if(val.getType().equals("BOOLEAN")) {
					result = val.getType();
				}else {
					semanticErrors.add("Error [Line:" + e.line +"]: " + e.varName + " must be BOOLEAN type");
				}
			}

		}

		return result;
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
				result = "NOT SAME";
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
			if(!local_variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error [Line:" + a.line +"]: variable " + a.varName + " is not declared");
			}else if(local_variableMap.containsKey(a.varName)) {
				result = local_variableMap.get(a.varName).getType();
			}
		}

		return result;
	}
	
	private String getMATHTYPE2(Mathematics m, Map<String, Values> local) {
		String result = "";

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			String left = getMATHTYPE2(a.math1, local);
			String right = getMATHTYPE2(a.math2, local);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			String left = getMATHTYPE2(a.math1, local);
			String right = getMATHTYPE2(a.math2, local);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			String left = getMATHTYPE2(a.math1, local);
			String right = getMATHTYPE2(a.math2, local);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof Division) {
			Division a = (Division) m;
			String left = getMATHTYPE2(a.math1, local);
			String right = getMATHTYPE2(a.math2, local);
			if(left.equals(right)) {
				result = left;
			}else if(!left.equals(right) || left.equals("NOT SAME") || right.equals("NOT SAME")) {
				result = "NOT SAME";
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getMATHTYPE2(a.math, local);
		}else if(m instanceof MathNumber) {
			result = "INT";
		}else if(m instanceof MathDouble) {
			result = "DOUBLE";
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(!local.containsKey(a.varName)) {
				semanticErrors.add("Error [Line:" + a.line +"]: variable " + a.varName + " is not declared");
			}else if(local.containsKey(a.varName)) {
				result = local.get(a.varName).getType();
			}
		}

		return result;
	}

	public boolean evaluated(Condition c, Map<String, Values> map) {
		boolean result = false;

		if(c instanceof Negation) {
			Negation e = (Negation) c;
			result = !(evaluated(e.cond, map));

		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			result = evaluated(e.cond, map);
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			boolean left = evaluated(e.cond1, map);
			boolean right = evaluated(e.cond2, map);
			result = left && right;
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			boolean left = evaluated(e.cond1, map);
			boolean right = evaluated(e.cond2, map);
			result = left || right;
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			boolean left = evaluated(e.cond1, map);
			boolean right = evaluated(e.cond2, map);
			result = left == right;
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			boolean left = evaluated(e.left, map);
			boolean right = evaluated(e.right, map);
			result = left != right;
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
			result = e.bool;
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left == right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left == right;
			}
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left != right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left != right;
			}
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left >= right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left >= right;
			}
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			if(getMATHTYPE(e.left).equals("INT")) {
				int left = getMathINT(e.left);
				int right = getMathINT(e.right);
				result = left <= right;
			}else if(getMATHTYPE(e.left).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.left);
				double right = getMATHDOUBLE(e.right);
				result = left <= right;
			}
		}else if(c instanceof More) {
			More e = (More) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left > right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left > right;
			}
		}else if(c instanceof Less) {
			Less e = (Less) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getMathINT(e.math1);
				int right = getMathINT(e.math2);
				result = left < right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getMATHDOUBLE(e.math1);
				double right = getMATHDOUBLE(e.math2);
				result = left < right;
			}
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			if(map.containsKey(e.varName)) {
				Values val = map.get(e.varName);
				if(val.getType().equals("BOOLEAN")) {
					result = ((ValueBool)val.getValues()).value;
				}
			}
		}
		
		if (condCov != null && !(c instanceof Conjunction) && !(c instanceof Disjunction) && !(c instanceof CondParenthesis)) {

			condCov.appendResultString(result ? "1" : "0"); //condition coverage
		}

		return result;
	}

	public MyMethods visit2(MyMethodsContext ctx) {
		local_variableMap = new HashMap<>();

		Token token = ctx.METHODNAME().getSymbol();
		int line = token.getLine();
		String methodName = ctx.METHODNAME().getText();

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			MethodType methodType = (MyReturnMethod)mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyReturnMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			checkMethodBody(methodName, ((MyReturnMethod)methodType).method_body, parameter, true);

			if(this.local_variableMap.containsKey(((MyReturnMethod)methodType).varName)) {
				if(!this.local_variableMap.get(((MyReturnMethod)methodType).varName).getType().equals(((MyReturnMethod)methodType).dataType)) {
					semanticErrors.add("Error [Line "+ ((MyReturnMethod)methodType).jackieReturnLine +"] : incompatible jackieReturns type");
				}
			}else {
				semanticErrors.add("Error [Line "+ ((MyReturnMethod)methodType).jackieReturnLine +"] : variable " + ((MyReturnMethod)methodType).varName + " is not declared");
			}
			return new MyMethods(methodName, (MyReturnMethod)methodType, line);

		} else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			MethodType methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			checkMethodBody(methodName, ((MyReturnMethod)methodType).method_body, parameter, true);

			return new MyMethods(methodName, (MyVoidMethod)methodType, line);
		}
	}
	
	private double getDouble(MyMethodBody method_body, Mathematics m, Parameter parameter) {
		double result = 0.00;
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			double left = getDouble(method_body, a.math1, parameter);
			double right = getDouble(method_body, a.math2, parameter);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			double left = getDouble(method_body, a.math1, parameter);
			double right = getDouble(method_body, a.math2, parameter);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			double left = getDouble(method_body, a.math1, parameter);
			double right = getDouble(method_body, a.math2, parameter);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getDouble(method_body, a.math1, parameter);
			double right = getDouble(method_body, a.math2, parameter);
			if(right == 0) {
				semanticErrors.add("Error [Line "+ a.line +" ] : undefined. Cannot divide by 0");
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getDouble(method_body, a.math, parameter);
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(parameter.getParams().containsKey(a.varName) && parameter.getParams().get(a.varName).equals("DOUBLE")) {
				result = ((ValueDouble)(method_body.vars.get(a.varName))).value;
			}else if(method_body.vars.containsKey(a.varName) && method_body.vars.get(a.varName).getType().equals("DOUBLE")) {
				result = ((ValueDouble)(method_body.vars.get(a.varName))).value;
			}
		}

		return result;
	}

	public int getInt(MyMethodBody method_body, Mathematics m, Parameter parameter) {
		int result = 0;

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			int left = getInt(method_body, a.math1, parameter);
			int right = getInt(method_body, a.math2, parameter);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			int left = getInt(method_body, a.math1, parameter);
			int right = getInt(method_body, a.math2, parameter);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			int left = getInt(method_body, a.math1, parameter);
			int right = getInt(method_body, a.math2, parameter);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getInt(method_body, a.math1, parameter);
			int right = getInt(method_body, a.math2, parameter);
			if(right == 0) {
				semanticErrors.add("Error [Line "+ a.line +" ] : undefined. Cannot divide by 0");
			}else {
				result = left / right;
			}
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getInt(method_body, a.math, parameter);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(parameter.getParams().containsKey(a.varName) && parameter.getParams().get(a.varName).equals("INT")) {
				result = ((ValueNum)(method_body.vars.get(a.varName))).num;
			}else if(method_body.vars.containsKey(a.varName) && method_body.vars.get(a.varName).getType().equals("INT")) {
				result = ((ValueNum)(method_body.vars.get(a.varName))).num;
			}
		}

		return result;
	}

}
