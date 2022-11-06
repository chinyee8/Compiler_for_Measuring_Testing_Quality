package model;

public class TestChar extends Input{
	char input;
	
	public TestChar(char input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return Character.toString(input);
	}
}
