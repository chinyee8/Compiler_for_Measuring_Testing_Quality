package model;

public class TestMethodCall{
	private String className;
	private String methodName;
	private Input input;
	
	public TestMethodCall(String className,
						  String methodName,
						  Input input) {
		this.className = className;
		this.methodName = methodName;
		this.input = input;
	}
	
	public String toString() {
		return className + "." + methodName + "[ " + input.toString() + " ]";
	}
}
