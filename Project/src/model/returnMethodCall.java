package model;

public class returnMethodCall extends RMethodCall {
	public String methodName;
	public String varName;
	
	public returnMethodCall(String methodName, String varName) {
		this.methodName = methodName;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return methodName + " [ " + varName + " ] " ;
	}
}
