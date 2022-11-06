package model;

public class ValueChar extends AssiExprValues {
	char value;
	public ValueChar(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Character.toString(value);
	}
}
