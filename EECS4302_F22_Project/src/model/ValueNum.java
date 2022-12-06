package model;

public class ValueNum extends Values{
// should I make each containers for NUM | DOUBLE | STRING | CHAR | BOOL ?? 
	public int num;
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

	@Override
	public Values getValues() {
		// TODO Auto-generated method stub
		return new ValueNum(num);
	}

	public int getNum() {
		return num;
	}
}
