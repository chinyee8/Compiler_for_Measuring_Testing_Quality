package model;

<<<<<<< Updated upstream
public class MyVoidMethod extends MethodType{
=======
public class MyVoidMethod extends MyVoidM{
>>>>>>> Stashed changes
	String voidType;
	Parameter param;
	MyMethodBody body;
	String varName;
	
	public MyVoidMethod(MyVoidMethod method, String voidType, Parameter param,
			MyMethodBody body,
			String varName) {
		super(method);
		this.param = param;
		this.body = body;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		
		result += voidType + " [ " + param.toString() + " ] ! \n";
		result += body.toString() + "\n";
		result += "!";
		
		return result ;
	}
}
