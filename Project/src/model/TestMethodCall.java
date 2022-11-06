package model;

import appAdd.Expression;

public class TestMethodCall extends Expression{
	String className;
	String methodName;
	Input input;
	
	public TestMethodCall(String className,
							String methodName,
							Input input) {
		this.className = className;
		this.methodName = methodName;
		this.input = input;
	}
	
	@Override
	public String toString() {
		return className + "." + methodName + "[ " + input.toString() + " ]";
	}
}
