package model;

import java.util.ArrayList;
import java.util.List;

public class Program{

	public List<Classes> classes;

	
	public Program() { // constructor
		this.classes = new ArrayList<>();
	}
 
	
	public void addClass(Classes  e) {
		classes.add(e);
	}
	
}
