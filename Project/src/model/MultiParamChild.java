package model;

public class MultiParamChild extends Parameter{
	Params params;

	public MultiParamChild(Params param) {
		this.params = param;
	}
	
	@Override
	public String toString() {
		
		return ", " + params.toString();
	}

	
}
