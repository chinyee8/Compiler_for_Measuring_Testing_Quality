package model;

public class CondVarName extends Condition{
	public String varName;
	public int line;
	
	public CondVarName(String varName, int line) {
		this.varName = varName;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return varName;
	}
}
