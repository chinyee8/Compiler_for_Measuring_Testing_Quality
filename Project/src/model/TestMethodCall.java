package model;

public class TestMethodCall{
	 String className;
	 String methodName;
	 Call_Parameter call_parameter;
	
	public TestMethodCall(String className,
						  String methodName,
						  Call_Parameter call_parameter) {
		this.className = className;
		this.methodName = methodName;
		this.call_parameter = call_parameter;
	}
	
	public String toString() {
		return className + "." + methodName + "[ " + call_parameter.toString() + " ]";
	}
}
