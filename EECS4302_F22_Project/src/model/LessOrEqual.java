package model;

public class LessOrEqual extends Condition{
	public Mathematics left;
	public Mathematics right;
	public int line;
	
	public LessOrEqual(Mathematics left, Mathematics right, int line) {
		this.left = left;
		this.right = right;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return left.toString() + " <= " + right.toString();
	}
}
