package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyMethodBody{
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<IfStatement> ifStatList;
	public List<MethodCall> methodCall;
	List<MyMethods> global_mymethods;
	private Map<String, Values> vars;

	public MyMethodBody(List<Declaration> declList,
			List<Assignment> assiList,
			List<IfStatement> ifStatList,
			List<MethodCall> methodcall2, List<MyMethods> global_mymethods) {
		this.declList = declList;
		this.assiList = assiList;
		this.ifStatList = ifStatList;
		this.methodCall = methodcall2;
		this.global_mymethods = global_mymethods;
		this.vars = new HashMap<>();
	}
	
	public void getDeclaredList() {
		for(Declaration d: declList) {
			vars.put(d.varName, d.defaultValue);
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
		for(IfStatement i : ifStatList) {
			MyMethodBody ifbody = i.getIfBody();
			vars.putAll(ifbody.getValues(vars));
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

	public Map<String, Values> getValues(Map<String, Values> lists) {
		this.vars.putAll(lists);
		getDeclaredList();
		
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
					boolean contains = true;
					Map<String, Values> lists = new LinkedHashMap<>();
					for(String s : RHSparams) {
						if(!this.vars.containsKey(s)) {
							contains = false;
						}else {
							lists.put(s, this.vars.get(s));
						}
					}

					if(contains) {
						int i = 0;
						for(Map.Entry<String, String> map: methodparams.entrySet()){
							if(!(this.vars.get(RHSparams.get(i)).getType().equals(map.getValue()))){
								noerror = false;
							}
							i++;
						}
					}
					
					if(noerror) {
						((MyReturnMethod)m.methodType).method_body.getValues(lists);
					}
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
			result = a.val.getType();
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
			if(a.val.getType().equals("DOUBLE")) {
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
}
