package model;

public class CallParamBoolean extends Input_List{
	public Boolean input;
	public CallParamBoolean(Boolean input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return Boolean.toString(input);
	}
}
