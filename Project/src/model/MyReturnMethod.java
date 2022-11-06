package model;

<<<<<<< Updated upstream
public class MyReturnMethod extends MethodType {
=======
public class MyReturnMethod extends MyReturnM{
>>>>>>> Stashed changes
	String dataType;
	Parameter param;
	MyMethodBody body;
	String varName;
	
	public MyReturnMethod(MyReturnMethod method, String dataType,
			Parameter param,
			MyMethodBody body,
			String varName) {
		super(method);
		this.dataType = dataType;
		this.param = param;
		this.body = body;
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		
		result += dataType + " [ " + param.toString() + " ] ! \n";
		result += body.toString() + "\n";
		result += "jackieReturns " + varName + "\n!";
		
		return result ;
	}
}
