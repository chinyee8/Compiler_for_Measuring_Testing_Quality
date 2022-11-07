package model;

public class Multi_Input {
	Input_List input;
	
	public Multi_Input(Input_List input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return ", " + input.toString();
	}
}
