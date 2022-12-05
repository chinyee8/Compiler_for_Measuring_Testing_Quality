package model;

import java.util.Map;

public class MyReturnMethod extends MethodType {
	public String dataType;
	public Parameter parameter;
	public MyMethodBody method_body;
	public String varName;
	public Values returnValue;
	public int jackieReturnLine;
	
	public MyReturnMethod(String dataType,
			Parameter parameter,
			MyMethodBody method_body,
			String varName, int line) {
		this.dataType = dataType;
		this.parameter = parameter;
		this.method_body = method_body;
		this.varName = varName;
		this.jackieReturnLine = line;
	}
	public MyReturnMethod(String dataType,
			Parameter parameter,
			MyMethodBody method_body,
			String varName, Values returnValue, int line) {
		this.dataType = dataType;
		this.parameter = parameter;
		this.method_body = method_body;
		this.varName = varName;
		this.returnValue = returnValue;
		this.jackieReturnLine = line;
	}
	@Override
	public String toString() {
		String result = "";
		
		result += dataType + " [ " + parameter.toString() + " ] ! <br>";
		result += method_body.toString() + "<br>";
		result += "jackieReturns " + varName + "<br>!";
		
		return result ;
	}
	
	public Values getValue(Map<String, Values> lists) {
		Values result = this.method_body.getValues(parameter, lists).get(varName);
		return result;
	}

	public void putReturnValue(Values v) {
		this.returnValue = v;
	}
	
}
