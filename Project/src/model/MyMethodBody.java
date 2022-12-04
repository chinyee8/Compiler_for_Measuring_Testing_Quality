package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyMethodBody{
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<IfStatement> ifStatList;
	public List<MethodCall> methodCall;
	public List<Loop> loops;
	List<MyMethods> global_mymethods;
	private Map<String, Values> vars;

	public MyMethodBody(List<Declaration> declList,
			List<Assignment> assiList,
			List<IfStatement> ifStatList,
			List<MethodCall> methodcall2, List<MyMethods> global_mymethods, List<Loop> loops) {
		this.declList = declList;
		this.assiList = assiList;
		this.ifStatList = ifStatList;
		this.methodCall = methodcall2;
		this.global_mymethods = global_mymethods;
		this.vars = new HashMap<>();
		this.loops = loops;
	}

	public void getDeclaredList(Map<String, Values> vars2) {
		vars.putAll(vars2);

		for(Declaration d: declList) {
			if(!vars.containsKey(d.varName)) {
				vars.put(d.varName, d.defaultValue);
			}

		}
		for(Assignment a : assiList) {
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					String type = getMATHTYPE(((ValueMath)a.expr).math);
					if(type == "DOUBLE") {
						double d = getDouble(((ValueMath)a.expr).math);
						vars.put(a.varName, new ValueDouble(d));
					}else if(type == "INT") {
						int i = getInt(((ValueMath)a.expr).math);
						vars.put(a.varName, new ValueNum(i));
					}
				}else {
					vars.put(a.varName, ((Values)a.expr).getValues());
				}
			}else if(a.expr instanceof ReturnMethodCall) {
				vars.put(a.varName, callExpr(((ReturnMethodCall)a.expr), a.varName));
			}
		}

		for(IfStatement ifs: ifStatList) {
			MyMethodBody ifBody = ifs.ifBody;
			MyMethodBody elseBody = ifs.elseBody;


			List<String> convarlist = new ArrayList<>();
			convarlist = getCondVariableList(ifs.cond, convarlist);

			ifs.setCond(evaluated(ifs.cond, vars));

			if(evaluated(ifs.cond, vars)) {
				ifBody.getDeclaredList(vars2);
				this.vars.putAll(ifBody.vars);
			}else {
				elseBody.getDeclaredList(vars2);
				this.vars.putAll(elseBody.vars);
			}
		}

	}

	@Override
	public String toString() {
		String result = "";

		for(Declaration d: declList) {
			result += d.toString() + "<br>";
		}

		for(Assignment a: assiList) {
			result += a.toString() + "<br>";
		}

		for(IfStatement i: ifStatList) {
			result += i.toString() + "<br>";
		}


		for(MethodCall r: methodCall) {
			result += r.toString() + "<br>";
		}

		return result;
	}

	public Map<String, Values> getValues(Parameter parameter, Map<String, Values> lists) {
		int j = 0;
		for(Map.Entry<String, String> p : parameter.getParams().entrySet()) {
			int i = 0;
			for(Map.Entry<String, Values> l : lists.entrySet()) {
				if(i == j) {
					this.vars.put(p.getKey(), l.getValue());
				}
				i++;
			}
			j++;
		}
		getDeclaredList(this.vars);

		return this.vars;
	}

	private Values callExpr(ReturnMethodCall r, String varName) {
		System.out.println(r.toString());

		for(MyMethods m : this.global_mymethods) {
			if(m.methodName.equals(r.methodName) && m.methodType instanceof MyReturnMethod) {
				boolean noerror = true;
				List<String> RHSparams = r.call_parameter.getCallParams();
				Map<String, String> methodparams = ((MyReturnMethod)m.methodType).parameter.getParams();
				if(RHSparams.size() == methodparams.size() && RHSparams.size() > 0) {
					Map<String, Values> lists = new LinkedHashMap<>();
					for(String s: RHSparams) {
						lists.put(s, this.vars.get(s));
					}

						((MyReturnMethod)m.methodType).method_body.getValues(((MyReturnMethod)m.methodType).parameter, lists);
					
				}
			}

		}

		return vars.get(varName);

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
			result = this.vars.get(a.varName).getType();
		}

		return result;
	}

	private double getDouble(Mathematics m) {
		double result = 0.00;
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			double left = getDouble(a.math1);
			double right = getDouble(a.math2);
			result = left / right;
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getDouble(a.math);
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(this.vars.get(a.varName).getType().equals("DOUBLE")) {
				result = ((ValueDouble)(vars.get(a.varName))).value;
			}
		}

		return result;
	}

	public int getInt(Mathematics m) {
		int result = 0;

		if(m instanceof Addition) {
			Addition a = (Addition) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left - right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left * right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			int left = getInt(a.math1);
			int right = getInt(a.math2);
			result = left / right;
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = getInt(a.math);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = a.num;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(a.val.getType().equals("INT")) {
				result = ((ValueNum)(vars.get(a.varName))).num;
			}
		}

		return result;
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
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left == right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left == right;
			}
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left != right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left != right;
			}
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left >= right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left >= right;
			}
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			if(getMATHTYPE(e.left).equals("INT")) {
				int left = getInt(e.left);
				int right = getInt(e.right);
				result = left <= right;
			}else if(getMATHTYPE(e.left).equals("DOUBLE")) {
				double left = getDouble(e.left);
				double right = getDouble(e.right);
				result = left <= right;
			}
		}else if(c instanceof More) {
			More e = (More) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left > right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
				result = left > right;
			}
		}else if(c instanceof Less) {
			Less e = (Less) c;
			if(getMATHTYPE(e.math1).equals("INT")) {
				int left = getInt(e.math1);
				int right = getInt(e.math2);
				result = left < right;
			}else if(getMATHTYPE(e.math1).equals("DOUBLE")) {
				double left = getDouble(e.math1);
				double right = getDouble(e.math2);
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
