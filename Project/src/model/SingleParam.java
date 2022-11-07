package model;

public class SingleParam extends Parameter{
	Params params;
	
	public SingleParam(Params params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		return params.toString();
	}
}
