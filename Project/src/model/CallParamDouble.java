package model;

public class CallParamDouble extends Input_List{
	double input;
	
	public CallParamDouble(double input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return Double.toString(input);
	}
}
