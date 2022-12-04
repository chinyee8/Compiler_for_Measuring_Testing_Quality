package model;

public class NotEqualTo extends Condition{
	public Condition left;
	public Condition right;
	public int line;
	
	public NotEqualTo(Condition cond1, Condition cond2, int line) {
		this.left = cond1;
		this.right = cond2;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return left.toString() + " /= " + right.toString();
	}
}