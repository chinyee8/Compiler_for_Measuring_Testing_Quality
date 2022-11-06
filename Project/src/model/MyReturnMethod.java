package model;

public class MyReturnMethod extends MethodType {
	String dataType;
	Parameter param;
	MyMethodBody body;
	String varName;
	
	public MyReturnMethod(String dataType,
			Parameter param,
			MyMethodBody body,
			String varName) {
		this.dataType = dataType;
		this.param = param;
		this.body = body;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += dataType + " [ " + param.toString() + " ] ! \n";
		result += body.toString() + "\n";
		result += "jackieReturns " + varName + "\n!";
		
		return result ;
	}
}
