package model;

public class MathParenthesis extends Mathematics{
	Mathematics math;
	
	public MathParenthesis(Mathematics math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return "( " + math.toString() + " )";
	}
}
