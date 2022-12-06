package model;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.codegen.model.decl.Decl;

public class MyMethods{	
	public String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	public MethodType methodType; 	
	public int line;
	
	public MyMethods(String methodName, int line) {
		this.methodName = new String(methodName);
		this.line = new Integer(line);
	}
	
	public MyMethods(String methodName, MyReturnMethod methodType2, int line) {
		this.methodName = methodName;
		this.methodType = methodType2;
		this.line = line;
	}
	
	public MyMethods(String methodName, MyVoidMethod methodType, int line) {
		this.methodName = methodName;
		this.methodType = methodType;
		this.line = line;
	}

//	public MyMethods(MyMethods g, MyReturnMethod mt) {
//		this(g.methodName, g.line);
//		String datatype = new String(mt.dataType);
//		Parameter parameter = mt.parameter;
//		MyMethodBody mmb = mt.method_body; 
//		
//		List<Declaration> newDecl = new ArrayList<>();
//		for(Declaration d: mmb.declList) {
//			Declaration decl = new Declaration(new String(d.varName), new String(d.dataType), d.line);
//			newDecl.add(decl);
//		}
//		
//		List<Assignment> newAssi = new ArrayList<>();
//		for(Assignment d: mmb.assiList) {
//			Assignment decl = new Assignment(new String(d.varName), d.expr, d.line);
//			newAssi.add(decl);
//		}
//		
//		List<IfStatement> newIfStat = new ArrayList<>();
//		for(IfStatement d: mmb.ifStatList) {
//			IfStatement decl = new IfStatement(d.cond, , mmb, null, line)
//			newAssi.add(decl);
//		}
//		
//		MyMethodBody method_body = new MyMethodBody(null, null, null, null, null, null, null)
//		String varName = new String(mt.varName);
//		boolean jackieReturnCovered = new Boolean(mt.jackieReturnCovered);
//		MyReturnMethod nrmc = new MyReturnMethod(datatype, parameter, method_body, varName, mt.jackieReturnLine);
//	}
//	
//	public MyMethods(MyMethods g, MyVoidMethod mt) {
//		this(g.methodName, g.line);
//		
//	}

	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}

}
 
