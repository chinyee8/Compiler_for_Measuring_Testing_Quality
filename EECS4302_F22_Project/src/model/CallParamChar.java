package model;

public class CallParamChar extends Input_List{
	public char input;
	
	public CallParamChar(char input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return Character.toString(input);
	}
}
