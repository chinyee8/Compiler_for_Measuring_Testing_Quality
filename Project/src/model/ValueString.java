package model;

public class ValueString extends Values {
	String value;
	public ValueString(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "STRING";
	}

	@Override
	public Values getValues() {
		// TODO Auto-generated method stub
		return new ValueString(value);
	}
}
