package model;

import java.util.Map;

public class MyReturnMethod extends MethodType {
	public String dataType;
	public Parameter parameter;
	public MyMethodBody method_body;
	public String varName;
	public Values returnValue;
	
	public MyReturnMethod(String dataType,
			Parameter parameter,
			MyMethodBody method_body,
			String varName) {
		this.dataType = dataType;
		this.parameter = parameter;
		this.method_body = method_body;
		this.varName = varName;
	}
	public MyReturnMethod(String dataType,
			Parameter parameter,
			MyMethodBody method_body,
			String varName, Values returnValue) {
		this.dataType = dataType;
		this.parameter = parameter;
		this.method_body = method_body;
		this.varName = varName;
		this.returnValue = returnValue;
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
		Values result = this.method_body.getValues(lists).get(varName);
		return result;
	}

	
}
