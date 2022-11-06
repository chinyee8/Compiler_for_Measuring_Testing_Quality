package model;

public class CallParamString extends Input{
	String input;
	public CallParamString(String input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return input;
	}
}
