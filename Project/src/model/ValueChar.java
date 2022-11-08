package model;

public class ValueChar extends Values {
	char value;
	public ValueChar(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Character.toString(value);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "STRING";
	}
}
