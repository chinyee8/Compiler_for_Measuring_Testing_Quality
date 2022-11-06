package model;

import java.util.List;

import appAdd.Expression;

public class TestCase extends Expression{
	String testName;
	List<Declaration> decl;
	List<Assignment> assi;
	List<TestMethodCall> tmeth;

	public TestCase(String testName,
					List<Declaration> decl,
					List<Assignment> assi,
					List<TestMethodCall> tmeth) {
		this.testName = testName;
		this.decl = decl;
		this.assi = assi;
		this.tmeth = tmeth;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += "test " + testName + "[ ] ! \n";
		
		for(Declaration d: decl) {
			result += d.toString() + "\n";
		}
		
		for(Assignment a: assi) {
			result += a.toString() + "\n";
		}
		
		for(TestMethodCall t: tmeth) {
			result += t.toString() + "\n";
		}
		
		result += "!";
		
		return result;
	}
}
