package model;

public class MultiParam extends Parameter{
	private Params params;
	private MultiParamChild multiparams;
	
	public MultiParam(Params params, MultiParamChild multiparams) {
		this.params = params;
		this.multiparams = multiparams;
	}
	
	@Override
	public String toString() {
		return super.toString() + params.toString() + multiparams.toString();
	}
}
