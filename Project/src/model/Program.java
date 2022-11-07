package model;

import java.util.ArrayList;
import java.util.List;

public class Program{

	public GameClass gameclass;
	public List<TestCase> testcase;
	
	public Program() { // constructor
		this.testcase = new ArrayList<>();
	}
  
	public void addGameClass(GameClass  e) {
		gameclass = e;
	}
	
	public void addTestCase(TestCase  e) {
		this.testcase.add(e);
	}
}
