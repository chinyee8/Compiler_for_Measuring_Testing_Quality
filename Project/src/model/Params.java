package model;

public class Params{
	String dataType;
	String varName;
	
	public Params(String dataType, String varName) {
		this.dataType = dataType;
		this.varName = varName;
	}
	
	public String toString() {
		return dataType + " " + varName;
	}
}
