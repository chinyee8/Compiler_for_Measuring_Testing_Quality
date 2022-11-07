package model;

public class ValueString extends Value_List {
	String value;
	public ValueString(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
