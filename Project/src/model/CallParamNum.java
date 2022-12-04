package model;

public class CallParamNum extends Input_List{
	public int num;
	
	public CallParamNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return Integer.toString(num);
	}
}
