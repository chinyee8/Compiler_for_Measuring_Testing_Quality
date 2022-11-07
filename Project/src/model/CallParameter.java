package model;

public class CallParameter extends Call_Parameter {
	Input_List input;
	
	public CallParameter(Input_List input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return input.toString();
	}
}
