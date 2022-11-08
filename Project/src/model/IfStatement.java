package model;

public class IfStatement{
	Condition cond;
	MyMethodBody methbody1;
	MyMethodBody methbody2;

	public IfStatement(Condition cond, MyMethodBody ifBody, MyMethodBody elseBody) {
		this.cond = cond;
		this.methbody1 = ifBody;
		this.methbody2 = elseBody;
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
