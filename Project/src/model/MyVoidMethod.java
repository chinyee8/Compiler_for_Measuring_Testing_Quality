package model;

public class MyVoidMethod extends MethodType{
	public String voidType;
	public Parameter parameter;
	public MyMethodBody method_body;
	public String varName;
	
	public MyVoidMethod(String voidType, Parameter parameter,
			MyMethodBody method_body) {
		this.voidType = voidType;
		this.parameter = parameter;
		this.method_body = method_body;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += voidType + " [ " + parameter.toString() + " ] ! <br>";
		result += method_body.toString() + "<br>";
		result += "!";
		
		return result ;
	}
}
