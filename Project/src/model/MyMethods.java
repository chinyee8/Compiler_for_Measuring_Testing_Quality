package model;

public class MyMethods{	
	String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	MethodType methodType; 
	
	
	public MyMethods(String methodName, MethodType methodType) {
		this.methodName = methodName;
		this.methodType = methodType;
	}
	
	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}
}
 
