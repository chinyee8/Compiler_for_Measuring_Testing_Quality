package model;

public class MyMethods extends Expression{
	String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	MethodType methodType; 
	
	
	public MyMethods(String name, MyReturnM type) {
		methodName = name;
		methodType = type;
	}
	
	public MyMethods(String name, MyVoidM type) {
		methodName = name;
		methodType = type;
	}
	
	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}
}
 
/*
 	String methodName;
	MethodType methodType; 
	
	
	public MyMethod(String name, MethodType type) {
		methodName = name;
		methodType = type;
	}

	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}
*/
