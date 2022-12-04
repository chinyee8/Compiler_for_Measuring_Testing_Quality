package Operations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Assignment;
import model.Declaration;
import model.Expr;
import model.IfStatement;
import model.Loop;
import model.MethodCall;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Program;
import model.ReturnMethodCall;
import model.VoidMethodCall;

public class Statement {
	private Map<Program, MethodCall> programList;
	private List<String> returnMethodCall;
	private List<String> voidMethodCall;
	public Map<Integer, String> resultString;
	public Map<Integer, List<String>> statementcoverage;
	public Map<Integer, List<String>> javascript;
	public Map<Integer, List<String>> css;
	public int countLine;
	public int totalLine;
	public Map<Integer, Integer> percent;

	public Statement(Map<Program, MethodCall> programList2) {
		this.programList = programList2;
		this.returnMethodCall = new ArrayList<>();
		this.voidMethodCall = new ArrayList<>();
		this.resultString = new LinkedHashMap<>();
		this.statementcoverage = new LinkedHashMap<>();
		this.javascript = new LinkedHashMap<>();
		this.css = new LinkedHashMap<>();
		this.percent = new LinkedHashMap<>();
		this.countLine = 0;
		this.totalLine = 0;
	}

	public void getString() {
		int i = 0;
		for(Map.Entry<Program, MethodCall> prog : programList.entrySet()) {
			Program p = prog.getKey();
			MethodCall methodcall = prog.getValue();
			String result = "";
			this.countLine = 0;
			this.totalLine = 0;
			
			result += "game " + p.gameclass.className + " !<br><br>";

			List<String> mc = new ArrayList<>();
			mc.add(methodcall.getName());
			for(String s: getMethodCallFromThis(p, methodcall.getName(), mc)) {
				if(!mc.contains(s)) {
					mc.add(s);
				}
			}
			List<String> current = new ArrayList<>();
			current.addAll(mc);
			for(String s : current) {
				for(String s2:getMethodCallFromThis(p, s, mc)) {
					if(!mc.contains(s2)) {
						mc.add(s2);
					}
				}
			}

			while(mc.size() != current.size()) {
				for(String s: mc) {
					if(!current.contains(s)) {
						current.add(s);
					}
				}
				for(String s : current) {
					for(String s2:getMethodCallFromThis(p, s, mc)) {
						if(!mc.contains(s2)) {
							mc.add(s2);
						}
					}
				}
			}
			
			for(MyMethods mm : p.gameclass.body.myMethodList) {

				if( mm.methodType instanceof MyReturnMethod) {
					MyReturnMethod mt = ((MyReturnMethod)mm.methodType);

					String para = ""; int num = 0;
					for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
						para += p1.getValue()+ " " + p1.getKey();
						if(num < mt.parameter.getParams().size()-1) {
							para+= ", ";
						}
						num++;
					}
					result += "&emsp;mymethod " + mm.methodName + " " + mt.dataType + " [" + para + "] !<br>";

					result += "<br>";
					this.totalLine ++;
					if((methodcall instanceof ReturnMethodCall && ((ReturnMethodCall)methodcall).methodName.equals(mm.methodName)) || mc.contains(mm.methodName) ) {
						result += Covered(mt.method_body, "&emsp;");
						getNumCoveredLine(mt.method_body, true);

						result += "<br>";
						this.countLine++;
						result += "&emsp;&emsp;" + "<mark style=\"background-color: yellow;\">" + "jackieReturns " + mt.varName + "</mark>" + "<br>";
						result += "&emsp;!<br>";

					}else {
						result += NotCovered(mt.method_body, "&emsp;");
						getNumCoveredLine(mt.method_body, false);
						result += "<br>";

						result += "&emsp;&emsp;"+ "jackieReturns " + mt.varName  + "<br>";
						result += "&emsp;!<br>";
					}

				}else if(mm.methodType instanceof MyVoidMethod) {

					MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
					String para = ""; int num = 0;
					for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
						para += p1.getValue()+ " " + p1.getKey();
						if(num < mt.parameter.getParams().size()-1) {
							para+= ", ";
						}
						num++;
					}
					result += "&emsp;mymethod " + mm.methodName + " " + mt.voidType + " [" + para + "] !<br>";

					result += "<br>";

					if((methodcall instanceof VoidMethodCall && ((VoidMethodCall)methodcall).methodname.equals(mm.methodName)) || mc.contains(mm.methodName) ) {
						result += Covered(mt.method_body, "&emsp;");

					}else {
						result += NotCovered(mt.method_body, "&emsp;");
					}

					result += "<br>";

					result += "&emsp;!<br>";
				}

			}
			result += "!<br>";


