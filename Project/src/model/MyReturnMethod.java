package model;

public class MyReturnMethod {
	String dataType;
	MyParameter param;
	MyMethodBody body;
	String varName;
	
	public MyReturnMethod(String dataType,
			MyParameter param,
			MyMethodBody body,
			String varName) {
		this.dataType = dataType;
		this.param = param;
		this.body = body;
		this.varName = varName;
	}
}
