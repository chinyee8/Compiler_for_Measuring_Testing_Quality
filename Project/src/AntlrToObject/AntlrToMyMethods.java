package AntlrToObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.LabelUI;

import Operations.ConditionCoverage;
import antlr.exprBaseVisitor;
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
	public List<MyMethods> global_mymethods; 
	public MethodCall t_method_call;
	public Map<String, Values> inputValues;
	public List<String> methodCallParamOrder;
	private HashMap<String, Values> local_variableMap;
	//def Coverage
	public Map<String, Boolean> def;
	public Map<Map<Integer, Map<String, Boolean>>, List<Integer>>  def_use;
	public Map<Integer, Map<String, Boolean>> linesDef;
	public List<Integer> linesUse;
	public List<String> lines;
	public int totalNotUsed;
	
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
	public AntlrToMyMethods(List<String> semanticErrors, HashMap<String, Values> variableMap, List<MyMethods> global_mymethods, MethodCall t_method_call, Map<String, Values> inputValues,Map<String, Boolean> def, Map<Map<Integer, Map<String, Boolean>>, List<Integer>>  def_use,Map<Integer, Map<String, Boolean>> linesDef, List<Integer> linesUse, List<String> lines, int totalNotUsed) {
		this.semanticErrors = semanticErrors;
		this.variableMap = variableMap;
		this.global_mymethods = global_mymethods;
		this.t_method_call = t_method_call;
		this.inputValues = inputValues;
		this.def = def;
		this.def_use = def_use;
		this.linesDef = linesDef;
		this.linesUse = linesUse;
		this.lines = lines;
		this.totalNotUsed = totalNotUsed;
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

		String methodName = ctx.METHODNAME().getText();
		for(MyMethods m : global_mymethods) {
			if(m.methodName.equals(methodName)) {
				semanticErrors.add("Error: mymethods " + methodName + " already exist");
			}
		}

		//no global var yet
		//		if(variableMap != null) {
		//			this.local_methodvar.putAll(variableMap);
		//		}

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			MethodType methodType = (MyReturnMethod)mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyReturnMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			checkDeclAssi(((MyReturnMethod)methodType).method_body, parameter); // check decl and assi
			checkParameterForErrors(((MyReturnMethod)methodType).method_body, parameter);
			checkVoidCall(((MyReturnMethod)methodType).method_body);
			checkReturnVar(((MyReturnMethod)methodType));
			return new MyMethods(methodName, (MyReturnMethod)methodType);

		} else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			MethodType methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();

			declareParameter(parameter);
			checkDeclAssi(((MyVoidMethod)methodType).method_body, parameter); // check decl and assi
			checkParameterForErrors(((MyVoidMethod)methodType).method_body, parameter);
			checkVoidCall(((MyVoidMethod)methodType).method_body);

			return new MyMethods(methodName, (MyVoidMethod)methodType);
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
				return new MyMethods(methodName, methodType);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.controlV((MyVoidMethodContext)ctx.getChild(2));
			return new MyMethods(methodName, methodType);
		}
		else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, this.variableMap, this.global_mymethods);

			if(ctx.getChild(2) instanceof MyReturnMethodContext) {
				MyReturnMethod methodType = (MyReturnMethod) mtVisitor.visit(ctx.getChild(2));
				return new MyMethods(methodName, methodType);
			}
			MyVoidMethod methodType = (MyVoidMethod) mtVisitor.visit(ctx.getChild(2));
			return new MyMethods(methodName, methodType);


		}
	}


	
	//defCoverage
	public MyMethods defControl(MyMethodsContext ctx) {
		local_variableMap = new HashMap<>();
		String methodName = ctx.METHODNAME().getText();

		//no global var yet
		//		if(variableMap != null) {
		//			this.local_methodvar.putAll(variableMap);
		//		}

		if(ctx.getChild(2) instanceof MyReturnMethodContext) {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues, def, def_use, linesDef, linesUse, lines, totalNotUsed);

			MethodType methodType = (MyReturnMethod)mtVisitor.defControlR((MyReturnMethodContext)ctx.getChild(2));
			Map <String, String> parameter = ((MyReturnMethod)methodType).parameter.getParams();

			String paramsList = ""; int i = 0;
			for(Map.Entry<String, String> p : parameter.entrySet()) {
				def.put(p.getKey(), false);

				paramsList += p.getValue() + " " + p.getKey();
				if(i < parameter.size()-1) {
					paramsList += ", ";
				}
				i++;
			}

			lines.add("<br>&emsp;mymethod " + methodName + " " + ((MyReturnMethod)methodType).dataType + " [ " + paramsList + " ] !");
			linesDef.put(lines.size()-1, def);
			def = new HashMap<>();

			declareParameter(parameter);
			if(t_method_call instanceof ReturnMethodCall) {
				checkTestMethodCallParameter(parameter, methodType, methodName);
			}

			getDefCoverage(((MyReturnMethod)methodType).method_body);
			
			lines.add("<br>&emsp;&emsp;jackieReturns " + ((MyReturnMethod)methodType).varName);
			boolean contains = false;
			for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
				for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
					if(((MyReturnMethod)methodType).varName.equals(d.getKey())) {
						d.setValue(true);
						contains = true;
					}
				}
			}
			if(contains) {
				linesUse.add(lines.size()-1);
			}
			
			List<Integer> keyToRemove = new ArrayList<>();
			for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
				boolean got = false;
				for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
					if(d.getValue() == true) {
						got = true;
					}else {
						totalNotUsed++;
					}
				}
				if(!got) {
					keyToRemove.add(ld.getKey());
				}
			}
			
			for(Integer key : keyToRemove) {
				linesDef.remove(key);
			}
			
			lines.add("&emsp;!");

			return new MyMethods(methodName, (MyReturnMethod)methodType);
		}else {
			AntlrToMethodType mtVisitor = new AntlrToMethodType(semanticErrors, variableMap, global_mymethods, t_method_call, inputValues, def, def_use, linesDef, linesUse, lines, totalNotUsed);

			MethodType methodType = (MyVoidMethod) mtVisitor.defControlV((MyVoidMethodContext)ctx.getChild(2));
			Map <String, String> parameter = ((MyVoidMethod)methodType).parameter.getParams();

			String paramsList = ""; int i = 0;
			for(Map.Entry<String, String> p : parameter.entrySet()) {
				def.put(p.getKey(), false);

				paramsList += p.getValue() + " " + p.getKey();
				if(i < parameter.size()-1) {
					paramsList += ", ";
				}
				i++;
			}

			lines.add("<br>&emsp;mymethod " + methodName + " " + ((MyVoidMethod)methodType).voidType + " [ " + paramsList + " ] !");
			linesDef.put(lines.size()-1, def);
			def = new HashMap<>();

			declareParameter(parameter);
			if(t_method_call instanceof VoidMethodCall) {
				checkTestMethodCallParameter(parameter, methodType, methodName);
			}

			getDefCoverage(((MyVoidMethod)methodType).method_body);			
			
			List<Integer> keyToRemove = new ArrayList<>();
			for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
				boolean got = false;
				for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
					if(d.getValue() == true) {
						got = true;
					}else {
						totalNotUsed++;
					}
				}
				if(!got) {
					keyToRemove.add(ld.getKey());
				}
			}
			
			for(Integer key : keyToRemove) {
				linesDef.remove(key);
			}
			
			lines.add("&emsp;!");


			return new MyMethods(methodName, (MyVoidMethod)methodType);
		}
	}

	private void getDefCoverage(MyMethodBody method_body) {
		for(Declaration d: method_body.declList) {
			def.put(d.varName, false);
			lines.add("&emsp;&emsp;"+ d.varName + " << " + d.dataType);
			linesDef.put(lines.size()-1, def);
			def = new HashMap<>();
		}

		for(Assignment a: method_body.assiList) {
			lines.add("&emsp;&emsp;"+a.varName + " <- " + a.expr);
			def.put(a.varName, false);
			linesDef.put(lines.size()-1, def);
			def = new HashMap<>();

			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					List<String> list  = new ArrayList<>();
					list = getVariables(((ValueMath)((Values)a.expr)).math, list);

					boolean contains = false;
					for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
						for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
							if(list.contains(d.getKey())) {
								d.setValue(true);
								contains = true;
							}
						}
					}
					if(contains) {
						linesUse.add(lines.size()-1);
					}
				}

			}else if(a.expr instanceof ReturnMethodCall) {
				List<String> params = ((ReturnMethodCall)a.expr).call_parameter.getCallParams();
				boolean contains = false;
				for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
					for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
						if(params.contains(d.getKey())) {
							d.setValue(true);
							contains = true;
						}
					}
				}
				if(contains) {
					linesUse.add(lines.size()-1);
				}
			}
		}

		defCheckIf(method_body);
		defCheckVoid(method_body);

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
			
			lines.add("<br>&emsp;&emsp;"+((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [ " + parameter + " ]");
			
			boolean contains = false;
			for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
				for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
					if(params.contains(d.getKey())) {
						d.setValue(true);
						contains = true;
					}
				}
			}
			if(contains) {
				linesUse.add(lines.size()-1);
			}	
		}
	}

	private void defCheckIf(MyMethodBody method_body) {
		for(IfStatement ifs: method_body.ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;

			lines.add("<br>&emsp;&emsp;jackieAsks [ " + ifs.cond.toString() + " ] !");

			List<String> list = new ArrayList<>();
			list = getCondVariableList(ifs.cond, list);
			boolean got = false;
			for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
				for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
					if(list.contains(d.getKey())) {
						d.setValue(true);
						got = true;
					}
				}
			}
			if(got) {
				linesUse.add(lines.size()-1);
			}

			if(evaluated(ifs.cond, local_variableMap)) {
				getForIfBody(ifBody);
				lines.add("<br>&emsp;&emsp;! elseJackie !");
				getForElseBody(elseBody);
				lines.add("<br>&emsp;&emsp;!");
			}else {
				getForElseBody(ifBody);
				lines.add("<br>&emsp;&emsp;! elseJackie !");
				getForIfBody(elseBody);
				lines.add("<br>&emsp;&emsp;!");
			}

		}

	}
	private void getForIfBody(MyMethodBody method_body) {
		for(Declaration d: method_body.declList) {
			def.put(d.varName, false);
			lines.add("&emsp;&emsp;&emsp;"+d.varName + " << " + d.dataType);
			linesDef.put(lines.size()-1, def);
			def = new HashMap<>();
		}

		for(Assignment a: method_body.assiList) {
			lines.add("&emsp;&emsp;&emsp;"+a.varName + " <- " + a.expr);
			def.put(a.varName, false);
			linesDef.put(lines.size()-1, def);
			def = new HashMap<>();

			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					List<String> list  = new ArrayList<>();
					list = getVariables(((ValueMath)((Values)a.expr)).math, list);

					boolean contains = false;
					for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
						for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
							if(list.contains(d.getKey())) {
								d.setValue(true);
								contains = true;
							}
						}
					}
					if(contains) {
						linesUse.add(lines.size()-1);
					}
				}

			}else if(a.expr instanceof ReturnMethodCall) {
				List<String> params = ((ReturnMethodCall)a.expr).call_parameter.getCallParams();
				boolean contains = false;
				for(Map.Entry<Integer, Map<String, Boolean>> ld: linesDef.entrySet()) {
					for(Map.Entry<String, Boolean> d: ld.getValue().entrySet()) {
						if(params.contains(d.getKey())) {
							d.setValue(true);
							contains = true;
						}
					}
				}
				if(contains) {
					linesUse.add(lines.size()-1);
				}
			}
		}

		if(method_body.ifStatList.size() > 0) {
			defCheckIf(method_body);
		}

		if(method_body.methodCall.size() > 0) {
			defCheckVoid(method_body);
		}
	}

	private void getVoidForElseBody(MyMethodBody method_body) {
		for(MethodCall v: method_body.methodCall) {
			String parameter = ""; int i = 0;
			for(String s: ((VoidMethodCall)v).call_parameter.getCallParams()) {
				parameter+= s;
				if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
					parameter += ", ";
				}
				i++;
			}
			
			lines.add(((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [ " + parameter + " ]");
		}
	}

	private void getForElseBody(MyMethodBody method_body) {
		for(Declaration d: method_body.declList) {
			lines.add("&emsp;&emsp;&emsp;"+d.varName + " << " + d.dataType);
		}

		for(Assignment a: method_body.assiList) {
			lines.add("&emsp;&emsp;&emsp;"+a.varName + " <- " + a.expr.toString());			
		}

		if(method_body.ifStatList.size() > 0) {
			defCheckElse(method_body);
		}

		if(method_body.methodCall.size() > 0) {
			getVoidForElseBody(method_body);
		}

	}
	
	private void defCheckElse(MyMethodBody method_body) {
		for(IfStatement ifs: method_body.ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;

			lines.add("<br>&emsp;&emsp;jackieAsks [ " + ifs.cond.toString() + " ] !");

			if(evaluated(ifs.cond, local_variableMap)) {
				getForElseBody(ifBody);
				lines.add("<br>&emsp;&emsp;! elseJackie !");
				getForElseBody(elseBody);
				lines.add("<br>&emsp;&emsp;!");
			}else {
				getForElseBody(ifBody);
				lines.add("<br>&emsp;&emsp;! elseJackie !");
				getForElseBody(elseBody);
				lines.add("<br>&emsp;&emsp;!");
			}

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
						int j = 0;
						for(Map.Entry<String, Values> input: inputValues.entrySet()) {
							if(i == j) {
								if(map.getValue().equals(input.getValue().getType())) {
									this.local_variableMap.put(map.getKey(), input.getValue());
								}else {
									semanticErrors.add("Error: " + map.getValue() + " from mymethod does not have the same datatype");
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
		for(MyMethods m : this.global_mymethods) {
			if(m.methodName.equals(r.methodName) && m.methodType instanceof MyReturnMethod) {
				boolean noerror = true;
				List<String> RHSparams = r.call_parameter.getCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
				if(RHSparams.size() == methodparams.size() && RHSparams.size() > 0) {
					boolean contains = true;
					Map<String, Values> lists = new LinkedHashMap<>();
					for(String s : RHSparams) {
						if(!this.local_variableMap.containsKey(s)) {
							contains = false;
						}else {
							lists.put(s, this.local_variableMap.get(s));
						}
					}

					if(contains) {
						int i = 0;
						for(Map.Entry<String, String> map: methodparams.entrySet()){
							if(!(this.local_variableMap.get(RHSparams.get(i)).getType().equals(map.getValue()))){
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

		return this.local_variableMap.get(varName);

	}

	private void checkReturnVar(MyReturnMethod method) {
		if(!local_variableMap.containsKey(method.varName)) {
			semanticErrors.add("Error: return variable " + method.varName + " is not declared");
		}else {
			if(!local_variableMap.get(method.varName).getType().equals(method.dataType)) {
				semanticErrors.add("Error: " + method.varName + " should return " + method.dataType + " not " + local_variableMap.get(method.varName).getType());
			}
		}

	}

	private void checkVoidCall(MyMethodBody method_body) {
		for( MethodCall m: method_body.methodCall) {
			if(m instanceof VoidMethodCall) {

			}else {
				semanticErrors.add("Error: Only void method call is allowed");
			}
		}
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
						checkMath((ValueMath)a.expr, a, true);
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
						this.local_variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
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

		if (checkIfMyMethodContainsReturnMethodCall((ReturnMethodCall)rhs, this.global_mymethods)) { //if rhs methodcall is declared 
			String rhsMethodName = ((ReturnMethodCall)rhs).methodName; 
			for(MyMethods m: this.global_mymethods) { //grab method from DeclaredMethodsList, find matching method, check for return data type against type
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

	private void checkMath(ValueMath expr, Assignment a, boolean allowed) {
		String type = getMATHTYPE(expr.math);

		if(type.equals("INT")) {
			if(allowed) {
				int i = getMathINT(expr.math);

				if(local_variableMap.containsKey(a.varName)) {
					if(local_variableMap.get(a.varName).getType().equals("INT")) {
						local_variableMap.put(a.varName, new ValueNum(i));	
					}else {
						semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
					}
				}
			}else {
				if(local_variableMap.containsKey(a.varName)) {
					if(!local_variableMap.get(a.varName).getType().equals("INT")) {
						semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
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
						semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
					}
				}
			}else {
				if(local_variableMap.containsKey(a.varName)) {
					if(!local_variableMap.get(a.varName).getType().equals("DOUBLE")) {
						semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
					}
				}
			}
		}else if(type.equals("NOT SAME"))  {
			semanticErrors.add("Error: the LHS datatype and RHS datatype of " + expr.toString() + " must be the same");
		}		


	}

	private void checkParameterForErrors(MyMethodBody methodbody , Map<String, String> parameter) {
		for(IfStatement i : methodbody.ifStatList) {
			if(getCondType(i.cond).equals("NO")) {
				if(!semanticErrors.contains("Error: condition " + i.cond.toString() + " error. LHS and RHS must match")){
					semanticErrors.add("Error: condition " + i.cond.toString() + " error. LHS and RHS must match");
				}
			}

			MyMethodBody ifBody = i.ifBody;
			MyMethodBody elseBody = i.elseBody;

			if(evaluated(i.cond, local_variableMap)) {
				checkIfBody(ifBody, methodbody, parameter);

				checkElseBody(elseBody, methodbody, parameter);

			}else {
				checkElseBody(ifBody, methodbody, parameter);

				checkIfBody(elseBody, methodbody, parameter);

			}	

		}

	}

	private void checkElseBody(MyMethodBody elsemethod, MyMethodBody methodbody, Map<String, String> parameter) {
		for(Declaration d : elsemethod.declList) {
			for(Declaration dl: methodbody.declList) {
				if(d.varName.equals(dl.varName)) {
					semanticErrors.add("Error: " + d.varName + " already been declared in mymethod");
				}
			}
		}

		for(Assignment a: elsemethod.assiList) {
			if(!local_variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error: variable " + a.varName + " is not declared yet");
			}else {
				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						checkMath((ValueMath)a.expr, a, false);
					}else {
						if(local_variableMap.containsKey(a.varName)) {
							if(!local_variableMap.get(a.varName).getType().equals(((Values)a.expr).getValues().getType())) {
								semanticErrors.add("Error: " + ((Values)a.expr).getValues() + " is not the same datatype as " + a.varName + " which is declared as " + local_variableMap.get(a.varName).getType());
							}
						}
					}
				}else if(a.expr instanceof ReturnMethodCall) {
					if(smtg(a.expr, a)) {
						this.local_variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
					}
				}else {
					this.semanticErrors.add("Error: variable " + a.varName + " return type does not match expression return type.");
				}
			}
		}

		if(elsemethod.ifStatList.size() > 0) {
			checkParameterForErrors(elsemethod, parameter);
		}

		if(elsemethod.methodCall.size() > 0) {
			checkVoidCall(elsemethod);
		}		
	}

	private void checkIfBody(MyMethodBody ifBody, MyMethodBody methodbody , Map<String, String> parameter) {
		for(Declaration d : ifBody.declList) {
			if(parameter.containsKey(d.varName)) {
				if(!semanticErrors.contains("Error: " + d.varName + " is a parameter of mymethod")) {
					semanticErrors.add("Error: " + d.varName + " is a parameter of mymethod");	
				}
			}
		}
		for(Declaration d : ifBody.declList) {
			for(Declaration dl: methodbody.declList) {
				if(d.varName.equals(dl.varName)) {
					semanticErrors.add("Error: " + d.varName + " already been declared in mymethod");
				}else {
					local_variableMap.put(d.varName, d.defaultValue);	
				}
			}
		}

		for(Assignment a: ifBody.assiList) {
			if(!local_variableMap.containsKey(a.varName)) {
				semanticErrors.add("Error: variable " + a.varName + " is not declared yet");
			}else {
				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						checkMath((ValueMath)a.expr, a, true);
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
						this.local_variableMap.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
					}
				}else {
					this.semanticErrors.add("Error: variable " + a.varName + " return type does not match expression return type.");
				}
			}
		}

		if(ifBody.ifStatList.size() > 0) {
			checkParameterForErrors(ifBody, parameter);
		}

		if(ifBody.methodCall.size() > 0) {
			checkVoidCall(ifBody);
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
				semanticErrors.add("Error: undefined. Cannot divide by 0");
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
				if(!semanticErrors.contains("Error: undefined. Cannot divide by 0")) {
					semanticErrors.add("Error: undefined. Cannot divide by 0");
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
			if(!local_variableMap.containsKey(e.varName)) {
				semanticErrors.add("Error: variable " + e.varName + " does not exist");
			}else {
				Values val = local_variableMap.get(e.varName);

				if(val.getType().equals("BOOLEAN")) {
					result = val.getType();
				}else {
					semanticErrors.add("Error: " + e.varName + " must be BOOLEAN type");
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
				semanticErrors.add("Error: variable " + a.varName + " is not declared");
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
}
