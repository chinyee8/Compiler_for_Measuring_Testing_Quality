package model;

import java.util.ArrayList;
import java.util.List;

public class Program{
	public GameClass gameclass;
	public List<TestCase> testcases;

	
	public Program() { // constructor
		this.testcases = new ArrayList<>();
	}
 
	
	public void addTestCase(TestCase  e) {
		testcases.add(e);
	}


	public void addGameClass(GameClass e) {
		gameclass = e;
	}
	
}
