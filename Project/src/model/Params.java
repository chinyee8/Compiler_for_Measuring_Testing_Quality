package model;

public class Params extends Parameter{
	String dataType;
	String varName;
	
	public Params(String dataType, String varName) {
		this.dataType = dataType;
		this.varName = varName;
	}
	@Override
	public String toString() {
		return dataType + " " + varName;
	}
}
