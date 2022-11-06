package model;

public class CallParamNum extends Input{
	int num;
	
	public CallParamNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return Integer.toString(num);
	}
}
