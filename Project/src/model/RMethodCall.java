package model;

public class RMethodCall extends Expr  {
	ReturnMethodCall r_method_call;
	
	public RMethodCall(ReturnMethodCall r_method_call) {
		this.r_method_call = r_method_call;
	}
	
	@Override
	public String toString() {
		return r_method_call.toString();
	}
}