			this.resultString.put(i, result);

			List<String> list = new LinkedList<>();
			List<String> tempJS = new ArrayList<>();
			List<String> tmpcss = new ArrayList<>();

			int percentagenum = ((int)((countLine / (double) totalLine)*100));
			String percentage = "<h3>Percentage => "+percentagenum + "%</h3>";
			String note = "<div class=\"note\"><u>Note:</u> " + "<br><mark style=\"background-color: yellow;\"> &emsp; </mark> &emsp;statement coverage" + "</div>";
			for(String s: mc) {
				list.add("<div id=\""+s+"sans\" hidden>"
						+ "<div class=\""+s+"scolumn\">"
						+ this.resultString.get(i)
						+ "</div>"					
						+"<div class=\""+s+"scolumn\">" + "<br><h3><mark style=\"background-color: orange;\"> &emsp;&larr;&emsp; </mark> &emsp;Click method call for coverage</h3>"  + "<div id=\"statementpercentagenote\"><div id=\"statementpercentagenotecolumn\">" +percentage +  "</div><div id=\"statementpercentagenotecolumn\"><br>" + note +"</div></div>" + "<br>"
						+"<div id=\"statementcov\">"
						+ this.getCoverage(p, methodcall, s)
						+"</div>"
						+"</div>"
						+"</div>");

				tempJS.add("function statementmc"+ s +"(){\n"
						+ "document.getElementById(\"text\").innerHTML = document.getElementById(\""+s+"sans\").innerHTML;\n"
						+ "}");

				tmpcss.add("."+s+"scolumn{\n"
						+ "    float:left;\n"
						+ "    width:50%;\n"
						+ "}\n"
						+ "\n"
						+ "#"+s+"sans:after{\n"
						+ "    content : \"\";\n"
						+ "    display: table;\n"
						+ "    clear: both;\n"
						+ "}");
			}



			this.statementcoverage.put(i, list);
			this.javascript.put(i, tempJS); 
			this.css.put(i, tmpcss); 
			this.percent.put(i, percentagenum);

			this.returnMethodCall = new ArrayList<>();
			this.voidMethodCall = new ArrayList<>();

