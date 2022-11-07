package model;

public class ValueMath extends Values {
	Mathematics math;
	
	public ValueMath(Mathematics math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return math.toString();
	}
}
