package model;

public class VoidMethodCall extends MethodCall{
	String voidcall;
	String methodname;
	Call_Parameter call_parameter;
	
	public VoidMethodCall(String voidcall,
						String methodname,
						Call_Parameter call_parameter) {
		this.voidcall = voidcall;
		this.methodname = methodname;
		this.call_parameter = call_parameter;
	}
	
	@Override
	public String toString() {
		return voidcall + " " + methodname + " [ " + call_parameter.toString() + " ] ";
	}
}
