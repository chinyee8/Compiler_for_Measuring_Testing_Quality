package model;

public class CallParamNum extends Input_List{
	int num;
	
	public CallParamNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return Integer.toString(num);
	}
}
