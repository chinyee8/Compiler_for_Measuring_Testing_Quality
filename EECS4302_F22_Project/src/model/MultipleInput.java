package model;

public class MultipleInput{
	Input_List input;
	
	public MultipleInput(Input_List input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return ", " + input.toString();
	}
}
