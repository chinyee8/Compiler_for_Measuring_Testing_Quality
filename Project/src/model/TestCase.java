package model;

import java.util.List;

public class TestCase{
	String testName;
	List<Declaration> decl;
	List<Assignment> assi;
	List<TestMethodCall> t_method_call;

	public TestCase(String testName,
					List<Declaration> decl,
					List<Assignment> assi,
					List<TestMethodCall> t_method_call) {
		this.testName = testName;
		this.decl = decl;
		this.assi = assi;
		this.t_method_call = t_method_call;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		result += "test " + testName + "[ ] ! <br>";
		
		for(Declaration d: decl) {
			result += d.toString() + "<br>";
		}
		
		for(Assignment a: assi) {
			result += a.toString() + "<br>";
		}
		
		for(TestMethodCall t: t_method_call) {
			result += t.toString() + "<br>";
		}
		
		result += "!";
		
		return result;
	}
}
