package model;

public class TestString extends Input{
	String input;
	public TestString(String input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return input;
	}
}
