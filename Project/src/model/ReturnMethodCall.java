package model;

public class ReturnMethodCall extends MethodCall {
	public String methodName;
	public Call_Parameter call_parameter;
	
	public ReturnMethodCall(String methodName, Call_Parameter call_parameter) {
		this.methodName = methodName;
		this.call_parameter = call_parameter;
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

