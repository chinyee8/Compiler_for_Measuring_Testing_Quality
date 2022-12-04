package model;


public class MyMethods{	
	public String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	public MethodType methodType; 	
	public int line;
	
	public MyMethods(String methodName, MyReturnMethod methodType2, int line) {
		this.methodName = methodName;
		this.methodType = methodType2;
		this.line = line;
	}
	
	public MyMethods(String methodName, MyVoidMethod methodType, int line) {
		this.methodName = methodName;
		this.methodType = methodType;
		this.line = line;
	}

	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}

}
 
