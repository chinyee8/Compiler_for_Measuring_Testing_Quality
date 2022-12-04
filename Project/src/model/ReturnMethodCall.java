package model;

public class ReturnMethodCall extends MethodCall {
	public String methodName;
	public Call_Parameter call_parameter;
	public int line ;
	
	public ReturnMethodCall(String methodName, Call_Parameter call_parameter, int line) {
		this.methodName = methodName;
		this.call_parameter = call_parameter;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return methodName + " [ " + call_parameter.toString() + " ] " ;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.methodName;
	}
}

