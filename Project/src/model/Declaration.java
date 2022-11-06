package model;

import appAdd.Expression;

public class Declaration extends Expression{
	public String varName;
	public String dataType;
	
	public Declaration(String name, String type) { // constructor
		varName = name;
		dataType = type;
	}
	
	@Override
	public String toString() {
		return varName + " << " + dataType;
	}
}
