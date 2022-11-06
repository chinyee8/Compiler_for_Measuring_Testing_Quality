package model;

public class TestMath {
	Mathematics math;
	
	public TestMath(Mathematics math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return math.toString();
	}
}
