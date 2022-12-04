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

public class Original {

	private ArrayList<Program> programList;

	public Original(ArrayList<Program> programList) {
		this.programList = programList;
	}

	public String getString() {
		String result = "";
		Program p = programList.get(0);

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
				result += "&emsp;mymethod " + mm.methodName + " " + mt.dataType + " [" + para + "] !<br>";

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
				result += "&emsp;mymethod " + mm.methodName + " " + mt.voidType + " [" + para + "] !<br>";

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
			result+=(space + d.toString() + "<br>");
		}
		
		if(mm.declList.size()>0 && mm.assiList.size()>0) {
			result += "<br>";
		}
		
		for(Assignment a: mm.assiList) {
			result+=(space + a.toString()+ "<br>");
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
			result += getMethodBodyString(lo.loopbody, space);
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
}
