package model;

public class ReturnMethodCall {
	public String methodName;
	public String varName;
	
	public ReturnMethodCall(String methodName, String varName) {
		this.methodName = methodName;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return methodName + " [ " + varName + " ] " ;
	}
}
