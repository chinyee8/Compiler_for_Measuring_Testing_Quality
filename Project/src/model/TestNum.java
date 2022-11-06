package model;

public class TestNum extends Input{
	int num;
	
	public TestNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return Integer.toString(num);
	}
}
