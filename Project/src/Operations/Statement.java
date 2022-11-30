package Operations;

import java.util.ArrayList;
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

public class Statement {
	private ArrayList<Program> programList;

	public Statement(ArrayList<Program> programList) {
		this.programList = programList;
	}

	public String getString(int testnum) {
		String result = "";
		Program p = programList.get(testnum);

		result += "game " + p.gameclass.className + " !<br><br>";

		//		<mark style=\"background-color: #C2DFFF;\">" +  + "</mark>

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

				result += Covered(mt.method_body, "&emsp;");

				result += "<br>";

				result += "&emsp;&emsp;"+ "<mark style=\"background-color: yellow;\">" + "jackieReturns " + mt.varName + "</mark>" + "<br>";
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

				result += Covered(mt.method_body, "&emsp;");

				result += "<br>";

				result += "&emsp;!<br>";
			}
		}
		result += "!<br>";


		return result; 
	}

	public String Covered(MyMethodBody mm, String space) {
		String result = "";
		space = space + "&emsp;&emsp;";

		for(Declaration d: mm.declList) {
			if(d.covered) {
				result+=(space + "<mark style=\"background-color: yellow;\">" + d.toString() + "</mark>" + "<br>");
			}else {
				result+=(space + d.toString() + "<br>");
			}

		}

		if(mm.declList.size()>0 && mm.assiList.size()>0) {
			result += "<br>";
		}

		for(Assignment a: mm.assiList) {
			if(a.covered) {
				result += space + "<mark style=\"background-color: yellow;\">" + a.toString() + "</mark>" + "<br>";
			}else {
				result += space + a.toString()+ "<br>";

			}
		}

		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
			result += "<br>";
		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
			result += "<br>";
		}

		for(IfStatement i1 : mm.ifStatList) {
			result += space +  "<mark style=\"background-color: yellow;\">" +"jackieAsks [ " + i1.cond.toString() + " ] !" + "</mark>" + "<br>";

			if(i1.ifCovered) {
				result += Covered( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += NotCovered(i1.elseBody, space);
			}else if(i1.elseCovered) {
				result += NotCovered( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += Covered(i1.elseBody, space);
			}else {
				result += NotCovered( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += NotCovered(i1.elseBody, space);
			}
			
			result += space + "!<br>";
		}

		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space + "<mark style=\"background-color: yellow;\">" + "loop (" + lo.iterationGoal + ") !" + "</mark>" + "<br>";
			result += Covered(lo.myMethodBodyList.get(0), space);
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

				result += space + "<mark style=\"background-color: yellow;\">" + ((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [" + params + "]" + "</mark>" + "<br>";
			}
		}

		return result;
	}
	
	public String NotCovered(MyMethodBody mm, String space) {
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
			result += NotCovered( i1.ifBody, space);
			result += space + "! elseJackie !<br>";
			result += NotCovered(i1.elseBody, space);
			result += space + "!<br>";
		}
		
		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space + "loop (" + lo.iterationGoal + ") !<br>";
			result += NotCovered(lo.myMethodBodyList.get(0), space);
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

	//	public String getString(int testnum) {
	//		String result = "";
	//		Program p = programList.get(testnum);
	//
	//		result += "game " + p.gameclass.className + " !<br><br>";
	//
	//		for(MyMethods mm : p.gameclass.body.myMethodList) {
	//			if( mm.methodType instanceof MyReturnMethod) {
	//				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
	//				String para = ""; int i = 0;
	//				for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
	//					para += p1.getValue()+ " " + p1.getKey();
	//					if(i < mt.parameter.getParams().size()-1) {
	//						para+= ", ";
	//					}
	//					i++;
	//				}
	//				result += "&emsp;mymethod " + mm.methodName + " " + mt.dataType + " [ " + para + " ] !<br>";
	//				
	//				for(Declaration d: ((MyReturnMethod)mm.methodType).method_body.declList) {
	//					if(d.covered) {
	//						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+d.toString()+"</mark><br>");
	//					}else {
	//						result+=("&emsp;&emsp;"+d.toString() + "<br>");
	//					}
	//				}
	//				for(Assignment a: ((MyReturnMethod)mm.methodType).method_body.assiList) {
	//					if(a.covered) {
	//						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+a.toString()+"</mark><br>");
	//					}else {
	//						result+=("&emsp;&emsp;"+a.toString()+ "<br>");
	//					}
	//				}
	//				for(IfStatement i1 : ((MyReturnMethod)mm.methodType).method_body.ifStatList) {
	//					if(i1.ifCovered == true) {
	//						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
	//						result +="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.ifBody.toString()+"</mark><br>";
	//						result += "&emsp;&emsp;! elseJackie !<br>";
	//						result += "&emsp;&emsp;&emsp;" + i1.elseBody.toString() + "<br>";
	//					}else if(i1.elseCovered == true) {
	//						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
	//						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
	//						result += "&emsp;&emsp;! elseJackie !<br>";
	//						result+="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.elseBody.toString()+"</mark><br>";
	//					}else {
	//						result+="<br>&emsp;&emsp;jackieAsks [ " + i1.cond.toString() + " ] !<br>";
	//						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
	//						result += "&emsp;&emsp;! elseJackie !<br>";
	//						result += "&emsp;&emsp;&emsp;" +i1.elseBody.toString()+ "<br>";
	//
	//					}
	//					result += "&emsp;&emsp;!<br>";
	//				}
	//				
	//				//change later for jackieReturns by input in the true section
	//				if(true) {
	//					result += "<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieReturns " + mt.varName + "</mark><br>";
	//				}else {
	//					result += "<br>&emsp;&emsp;jackieReturns " + mt.varName + "<br>";
	//
	//				}
	//				
	//				result += "&emsp;!<br><br>";
	//				//				for(MethodCall v: ((MyReturnMethod)mm.methodType).method_body.methodCall) {
	//				//					if(v instanceof VoidMethodCall) {
	//				//						if(((VoidMethodCall)v).)
	//				//					}
	//				//				}
	//
	//			}else if(mm.methodType instanceof MyVoidMethod) {
	//				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
	//				String para = ""; int i = 0;
	//				for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
	//					para += p1.getValue()+ " " + p1.getKey();
	//					if(i < mt.parameter.getParams().size()-1) {
	//						para+= ", ";
	//					}
	//					i++;
	//				}
	//				result += "&emsp;mymethod " + mm.methodName + " " + mt.voidType + " [ " + para + " ] !<br>";
	//				
	//				for(Declaration d: ((MyVoidMethod)mm.methodType).method_body.declList) {
	//					if(d.covered) {
	//						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+d.toString()+"</mark><br>");
	//					}else {
	//						result+=("&emsp;&emsp;"+d.toString() + "<br>");
	//					}
	//				}
	//				for(Assignment a: ((MyVoidMethod)mm.methodType).method_body.assiList) {
	//					if(a.covered) {
	//						result+=("&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+a.toString()+"</mark><br>");
	//					}else {
	//						result+=("&emsp;&emsp;"+a.toString()+ "<br>");
	//					}
	//				}
	//				for(IfStatement i1 : ((MyVoidMethod)mm.methodType).method_body.ifStatList) {
	//					if(i1.ifCovered == true) {
	//						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
	//						result +="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.ifBody.toString()+"</mark><br>";
	//						result += "&emsp;&emsp;! elseJackie !<br>";
	//						result += "&emsp;&emsp;&emsp;" + i1.elseBody.toString() + "<br>";
	//					}else if(i1.elseCovered == true) {
	//						result+="<br>&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">jackieAsks [ " + i1.cond.toString() + " ] !</mark><br>";
	//						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
	//						result += "&emsp;&emsp;! elseJackie !<br>";
	//						result+="&emsp;&emsp;&emsp;<mark style=\"background-color: #C2DFFF;\">"+i1.elseBody.toString()+"</mark><br>";
	//					}else {
	//						result+="<br>&emsp;&emsp;jackieAsks [ " + i1.cond.toString() + " ] !<br>";
	//						result += "&emsp;&emsp;&emsp;" +i1.ifBody.toString()+ "<br>";
	//						result += "&emsp;&emsp;! elseJackie !<br>";
	//						result += "&emsp;&emsp;&emsp;" +i1.elseBody.toString()+ "<br>";
	//
	//					}
	//					result += "&emsp;&emsp;!<br>";
	//				}
	//				
	//				
	//				result += "&emsp;!<br><br>";
	//			}
	//		}
	//		result += "!<br>";
	//
	//
	//		return result; 
	//	}

}
