package model;

public class ValueString extends AssiExprValues {
	String value;
	public ValueString(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
