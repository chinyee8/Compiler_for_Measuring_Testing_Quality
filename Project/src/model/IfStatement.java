package model;

public class IfStatement{
	private Condition cond;
	private MyMethodBody methbody1;
	private MyMethodBody methbody2;
	
	public IfStatement(Condition cond, MyMethodBody methbody1, MyMethodBody methbody2) {
		this.cond = cond;
		this.methbody1 = methbody1;
		this.methbody2 = methbody2;
	}
	
	public String toString() {
		String result = "";
		
		result += "jackieAsks [ " + cond.toString() + " ] !\n";
		result += methbody1.toString() + "\n";
		result += "! elseJackie !\n";
		result += methbody2.toString() + "\n";
		result += "!";
		
		return result;
	}
}
