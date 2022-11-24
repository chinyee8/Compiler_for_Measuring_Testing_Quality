package Operations;

import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Assignment;
import model.Declaration;
import model.IfStatement;
import model.MethodCall;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Program;
import model.VoidMethodCall;

public class Statement {
	private ArrayList<Program> programList;
	private Map<Integer, List<String>> lines;

	public Statement(ArrayList<Program> programList, Map<Integer, List<String>> lines) {
		this.programList = programList;
		this.lines = lines;
	}

	public String getString(int testnum) {
		String result = "";
		Program p = programList.get(testnum);

		result += "game " + p.gameclass.className + " [] !<br><br>";

		for(MyMethods mm : p.gameclass.body.myMethodList) {
			if( mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
				String para = ""; int i = 0;
				for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
					para += p1.getValue()+ " " + p1.getKey();
					if(i < mt.parameter.getParams().size()-1) {
						para+= ", ";
					}
					i++;
				}
				result += "&emsp;mymethod " + mm.methodName + " " + mt.dataType + " [ " + para + " ] !<br>";
				
				for(Declaration d: ((MyReturnMethod)mm.methodType).method_body.declList) {
					if(d.covered) {
						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+d.toString()+"</mark><br>");
					}else {
						result+=("&emsp;&emsp;"+d.toString() + "<br>");
					}
				}
				for(Assignment a: ((MyReturnMethod)mm.methodType).method_body.assiList) {
					if(a.covered) {
						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+a.toString()+"</mark><br>");
					}else {
						result+=("&emsp;&emsp;"+a.toString()+ "<br>");
					}
				}
				for(IfStatement i1 : ((MyReturnMethod)mm.methodType).method_body.ifStatList) {
					if(i1.ifCovered == true) {
						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
						result +="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.ifBody.toString()+"</mark><br>";
						result += "&emsp;&emsp;! elseJackie !<br>";
						result += "&emsp;&emsp;&emsp;" + i1.elseBody.toString() + "<br>";
					}else if(i1.elseCovered == true) {
						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
						result += "&emsp;&emsp;! elseJackie !<br>";
						result+="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.elseBody.toString()+"</mark><br>";
					}else {
						result+="<br>&emsp;&emsp;jackieAsks [ " + i1.cond.toString() + " ] !<br>";
						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
						result += "&emsp;&emsp;! elseJackie !<br>";
						result += "&emsp;&emsp;&emsp;" +i1.elseBody.toString()+ "<br>";

					}
					result += "&emsp;&emsp;!<br>";
				}
				
				//change later for jackieReturns by input in the true section
				if(true) {
					result += "<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieReturns " + mt.varName + "</mark><br>";
				}else {
					result += "<br>&emsp;&emsp;jackieReturns " + mt.varName + "<br>";

				}
				
				result += "&emsp;!<br><br>";
				//				for(MethodCall v: ((MyReturnMethod)mm.methodType).method_body.methodCall) {
				//					if(v instanceof VoidMethodCall) {
				//						if(((VoidMethodCall)v).)
				//					}
				//				}

			}else if(mm.methodType instanceof MyVoidMethod) {
				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
				String para = ""; int i = 0;
				for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
					para += p1.getValue()+ " " + p1.getKey();
					if(i < mt.parameter.getParams().size()-1) {
						para+= ", ";
					}
					i++;
				}
				result += "&emsp;mymethod " + mm.methodName + " " + mt.voidType + " [ " + para + " ] !<br>";
				
				for(Declaration d: ((MyVoidMethod)mm.methodType).method_body.declList) {
					if(d.covered) {
						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+d.toString()+"</mark><br>");
					}else {
						result+=("&emsp;&emsp;"+d.toString() + "<br>");
					}
				}
				for(Assignment a: ((MyVoidMethod)mm.methodType).method_body.assiList) {
					if(a.covered) {
						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+a.toString()+"</mark><br>");
					}else {
						result+=("&emsp;&emsp;"+a.toString()+ "<br>");
					}
				}
				for(IfStatement i1 : ((MyVoidMethod)mm.methodType).method_body.ifStatList) {
					if(i1.ifCovered == true) {
						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
						result +="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.ifBody.toString()+"</mark><br>";
						result += "&emsp;&emsp;! elseJackie !<br>";
						result += "&emsp;&emsp;&emsp;" + i1.elseBody.toString() + "<br>";
					}else if(i1.elseCovered == true) {
						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
						result += "&emsp;&emsp;! elseJackie !<br>";
						result+="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.elseBody.toString()+"</mark><br>";
					}else {
						result+="<br>&emsp;&emsp;jackieAsks [ " + i1.cond.toString() + " ] !<br>";
						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
						result += "&emsp;&emsp;! elseJackie !<br>";
						result += "&emsp;&emsp;&emsp;" +i1.elseBody.toString()+ "<br>";

					}
					result += "&emsp;&emsp;!<br>";
				}
				
				
				result += "&emsp;!<br><br>";
			}
		}
		result += "!<br>";


		return result; 
	}

}
