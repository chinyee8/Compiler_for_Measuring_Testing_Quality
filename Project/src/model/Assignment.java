package model;

public class Assignment {
	public String varName;
	public AssiRMethodCall assiRMethodCall;
	public AssiExprValues assiExprValues;
	
	public Assignment(String name, 
			AssiRMethodCall method,
			AssiExprValues expVal) {
		
		varName = name;
		assiRMethodCall = method;
		assiExprValues = expVal;
	}
	
}
