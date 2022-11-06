package model;

public class MultiParamChild {
	private Params params;

	public MultiParamChild(Params params) {
		this.params = params;
	}
	
	public String toString() {
		
		return "," + params.toString();
	}
}
