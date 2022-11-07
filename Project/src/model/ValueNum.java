package model;

public class ValueNum extends Value_List{
// should I make each containers for NUM | DOUBLE | STRING | CHAR | BOOL ?? 
	int num;
	public ValueNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return Integer.toString(num);
	}
}
