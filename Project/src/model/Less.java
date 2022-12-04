package model;

public class Less extends Condition{
	public Mathematics math1;
	public Mathematics math2;
	public int line;
	
	public Less(Mathematics math1, Mathematics math2, int line) {
		this.math1 = math1;
		this.math2 = math2;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return math1.toString() + " < " + math2.toString();
	}
}