			i++;
		}

	}

	private void getNumCoveredLine(MyMethodBody mm, boolean b) {

		for(Declaration d: mm.declList) {
			this.totalLine++;
			if(b) {
				this.countLine++;
			}
		}

		for(Assignment a: mm.assiList) {
			this.totalLine++;
			if(b) {
				this.countLine++;
			}
		}

		for(IfStatement i1 : mm.ifStatList) {
			this.totalLine++;
			if(i1.CondEvaluatedTo) {
				getNumCoveredLine(i1.ifBody, true);
				getNumCoveredLine(i1.elseBody, false);
			}else{
				getNumCoveredLine(i1.ifBody, false);
				getNumCoveredLine(i1.elseBody, true);
			}
		}

		for(Loop lo : mm.loops) {
			this.totalLine++;
			for(int i = 0; i < lo.iterationGoal; i++) {
				getNumCoveredLine(lo.loopbody, true);
			}
		}

		for(MethodCall v: mm.methodCall) {
			if(v instanceof VoidMethodCall) {
				this.totalLine++;
				if(b) {
					this.countLine++;
				}
			}
		}
		
	}

	private String getCoverage(Program p, MethodCall methodcall, String currentmc) {
		String result = "";

		List<String> mc = new ArrayList<>();
		mc.add(currentmc);
		for(String s: getMethodCallFromThis(p, currentmc, mc)) {
			if(!mc.contains(s)) {
				mc.add(s);
			}
		}
		List<String> current = new ArrayList<>();
		current.addAll(mc);
		for(String s : current) {
			for(String s2:getMethodCallFromThis(p, s, mc)) {
				if(!mc.contains(s2)) {
					mc.add(s2);
				}
			}
		}

		while(mc.size() != current.size()) {
			for(String s: mc) {
				if(!current.contains(s)) {
					current.add(s);
				}
			}
			for(String s : current) {
				for(String s2:getMethodCallFromThis(p, s, mc)) {
					if(!mc.contains(s2)) {
						mc.add(s2);
					}
				}
			}
		}


		for(MyMethods mm : p.gameclass.body.myMethodList) {

			if( mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
				if(mc.contains(mm.methodName) ) {
					String para = ""; int num = 0;
					for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
						para += p1.getValue()+ " " + p1.getKey();
						if(num < mt.parameter.getParams().size()-1) {
							para+= ", ";
						}
						num++;
					}
					result += "&emsp;mymethod " + mm.methodName + " " + mt.dataType + " [" + para + "] !<br>";

					result += "<br>";


					result += CoveredCoverage(mt.method_body, "&emsp;");
					result += "<br>";

					result += "&emsp;&emsp;" + "<mark style=\"background-color: yellow;\">" + "jackieReturns " + mt.varName + "</mark>" + "<br>";
					result += "&emsp;!<br>";

				}

			}else if(mm.methodType instanceof MyVoidMethod) {

				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
				if(mc.contains(mm.methodName)  ) {

					String para = ""; int num = 0;
					for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
						para += p1.getValue()+ " " + p1.getKey();
						if(num < mt.parameter.getParams().size()-1) {
							para+= ", ";
						}
						num++;
					}
					result += "&emsp;mymethod " + mm.methodName + " " + mt.voidType + " [" + para + "] !<br>";

					result += "<br>";

					result += Covered(mt.method_body, "&emsp;");

				}

				result += "<br>";

				result += "&emsp;!<br>";
			}

		}

		return result;
	}

	private List<String> getMethodCallFromThis(Program p, String methodcall, List<String> list) {
		for(MyMethods mm : p.gameclass.body.myMethodList) {
			if( mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
				if(mm.methodName.equals(methodcall) ) {
					list = getMethodCallFromThisMethod(mt.method_body ,list);
				}

			}else if(mm.methodType instanceof MyVoidMethod) {

				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
				if(mm.methodName.equals(methodcall) ) {
					list = getMethodCallFromThisMethod(mt.method_body ,list);
				}

			}
		}

		return list;
	}

	private List<String> getMethodCallFromThisMethod(MyMethodBody mb, List<String> list) {
		for(Assignment a: mb.assiList) {
			if(a.expr instanceof ReturnMethodCall) {
				if(!list.contains(((ReturnMethodCall)a.expr).methodName)) {
					list.add(((ReturnMethodCall)a.expr).methodName);
				}
			}
		}

		for(IfStatement i1 : mb.ifStatList) {
			if(i1.CondEvaluatedTo) {
				for(String s: getMethodCallFromThisMethod( i1.ifBody, list)) {
					if(!list.contains(s)) {
						list.add(s);
					}
				}
			}else {
				for(String s: getMethodCallFromThisMethod( i1.elseBody, list)) {
					if(!list.contains(s)) {
						list.add(s);
					}
				}
			}
		}

		for(Loop lo : mb.loops) {
			if(lo.iterationGoal != 0) {
				for(String s: getMethodCallFromThisMethod( lo.loopbody, list)) {
					if(!list.contains(s)) {
						list.add(s);
					}
				}
			}
		}

		for(MethodCall v: mb.methodCall) {
			if(v instanceof VoidMethodCall) {
				if(!list.contains(((VoidMethodCall)v).methodname)) {
					list.add(((VoidMethodCall)v).methodname);
				}
			}
		}

		return list;
	}

	public String Covered(MyMethodBody mm, String space) {
		String result = "";
		space = space + "&emsp;&emsp;";

		for(Declaration d: mm.declList) {
			result+=(space + "<mark style=\"background-color: yellow;\">" + d.toString() + "</mark>" + "<br>");

		}

		if(mm.declList.size()>0 && mm.assiList.size()>0) {
			result += "<br>";
		}

		for(Assignment a: mm.assiList) {

			if(a.expr instanceof ReturnMethodCall) {
				result += space + "<mark style=\"background-color: yellow;\">" + a.varName + " <- " + "</mark>" + "<mark class=\"statementmc\" id=\"statementmc" + ((ReturnMethodCall)((Expr)a.expr)).methodName + "\" onclick=\"statementmc"+ ((ReturnMethodCall)((Expr)a.expr)).methodName  +"()\">" + a.expr + "</mark>" + "<br>";
			}else {
				result += space + "<mark style=\"background-color: yellow;\">" + a.toString()+ "</mark>" +"<br>";
			}
		}

		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
			result += "<br>";
		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
			result += "<br>";
		}

		for(IfStatement i1 : mm.ifStatList) {
			result += space +"<mark style=\"background-color: yellow;\">" +"jackieAsks [ " + i1.cond.toString() + " ] !" +"</mark>" +"<br>";

			if(i1.CondEvaluatedTo) {
				result += Covered( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += NotCovered(i1.elseBody, space);
			}else{
				result += NotCovered( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += Covered(i1.elseBody, space);
			}

			result += space + "!<br>";
		}

		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space  + "<mark style=\"background-color: yellow;\">" + "loop (" + lo.iterationGoal + ") !"  +"</mark>"+ "<br>";
			if(lo.iterationGoal == 0) {
				result += NotCovered(lo.loopbody, space);
			}else {
				result += Covered(lo.loopbody, space);
			}
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

				result += space + "<mark class=\"statementmc\" id=\"statementmc" + v.getName() + "\" onclick=\"statementmc"+ v.getName() +"()\">" + ((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [" + params + "]" + "</mark>" + "<br>";
			}
		}

		return result;
	}

	public String CoveredCoverage(MyMethodBody mm, String space) {
		String result = "";
		space = space + "&emsp;&emsp;";

		for(Declaration d: mm.declList) {
			result+=space + "<mark style=\"background-color: yellow;\">" + d.toString() + "</mark>" + "<br>";

		}

		if(mm.declList.size()>0 && mm.assiList.size()>0) {
			result += "<br>";
		}

		for(Assignment a: mm.assiList) {
			result += space + "<mark style=\"background-color: yellow;\">" + a.toString()+ "</mark>" + "<br>";

		}

		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
			result += "<br>";
		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
			result += "<br>";
		}

		for(IfStatement i1 : mm.ifStatList) {
			result += space  +"<mark style=\"background-color: yellow;\">" +"jackieAsks [ " + i1.cond.toString() + " ] !" + "</mark>" + "<br>";

			if(i1.CondEvaluatedTo) {
				result += CoveredCoverage( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += NotCovered(i1.elseBody, space);
			}else {
				result += NotCovered( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += CoveredCoverage(i1.elseBody, space);
			}

			result += space + "!<br>";
		}

		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space  +"<mark style=\"background-color: yellow;\">"+ "loop (" + lo.iterationGoal + ") !"  +"</mark>"+ "<br>";
			if(lo.iterationGoal == 0) {
				result += NotCovered(lo.loopbody, space);
			}else {
				result += CoveredCoverage(lo.loopbody, space);
			}
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
			result += NotCovered(lo.loopbody, space);
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


//	private void checkMethodCall(List<MyMethods> l, MethodCall methodcall) {
//		for(MyMethods mm : l) {
//			if( mm.methodType instanceof MyReturnMethod) {
//				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
//				if(methodcall instanceof ReturnMethodCall && ((ReturnMethodCall)methodcall).methodName.equals(mm.methodName) ) {
//					this.returnMethodCall.add(methodcall.getName());
//					getTestMethodCall( mt.method_body);
//				}
//
//			}else if(mm.methodType instanceof MyVoidMethod) {
//				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
//				if(methodcall instanceof ReturnMethodCall && ((ReturnMethodCall)methodcall).methodName.equals(mm.methodName) ) {
//					this.voidMethodCall.add(methodcall.getName());
//					getTestMethodCall( mt.method_body);
//				}
//			}
//		}	
//
//		checkAllMethodCall(l, methodcall);
//	}
//
//	private void checkAllMethodCall(List<MyMethods> l, MethodCall methodcall) {
//		for(MyMethods mm : l) {
//			if( mm.methodType instanceof MyReturnMethod) {
//				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
//				if(this.returnMethodCall.size()>0 && this.returnMethodCall.contains(mm.methodName)) {
//					getTestMethodCall(mt.method_body);
//				}
//
//			}else if(mm.methodType instanceof MyVoidMethod) {
//				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
//				if(this.voidMethodCall.size()>0 && this.voidMethodCall.contains(mm.methodName)) {
//					getTestMethodCall(mt.method_body);
//				}
//			}
//		}		
//	}

	private void getTestMethodCall( MyMethodBody mb) {

		for(Assignment a: mb.assiList) {
			if(a.expr instanceof ReturnMethodCall) {
				if(!this.returnMethodCall.contains(((ReturnMethodCall)a.expr).methodName)){
					this.returnMethodCall.add(((ReturnMethodCall)a.expr).methodName);
				}
			}
		}

		for(IfStatement i1 : mb.ifStatList) {
			if(i1.CondEvaluatedTo) {
				getTestMethodCall( i1.ifBody);
			}else {
				getTestMethodCall( i1.elseBody);
			}
		}

		for(Loop lo : mb.loops) {
			if(lo.iterationGoal != 0) {
				getTestMethodCall( lo.loopbody);
			}
		}

		for(MethodCall v: mb.methodCall) {
			if(v instanceof VoidMethodCall) {
				if(!this.voidMethodCall.contains(((VoidMethodCall)v).methodname)) {
					this.voidMethodCall.add(((VoidMethodCall)v).methodname);
				}
			}
		}
	}
}
