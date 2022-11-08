package model;

public class MyReturnMethod extends MethodType {
	public String dataType;
	public Parameter parameter;
	public MyMethodBody method_body;
	public String varName;
	
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
		
		result += dataType + " [ " + parameter.toString() + " ] ! <br>";
		result += method_body.toString() + "<br>";
		result += "jackieReturns " + varName + "<br>!";
		
		return result ;
	}
}
