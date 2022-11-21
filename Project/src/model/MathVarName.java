package model;

public class MathVarName extends Mathematics{
	public String varName;
	public Values val;
	
	public MathVarName(String varName, Values val) {
		this.varName = varName;
		this.val = val;
	}
	
	
	@Override
	public String toString() {
		return varName;
	}
}
