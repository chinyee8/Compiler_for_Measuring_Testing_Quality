package model;

public class MathVarName extends Mathematics{
	String varName;
	
	public MathVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return varName;
	}
}
