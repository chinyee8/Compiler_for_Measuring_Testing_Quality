package model;

import java.util.List;

public class MyMethodBody{
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<IfStatement> ifStatList;
	public List<MethodCall> methodCall;

	public MyMethodBody(List<Declaration> declList,
			List<Assignment> assiList,
			List<IfStatement> ifStatList,
			List<MethodCall> methodcall2) {
		this.declList = declList;
		this.assiList = assiList;
		this.ifStatList = ifStatList;
		this.methodCall = methodcall2;
	}

	@Override
	public String toString() {
		String result = "";

		for(Declaration d: declList) {
			result += d.toString() + "<br>";
		}

		for(Assignment a: assiList) {
			result += a.toString() + "<br>";
		}

		for(IfStatement i: ifStatList) {
			result += i.toString() + "<br>";
		}


		for(MethodCall r: methodCall) {
			result += r.toString() + "<br>";
		}

		return result;
	}
}
