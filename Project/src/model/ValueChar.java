package model;

public class ValueChar extends Value_List {
	char value;
	public ValueChar(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Character.toString(value);
	}
}
