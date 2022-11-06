package model;

public class TestInputs extends Input{
	Input input1;
	Input input2;
	
	public TestInputs(Input input1, Input input2) {
		this.input1 = input1;
		this.input2 = input2;
	}
	
	@Override
	public String toString() {
		return input1.toString() + ", " + input2.toString();
	}
}
