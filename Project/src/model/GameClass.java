package model;

public class GameClass extends Expression{
	public String className;
	public GameBody classBody;
	
	public GameClass(String className, GameBody classBody) {
		this.className = className;
		this.classBody = classBody;
	}
	
	@Override
	public String toString() {
		String result = "";
		
			result = "game " + this.className + "[ ] !\n";
			result += this.classBody.toString() + "\n";
			result += "!";
			
		return result;
	}
}
