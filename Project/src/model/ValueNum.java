package model;

public class ValueNum extends Values{
// should I make each containers for NUM | DOUBLE | STRING | CHAR | BOOL ?? 
	int num;
	public ValueNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return Integer.toString(num);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "INT";
	}
}
