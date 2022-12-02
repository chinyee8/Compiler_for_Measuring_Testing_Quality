package model;

import java.util.*;

public class TestCase {
	public String testName;
	public List<Declaration> decl;
	public List<Assignment> assi;
	public List<TestMethodCall> t_method_call;
	public Map<MethodCall, Map<String, Values>> allMethodCalls;
	public Map<MethodCall, List<String>> methodCallParamOrder;
	public Values testValue;
	
	public TestCase(String testName, List<Declaration> decl, List<Assignment> assi,
			List<TestMethodCall> t_method_call, Map<MethodCall, List<String>> methodCallParamOrder) {
		this.testName = testName;
		this.decl = decl;
		this.assi = assi;
		this.t_method_call = t_method_call;
		this.methodCallParamOrder = methodCallParamOrder;
	}

	public TestCase(String testName, List<Declaration> decl, List<Assignment> assi,
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
	
	public void addAll(Map<MethodCall, Map<String, Values>> allMethodCalls2) {
		this.allMethodCalls = allMethodCalls2;
	}
	
	public void addParamOrder(Map<MethodCall, List<String>> s) {
		this.methodCallParamOrder = s;
	}

	public void putTestValue(Values testValue) {
		this.testValue = testValue;
	}
}
