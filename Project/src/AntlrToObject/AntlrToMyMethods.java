package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import antlr.exprBaseVisitor;
import antlr.exprParser.DeclarationContext;
import antlr.exprParser.MyMethodsContext;
import antlr.exprParser.MyReturnMethodContext;
import antlr.exprParser.MyVoidMethodContext;
import model.Addition;
import model.Assignment;
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
import model.Less;
import model.LessOrEqual;
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
	public List<MyMethods> mymethod; 
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public List<String> methodCallParamOrder;
	private HashMap<String, Values> local_variableMap = new HashMap<>();
	public AntlrToMyMethods(ArrayList<String>[] t, ArrayList<Integer> o ) {
		this.orderOfFlow = o;
		this.tokensMappedToLines = t;
	}

	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod) {
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.mymethod = mymethod;
	}

	public AntlrToMyMethods(List<String> semanticError, HashMap<String, Values> variableMap, List<MyMethods> mymethod, MethodCall t_method_call, Map<String, Values> inputValues, List<String> methodCallParamOrder) {
		// TODO Auto-generated constructor stub
		this.methodCallParamOrder = methodCallParamOrder;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.semanticErrors = semanticError;
		this.variableMap = variableMap;
		this.mymethod = mymethod;
	}

	@Override
	public MyMethods visitMyMethods(MyMethodsContext ctx) {
		String methodName = ctx.METHODNAME().getText();
		AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.mymethod);

		//no global var yet
		//		if(variableMap != null) {
		//			this.local_methodvar.putAll(variableMap);
		//		}

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			MethodType methodType = (MyReturnMethod)mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyReturnMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			if(t_method_call instanceof ReturnMethodCall) {
				checkTestMethodCallParameter(parameter, methodType, methodName);
			}
			checkDeclAssi(((MyReturnMethod)methodType).method_body, parameter); // check decl and assi
			checkParameterForErrors(((MyReturnMethod)methodType).method_body, parameter);
			checkVoidCall();
			checkReturnVar(((MyReturnMethod)methodType));

			return new MyMethods(methodName, (MyReturnMethod)methodType);
		}
		MethodType methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
		Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();

		if(t_method_call instanceof VoidMethodCall) {
			checkTestMethodCallParameter(parameter, methodType, methodName);
		}
		checkDeclAssi(((MyVoidMethod)methodType).method_body, parameter); // check decl and assi
		checkParameterForErrors(((MyVoidMethod)methodType).method_body, parameter);
		checkVoidCall();



		return new MyMethods(methodName, (MyVoidMethod)methodType);
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

	private void checkTestMethodCallParameter(Map<String, String> parameter, MethodType methodtype, String methodName) {
		if(methodtype instanceof MyReturnMethod) {
			String rhsMethodName = this.t_method_call.getName(); 
			if(methodName.equals(rhsMethodName)) {

				List<String> RHSparams = ((ReturnMethodCall)this.t_method_call).call_parameter.getCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)methodtype).parameter.getParams();
				if(RHSparams.size() != methodparams.size()) {
					semanticErrors.add("Error: " + ((ReturnMethodCall)this.t_method_call).toString() + " must have the same number of parameters as mymethod " + methodName);
				}else {
					int i = 0;
					for(Map.Entry<String, String> map: methodparams.entrySet()){
						if(!(this.local_variableMap.get(RHSparams.get(i)).getType().equals(map.getValue()))){
							semanticErrors.add("Error: dataType of " + RHSparams.get(i) + " in " +  ((ReturnMethodCall)this.t_method_call).toString() + " is not the same as dataType of " + map.getKey() + " in mymethod" + methodName);
						}
						i++;
					}
				}
			}
	
		}else if(methodtype instanceof MyVoidMethod) {
			String rhsMethodName = this.t_method_call.getName(); 
			if(methodName.equals(rhsMethodName)) {

				List<String> RHSparams = ((VoidMethodCall)this.t_method_call).call_parameter.getCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)methodtype).parameter.getParams();
				if(RHSparams.size() != methodparams.size()) {
					semanticErrors.add("Error: " + ((VoidMethodCall)this.t_method_call).toString() + " must have the same number of parameters as mymethod " + methodName);
				}else {
					int i = 0;
					for(Map.Entry<String, String> map: methodparams.entrySet()){
						if(!(this.local_variableMap.get(RHSparams.get(i)).getType().equals(map.getValue()))){
							semanticErrors.add("Error: dataType of " + RHSparams.get(i) + " in " +  ((VoidMethodCall)this.t_method_call).toString() + " is not the same as dataType of " + map.getKey() + " in mymethod" + methodName);
						}else {
							this.local_variableMap.put(map.getKey(), this.inputValues.get(RHSparams.get(i)));
						}
						i++;
					}
				}
			}
		}
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

	private void checkReturnVar(MyReturnMethod method) {
		if(!local_variableMap.containsKey(method.varName)) {
			semanticErrors.add("Error: return variable " + method.varName + " is not declared");
		}

	}

	private void checkVoidCall() {
		// TODO Auto-generated method stub

	}

	private void checkDeclAssi(MyMethodBody method_body, Map<String, String> parameter) {

		for(Declaration d : method_body.declList) {
			if(parameter.containsKey(d.varName)) {
				semanticErrors.add("Error: variable " + d.varName + " already exist in the parameters");
			}else {
				if(local_variableMap.containsKey(d.varName)) {
					semanticErrors.add("Error: variable " + d.varName + " already declared");
				}else {
					local_variableMap.put(d.varName, d.defaultValue);	
				}
			}
		}

		for(Assignment a: method_body.assiList) {
			if(!local_variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error: variable " + a.varName + " is not declared yet");
			}else {
				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						checkMath((ValueMath)a.expr, a);
					}else {
						if(local_variableMap.containsKey(a.varName)) {
							if(local_variableMap.get(a.varName).getType().equals(((Values)a.expr).getValues().getType())) {
								local_variableMap.put(a.varName, ((Values)a.expr).getValues());	
							}else {
								semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
							}
						}
					}
				}else if(a.expr instanceof ReturnMethodCall) {
					if(smtg(a.expr, a)) {
						variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
					}
				}else {
					this.semanticErrors.add("Error: variable " + a.varName + " return type does not match expression return type.");
				}
			}
		}
	}

	private boolean smtg(Expr rhs, Assignment a) {
		String type = "";
		for(Map.Entry<String, Values> d: local_variableMap.entrySet()) { //find dec type from declarations of game body
			if(d.getKey().equals(a.varName)) {
				type = d.getValue().getType();
			}
		}
		
		if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, this.mymethod)) { //if rhs methodcall is declared 
			String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
			for(MyMethods m: this.mymethod) { //grab method from DeclaredMethodsList, find matching method, check for return data type against type
				if(m.methodName.equals(rhsMethodName)) {

					List<String> RHSparams = ((ReturnMethodCall)rhs).call_parameter.getCallParams();
					Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
					if(RHSparams.size() != methodparams.size()) {
						semanticErrors.add("Error: " + ((ReturnMethodCall)rhs).toString() + " must have the same number of parameters as mymethod " + m.methodName);
					}else {
						int i = 0;
						for(Map.Entry<String, String> map: methodparams.entrySet()){
							if(!(this.local_variableMap.get(RHSparams.get(i)).getType().equals(map.getValue()))){
								semanticErrors.add("Error: dataType of " + RHSparams.get(i) + " in " +  ((ReturnMethodCall)rhs).toString() + " is not the same as dataType of " + map.getKey() + " in mymethod" + m.methodName);
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
		}
		else { //if method not declared
			this.semanticErrors.add("Return Method Call on RHS is not declared: " + a.varName + " cannot be assigned to: " + rhs.toString());
			return false;
		}
	}


	private void checkMath(ValueMath expr, Assignment a) {
		Map<String, Values> list = new HashMap<>();
		list = getVariableList(expr.math, list);
		String type = "";

		if(list.size() >0) {
			for(Values v: list.values()) {
				type = v.getType();
				break;
			}
			boolean correctType = true;
			for(Values v : list.values()) {
				if(!v.getType().equals(type)) {
					correctType = false;
				}
			}
			if(correctType) {
				if(type.equals("INT")) {
					int i = getMathINT(expr.math);

					if(local_variableMap.containsKey(a.varName)) {
						if(local_variableMap.get(a.varName).getType().equals("INT")) {
							local_variableMap.put(a.varName, new ValueNum(i));	
						}else {
							semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
						}
					}

				}else if(type.equals("DOUBLE")) {
					double d = getMATHDOUBLE(expr.math);

					if(local_variableMap.containsKey(a.varName)) {
						if(local_variableMap.get(a.varName).getType().equals("DOUBLE")) {
							local_variableMap.put(a.varName, new ValueDouble(d));
						}else {
							semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
						}
					}
				}

			}else {
				semanticErrors.add("Error: the LHS datatype and RHS datatype of " + expr.toString() + " must be the same");
			}		
		}

	}



	private void checkParameterForErrors(MyMethodBody methodbody , Map<String, String> parameter) {
		for(IfStatement i : methodbody.ifStatList) {
			if(getCondType(i.cond).equals("NO")) {
				if(!semanticErrors.contains("Error: condition " + i.cond.toString() + " error. LHS and RHS must match")){
					semanticErrors.add("Error: condition " + i.cond.toString() + " error. LHS and RHS must match");
				}
			}

			MyMethodBody ifmethod = i.getIfBody();
			for(Declaration d : ifmethod.declList) {
				if(parameter.containsKey(d.varName)) {
					if(!semanticErrors.contains("Error: " + d.varName + " is a parameter of mymethod")) {
						semanticErrors.add("Error: " + d.varName + " is a parameter of mymethod");	
					}
				}
			}
			for(Declaration d : ifmethod.declList) {
				for(Declaration dl: methodbody.declList) {
					if(d.varName.equals(dl.varName)) {
						semanticErrors.add("Error: " + d.varName + " already been declared in mymethod");
					}else {
						local_variableMap.put(d.varName, d.defaultValue);	
					}
				}
			}

			for(Assignment a: ifmethod.assiList) {
				if(!local_variableMap.containsKey(a.varName)) {
					semanticErrors.add("Error: variable " + a.varName + " is not declared yet");
				}else {
					if(a.expr instanceof Values) {
						if(((Values)a.expr) instanceof ValueMath) {
							checkMath((ValueMath)a.expr, a);
						}else {
							if(local_variableMap.containsKey(a.varName)) {
								if(local_variableMap.get(a.varName).getType().equals(((Values)a.expr).getValues().getType())) {
									local_variableMap.put(a.varName, ((Values)a.expr).getValues());	
								}else {
									semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
								}
							}
						}
					}else if(a.expr instanceof ReturnMethodCall) {
						/*
						 * 
						 * Deal with return method call for methodbody
						 * and if the method exist
						 */
					}else {
						this.semanticErrors.add("Error: variable " + a.varName + " return type does not match expression return type.");
					}
				}
			}

			MyMethodBody elsemethod = i.getElseBody();
			for(Declaration d : elsemethod.declList) {
				for(Declaration dl: methodbody.declList) {
					if(d.varName.equals(dl.varName)) {
						semanticErrors.add("Error: " + d.varName + " already been declared in mymethod");
					}
				}
			}

		}

	}

	public MyMethods control(MyMethodsContext ctx) {
		String methodName = ctx.METHODNAME().getText();
		if(methodName.equals(this.t_method_call.getName())) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(this.t_method_call, this.inputValues, this.methodCallParamOrder);
			
			if(ctx.getChild(2) instanceof MyReturnMethodContext) {
				MyReturnMethod methodType = (MyReturnMethod) mtVisitor.controlR((MyReturnMethodContext) ctx.getChild(2));
				return new MyMethods(methodName, methodType);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.controlV((MyVoidMethodContext)ctx.getChild(2));
			return new MyMethods(methodName, methodType);
		}
		else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.mymethod);

			if(ctx.getChild(2) instanceof MyReturnMethodContext) {
				MyReturnMethod methodType = (MyReturnMethod) mtVisitor.visit(ctx.getChild(2));
				return new MyMethods(methodName, methodType);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			return new MyMethods(methodName, methodType);


		}
	}

	private Map<String, Values> getVariableList(Mathematics m, Map<String, Values> list) {

		if(m instanceof MathParenthesis) {
			MathParenthesis e = (MathParenthesis) m;
			list = getVariableList(e.math, list);
		}else if(m instanceof Addition) {
			Addition e = (Addition) m;
			list = getVariableList(e.math1, list);
			list = getVariableList(e.math2, list);
		}else if(m instanceof Subtraction) {
			Subtraction e = (Subtraction) m;
			list = getVariableList(e.math1, list);
			list = getVariableList(e.math2, list);
		}else if(m instanceof Multiplication) {
			Multiplication e = (Multiplication) m;
			list = getVariableList(e.math1, list);
			list = getVariableList(e.math2, list);
		}else if(m instanceof Division) {
			Division e = (Division) m;
			list = getVariableList(e.math1, list);
			list = getVariableList(e.math2, list);
		}else if(m instanceof MathNumber) {
			MathNumber e = (MathNumber) m;
		}else if(m instanceof MathDouble) {
			MathDouble e = (MathDouble) m;
		}else if(m instanceof MathVarName) {
			MathVarName e = (MathVarName) m;
			if(!local_variableMap.containsKey(e.varName)) {
				semanticErrors.add("Error: variable " + e.varName + " is not declared");
			}else if(local_variableMap.containsKey(e.varName)) {
				list.put(e.varName, local_variableMap.get(e.varName));
			}
		}

		return list;
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
			result = left / right;
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
			result = left / right;
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
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			if(getMATHTYPE(e.left).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.left.toString() + " is not the same");
			}else if(getMATHTYPE(e.right).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.right.toString() + " is not the same");
			}else if(!getMATHTYPE(e.left).equals(getMATHTYPE(e.right))){
				semanticErrors.add("Error: " + e.left + " must have the same datatype as " + e.right);
			}
			result = "BOOLEAN";
		}else if(c instanceof More) {
			More e = (More) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof Less) {
			Less e = (Less) c;
			if(getMATHTYPE(e.math1).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math1.toString() + " is not the same");
			}else if(getMATHTYPE(e.math2).equals("NOT SAME")) {
				semanticErrors.add("Error: the LHS and RHS of " + e.math2.toString() + " is not the same");
			}else if(!getMATHTYPE(e.math1).equals(getMATHTYPE(e.math2))){
				semanticErrors.add("Error: " + e.math1 + " must have the same datatype as " + e.math2);
			}
			result = "BOOLEAN";
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			Values val = local_variableMap.get(e.varName);

			if(val.getType().equals("BOOLEAN")) {
				result = val.getType();
			}else {
				semanticErrors.add("Error: " + e.varName + " must be BOOLEAN type");
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
