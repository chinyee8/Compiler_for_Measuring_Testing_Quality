package model;

public class MyMethods{	
	String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	MethodType methodType; 
	
	
	public MyMethods(String name, MyReturnMethod method_type) {
		methodName = name;
		methodType = method_type;
	}
	
	public MyMethods(String name, MyVoidMethod method_type) {
		methodName = name;
		methodType = method_type;
	}
	
	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}
}
 
