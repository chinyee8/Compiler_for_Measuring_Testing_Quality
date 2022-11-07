package model;

public class MyVoidMethod extends MethodType{
	String voidType;
	Parameter parameter;
	MyMethodBody method_body;
	String varName;
	
	public MyVoidMethod(String voidType, Parameter parameter,
			MyMethodBody method_body,
			String varName) {
		this.parameter = parameter;
		this.method_body = method_body;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += voidType + " [ " + parameter.toString() + " ] ! \n";
		result += method_body.toString() + "\n";
		result += "!";
		
		return result ;
	}
}
