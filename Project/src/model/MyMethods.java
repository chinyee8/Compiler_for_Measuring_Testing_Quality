package model;

public class MyMethods{	
	String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	MethodType methodType; 
	
	
	public MyMethods(String methodName, MyReturnMethod methodType) {
		this.methodName = methodName;
		this.methodType = methodType;
	}
	
	public MyMethods(String methodName, MyVoidMethod methodType) {
		this.methodName = methodName;
		this.methodType = methodType;
	}
	
	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}
}
 
