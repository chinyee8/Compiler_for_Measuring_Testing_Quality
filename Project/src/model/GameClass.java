package model;

import java.util.List;

public class GameClass {
	public String className;
	public List<GameBody> classBody;
	
	public GameClass(String className, List<GameBody> classBody) {
		this.className = className;
		this.classBody.addAll(classBody);
	}
}
