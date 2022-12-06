package model;

public class MathParenthesis extends Mathematics{
	public Mathematics math;
	
	public MathParenthesis(Mathematics math) {
		this.math = math;
	}
	
	@Override
	public String toString() {
		return "( " + math.toString() + " )";
	}
}
