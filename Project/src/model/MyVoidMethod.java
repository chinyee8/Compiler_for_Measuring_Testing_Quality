package model;

public class MyVoidMethod extends MethodType{
	String voidType;
	Parameter param;
	MyMethodBody body;
	String varName;
	
	public MyVoidMethod(String voidType, Parameter param,
			MyMethodBody body,
			String varName) {
		this.param = param;
		this.body = body;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		
		result += voidType + " [ " + param.toString() + " ] ! \n";
		result += body.toString() + "\n";
		result += "!";
		
		return result ;
	}
}
