package model;

import java.util.List;
import appAdd.Expression;

public class MyMethodBody extends Expression{
	public List<Declaration> declList;
	public List<Assignment> assiList;
	public List<IfStatement> ifStatList;
	public List<returnMethodCall> rMethodList;
	
	public MyMethodBody(List<Declaration> declList,
						List<Assignment> assiList,
						List<IfStatement> ifStatList,
						List<returnMethodCall> rMethodList) {
		this.declList = declList;
		this.assiList = assiList;
		this.ifStatList = ifStatList;
		this.rMethodList = rMethodList;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for(Declaration d: declList) {
			result += d.toString() + "\n";
		}
		
		for(Assignment a: assiList) {
			result += a.toString() + "\n";
		}
		
		for(IfStatement i: ifStatList) {
			result += i.toString() + "\n";
		}
		
		for(returnMethodCall r: rMethodList) {
			result += r.toString() + "\n";
		}
		
		return result;
	}
}
