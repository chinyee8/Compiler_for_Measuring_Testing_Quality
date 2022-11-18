package model;

import java.util.ArrayList;
import java.util.List;

public class Program{
	public GameClass gameclass;
	public TestCase testcase;

	
	public Program() { // constructor
	}
 
	
	public void addTestCase(TestCase  e) {
		testcase = e;
	}


	public void addGameClass(GameClass e) {
		gameclass = e;
	}
	
}
