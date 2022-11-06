package model;

public class CallParamVarName extends Input{
	String varName;
	
	public CallParamVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return this.varName;
	}
}
