package model;

public class MathVarName extends Mathematics{
	public String varName;
	public Values val;
	public int line;
	
	public MathVarName(String varName, Values val, int line) {
		this.varName = varName;
		this.val = val;
		this.line = line;
	}
	
	
	@Override
	public String toString() {
		return varName;
	}
}
