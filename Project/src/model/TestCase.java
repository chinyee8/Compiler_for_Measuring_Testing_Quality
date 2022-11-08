package model;

import java.util.List;

public class TestCase extends Classes{
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
		
		result += "test " + testName + "[ ] ! \n";
		
		for(Declaration d: decl) {
			result += d.toString() + "\n";
		}
		
		for(Assignment a: assi) {
			result += a.toString() + "\n";
		}
		
		for(TestMethodCall t: t_method_call) {
			result += t.toString() + "\n";
		}
		
		result += "!";
		
		return result;
	}
}
