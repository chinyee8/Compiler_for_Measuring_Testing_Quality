package model;

public class CallParamMath extends Input{
	Mathematics math;
	
	public CallParamMath(Mathematics math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return math.toString();
	}
}
