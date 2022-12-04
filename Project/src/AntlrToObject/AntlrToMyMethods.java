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
	public AntlrToMyMethods(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, MethodCall t_method_call, Map<String, Values> inputValues, Values testValue) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.testValue = testValue;
	}

	// Condition Coverage
	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod, ConditionCoverage condCov) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.global_mymethods = mymethod;
		this.condCov = condCov;
		if (!condCov.isComponentState()) {
			this.t_method_call = condCov.getTestMethod().getKey();
			this.inputValues = condCov.getTestMethod().getValue();
		}
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

			getDefCoverage(methodName,((MyReturnMethod)methodType).method_body);

			((MyReturnMethod)methodType).putReturnValue(local_variableMap.get(((MyReturnMethod)methodType).varName));

			if(t_method_call instanceof ReturnMethodCall) {
				if(t_method_call.getName().equals(methodName)){
					this.testValue = local_variableMap.get(((MyReturnMethod)methodType).varName);
				}
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

				checkElseBody(methodName,elseBody, methodbody, parameter, needCheck);

			}else {
				checkElseBody(methodName,ifBody, methodbody, parameter, needCheck);

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
					if(smtg(methodName,a.expr, a, needCheck)) {

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
			for(MyMethodBody loopbody : l.myMethodBodyList) {
				if(i == 0) {
					checkDeclaration(loopbody, parameter);
				}

				checkAssignment(loopbody, parameter);

				if(loopbody.ifStatList.size() > 0) {
					checkIfStatement(methodName,loopbody, parameter, needCheck);
				}

				if(loopbody.loops.size() > 0) {
					checkLoop(methodName,loopbody, parameter, needCheck);
				}

				if(loopbody.methodCall.size() > 0) {
					checkVoidCall(loopbody);
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
			local_variableMap.put(d.varName, d.defaultValue);
		}

		for(Assignment a: method_body.assiList) {
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					checkMath((ValueMath)a.expr, a, true);
				}else {
					local_variableMap.put(a.varName, ((Values)a.expr).getValues());	
				}

			}else if(a.expr instanceof ReturnMethodCall) {
				if(smtg(methodName,a.expr, a, true)) {
					this.local_variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
				}

			}
		}

		defCheckIf(methodName,method_body, true);
		defCheckLoop(methodName,method_body, true);
		defCheckVoid(method_body);

	}

	private void defCheckIf(String methodName, MyMethodBody method_body, boolean needCheck) {
		for(IfStatement ifs: method_body.ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;


			List<String> list = new ArrayList<>();
			list = getCondVariableList(ifs.cond, list);

			ifs.setCond(evaluated(ifs.cond, local_variableMap));
			if(evaluated(ifs.cond, local_variableMap)) {
				getForIfBody(methodName, ifBody, needCheck);
			}else {
				getForIfBody(methodName, elseBody, needCheck);
			}

		}

	}

	private void getForIfBody(String methodName, MyMethodBody method_body, boolean needCheck) {
		for(Declaration d: method_body.declList) {
			if(!local_variableMap.containsKey(d.varName)) {
				local_variableMap.put(d.varName, d.defaultValue);
			}
		}

		for(Assignment a: method_body.assiList) {
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

		if(method_body.ifStatList.size() > 0) {
			defCheckIf(methodName,method_body, needCheck);
		}

		if(method_body.loops.size() > 0) {
			defCheckLoop(methodName,method_body, needCheck);
		}

		if(method_body.methodCall.size() > 0) {
			defCheckVoid(method_body);
		}
	}

	private void defCheckLoop(String methodName, MyMethodBody method_body, boolean needCheck) {
		for(Loop lo : method_body.loops) {
			for(MyMethodBody loopbody : lo.myMethodBodyList) {
				evaluateLoop(methodName, loopbody, needCheck);
			}
		}
	}

	private void defCheckVoid(MyMethodBody method_body) {
		for(MethodCall v: method_body.methodCall) {
			List<String> params = ((VoidMethodCall)v).call_parameter.getCallParams();
			String parameter = ""; int i = 0;
			for(String s: params) {
				parameter+= s;
				if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
					parameter += ", ";
				}
				i++;
			}
		}
	}

	private void evaluateLoop(String methodName, MyMethodBody loopbody, boolean needCheck) {
		for(Declaration d: loopbody.declList) {
			if(!local_variableMap.containsKey(d.varName)) {
				local_variableMap.put(d.varName, d.defaultValue);
			}
		}

		for(Assignment a: loopbody.assiList) {

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
			defCheckVoid(loopbody);
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
					semanticErrors.add("Error [Line:" + line +"]: " + ((ReturnMethodCall)this.t_method_call).toString() + " must have the same number of parameters as mymethod " + methodName);
				}else {
					int i = 0;
					for(Map.Entry<String, String> map: methodparams.entrySet()){
						int j = 0;
						for(Map.Entry<String, Values> input: inputValues.entrySet()) {
							if(i == j) {
								if(map.getValue().equals(input.getValue().getType())) {
									this.local_variableMap.put(map.getKey(), input.getValue());
								}else {
									semanticErrors.add("Error [Line:" + line +"]: " + map.getValue() + " from mymethod does not have the same datatype");
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
				Map<String, String> methodparams = ((MyReturnMethod)methodtype).parameter.getParams();
				if(RHSparams.size() != methodparams.size()) {
					semanticErrors.add("Error  [Line:" + line +"]: "  + ((VoidMethodCall)this.t_method_call).toString() + " must have the same number of parameters as mymethod " + methodName);
				}else {
					int i = 0;
					for(Map.Entry<String, String> map: methodparams.entrySet()){

						this.local_variableMap.put(""+i, this.inputValues.get(RHSparams.get(i)));

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
							lists.put("" + num, this.local_variableMap.get(a.varName));
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
					return ((MyReturnMethod)m.methodType).getValue(lists);
					//					}
				}
			}

		}

		return this.local_variableMap.get(varName);

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
							semanticErrors.add("Error [Line:" + m.line +"]: " + ((ReturnMethodCall)rhs).toString() + " must have the same number of parameters as mymethod " + m.methodName);
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
				if(!semanticErrors.contains("Error [Line:" + a.line +"]: undefined. Cannot divide by 0")) {
					semanticErrors.add("Error [Line:" + a.line +"]: undefined. Cannot divide by 0");
				}
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
			checkDeclAssi2(methodName, ((MyReturnMethod)methodType).method_body, parameter); // check decl and assi

			return new MyMethods(methodName, (MyReturnMethod)methodType, line);

		} else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			MethodType methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			checkDeclAssi2(methodName,((MyVoidMethod)methodType).method_body, parameter); // check decl and assi

			return new MyMethods(methodName, (MyVoidMethod)methodType, line);
		}
	}
}
