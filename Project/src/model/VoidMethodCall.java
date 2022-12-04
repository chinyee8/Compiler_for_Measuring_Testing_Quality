package model;

public class VoidMethodCall extends MethodCall{
	public String voidcall;
	public String methodname;
	public Call_Parameter call_parameter;
	public int line;
	
	public VoidMethodCall(String voidcall,
						String methodname,
						Call_Parameter call_parameter, int line) {
		this.voidcall = voidcall;
		this.methodname = methodname;
		this.call_parameter = call_parameter;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return voidcall + " " + methodname + " [ " + call_parameter.toString() + " ] ";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.methodname;
	}
}
