package model;

public class CallParamCond extends Input_List{
	Condition cond;
	
	public CallParamCond(Condition cond) {
		this.cond = cond;
	}
	
	@Override
	public String toString() {
		return cond.toString();
	}
	
}
