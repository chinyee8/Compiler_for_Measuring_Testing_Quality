package model;

public class TestMath extends Input{
	Mathematics math;
	
	public TestMath(Mathematics math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return math.toString();
	}
}
