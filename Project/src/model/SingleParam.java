package model;

public class SingleParam extends Parameter{
	private Params params;
	
	public SingleParam(Params params) {
		this.params = params;
	}
	
	@Override
	public String toString() {
		return super.toString() + params.toString();
	}
}
