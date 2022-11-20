package model;

import java.util.*;

public class TestCase {
	public String testName;
	public List<Declaration> decl;
	public List<Assignment> assi;
	public List<TestMethodCall> t_method_call;
	public List<Program> programList;
	public List<MethodCall> allMethodCalls;

	public TestCase(String testName, List<Declaration> decl, List<Assignment> assi,
			List<TestMethodCall> t_method_call) {
		this.testName = testName;
		this.decl = decl;
		this.assi = assi;
		this.t_method_call = t_method_call;
		programList = new ArrayList<Program>();
	}

	public TestCase(String testName, List<Declaration> decl, List<Assignment> assi,
			List<TestMethodCall> t_method_call, List<Program> p) {
		this.testName = testName;
		this.decl = decl;
		this.assi = assi;
		this.t_method_call = t_method_call;
		programList = p;
	}

	@Override
	public String toString() {
		String result = "";

		result += "test " + testName + "[ ] ! <br>";

		for (Declaration d : decl) {
			result += d.toString() + "<br>";
		}

		for (Assignment a : assi) {
			result += a.toString() + "<br>";
		}

		for (TestMethodCall t : t_method_call) {
			result += t.toString() + "<br>";
		}

		result += "!";

		return result;
	}
	
	public void addAll(List<MethodCall> all) {
		this.allMethodCalls = all;
	}
}
