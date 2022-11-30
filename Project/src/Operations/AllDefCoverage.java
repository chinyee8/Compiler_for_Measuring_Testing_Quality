package Operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Assignment;
import model.Declaration;
import model.IfStatement;
import model.Loop;
import model.MethodCall;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Program;
import model.VoidMethodCall;

public class AllDefCoverage {
	private Map<Integer, List<Integer>> defLines;
	private Map<Integer, List<Integer>> useLines;
	private Map<Integer, List<String>> lines;
	private Map<Integer, Integer> percentage;
	private ArrayList<Program> defProgram;

//	public AllDefCoverage(Map<Integer, List<Integer>> defLines, Map<Integer, List<Integer>> useLines,
//			Map<Integer, List<String>> lines, Map<Integer, Integer> percentage) {
//		this.defLines = defLines;
//		this.useLines = useLines;
//		this.lines = lines;
//		this.percentage = percentage;
//	}
	
	public AllDefCoverage(ArrayList<Program> defProgram) {
		this.defProgram = defProgram;
	}

	public String getString(int testnum) {
		String result = "";
		Program p = defProgram.get(testnum);

		result += "game " + p.gameclass.className + " !<br><br>";

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

				result += "<br>";
				
				result += getMethodBodyString(mt.method_body, "&emsp;");
				
				result += "<br>";

				result += "&emsp;&emsp;jackieReturns " + mt.varName + "<br>";
				result += "&emsp;!<br>";

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

				result += "<br>";
				
				result += getMethodBodyString(mt.method_body, "&emsp;");
				
				result += "<br>";

				result += "&emsp;!<br>";
			}
		}
		result += "!<br>";


		return result; 
	}

	public String getMethodBodyString(MyMethodBody mm, String space) {
		String result = "";
		space = space + "&emsp;&emsp;";
		
		for(Declaration d: mm.declList) {
			result += space + d.toString() + "<br>";
		}
		
		if(mm.declList.size()>0 && mm.assiList.size()>0) {
			result += "<br>";
		}
		
		for(Assignment a: mm.assiList) {
			result += space + a.toString()+ "<br>";
		}
		
		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
			result += "<br>";
		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
			result += "<br>";
		}
		
		for(IfStatement i1 : mm.ifStatList) {
			
			result += space + "jackieAsks [ " + i1.cond.toString() + " ] !<br>";
			result += getMethodBodyString( i1.ifBody, space);
			result += space + "! elseJackie !<br>";
			result += getMethodBodyString(i1.elseBody, space);
			result += space + "!<br>";
		}
		
		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space + "loop (" + lo.iterationGoal + ") !<br>";
			result += getMethodBodyString(lo.myMethodBodyList.get(0), space);
			result += space + "!<br>";
		}

		if(mm.methodCall.size()>0) {
			result += "<br>";
		}
		
		for(MethodCall v: mm.methodCall) {
			if(v instanceof VoidMethodCall) {
				
				String params = ""; int i = 0; 
				for(String p: ((VoidMethodCall)v).call_parameter.getCallParams()) {
					params += p;
					
					if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
						params += ", ";
					}
					i++;
				}
				
				result += space + ((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [" + params + "]<br>";
			}
		}

		return result;
	}

//	public String getString(int testnum) { //testnum 0->infinity
//		String result = "";
//		List<String> modifiedLines = new LinkedList<>();
//		List<Integer> use = new ArrayList<>();
//		use.addAll(this.useLines.get(testnum));
//		
//		for(Integer i : defLines.get(testnum)) {
//			if(this.useLines.get(testnum).contains(i)) {
//				use.remove(i);
//			}
//		}
//		
//		Integer i = 0;
//		for(String s : lines.get(testnum)) {
//			if(defLines.get(testnum).contains(i)) {
//				modifiedLines.add("<mark style=\"background-color: #C2DFFF;\">"+s+"</mark>\n");
//			}else if(use.contains(i)) {
//				modifiedLines.add("<mark style=\"background-color: yellow;\">"+s+"</mark>\n");
//			}else {
//				modifiedLines.add(s + "\n");
//			}
//			i++;
//		}
//		
//		for(String s: modifiedLines) {
//			result += s  + "<br>";
//		}
//		
////		result+= "<div style=\"font-size:2rem; border-bottom:1px solid red; position:relative;\">";
//		result+= "<br><mark style=\"background-color: red;\">"  + percentage.get(testnum) + "% </mark>\n";
//			
//		
//		return result;
//	}

}
