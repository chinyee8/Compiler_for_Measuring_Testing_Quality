package model;

public class NotEqualTo extends Condition{
	public Condition left;
	public Condition right;
	
	public NotEqualTo(Condition cond1, Condition cond2) {
		this.left = cond1;
		this.right = cond2;
	}
	
	@Override
	public String toString() {
		return left.toString() + " /= " + right.toString();
	}
}