package model;

public class TestDouble extends Input{
	double input;
	
	public TestDouble(double input) {
		this.input = input;
	}
	
	@Override
	public String toString() {
		return Double.toString(input);
	}
}
