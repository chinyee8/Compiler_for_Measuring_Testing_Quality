package model;

public class CallParamString extends Input_List{
	public String input;
	public CallParamString(String input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return input;
	}
}
