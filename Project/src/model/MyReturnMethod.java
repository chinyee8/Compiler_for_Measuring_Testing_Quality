package model;

public class MyReturnMethod extends MethodType {
	String dataType;
	Parameter parameter;
	MyMethodBody method_body;
	String varName;
	
	public MyReturnMethod(String dataType,
			Parameter parameter,
			MyMethodBody method_body,
			String varName) {
		this.dataType = dataType;
		this.parameter = parameter;
		this.method_body = method_body;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += dataType + " [ " + parameter.toString() + " ] ! \n";
		result += method_body.toString() + "\n";
		result += "jackieReturns " + varName + "\n!";
		
		return result ;
	}
}
