package model;

public class MultiParamChild {
	Params params;

	public MultiParamChild(Params param) {
		this.params = param;
	}
	
	public String toString() {
		
		return "," + params.toString();
	}
}
