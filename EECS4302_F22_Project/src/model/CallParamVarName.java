package model;

public class CallParamVarName extends Input_List{
	public String varName;
	
	public CallParamVarName(String varName) {
		this.varName = varName;
	}
	
	@Override
	public String toString() {
		return varName;
	}
}
