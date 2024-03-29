package Operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Addition;
import model.Assignment;
import model.CallParamBoolean;
import model.CallParamChar;
import model.CallParamDouble;
import model.CallParamNum;
import model.CallParamString;
import model.CallParamVarName;
import model.CondBool;
import model.CondEqual;
import model.CondNotEqual;
import model.CondParenthesis;
import model.CondVarName;
import model.Condition;
import model.Conjunction;
import model.Declaration;
import model.Disjunction;
import model.Division;
import model.EqualTo;
import model.IfStatement;
import model.Input_List;
import model.Less;
import model.LessOrEqual;
import model.Loop;
import model.MathDouble;
import model.MathNumber;
import model.MathParenthesis;
import model.MathVarName;
import model.Mathematics;
import model.MethodCall;
import model.More;
import model.MoreOrEqual;
import model.Multiplication;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Negation;
import model.NotEqualTo;
import model.Parameter;
import model.Program;
import model.ReturnMethodCall;
import model.Subtraction;
import model.ValueBool;
import model.ValueChar;
import model.ValueDouble;
import model.ValueMath;
import model.ValueNum;
import model.ValueString;
import model.Values;
import model.VoidMethodCall;

public class AllDefCoverage {
	private Map<Program, MethodCall> defProgram;
	private List<String> def;
	private List<String> totaldef;
	private List<String> use;
	private int countDef;
	private int countUse;
	private int countDefTotal;
	private int countUseTotal;
	private List<String> returnMethodCall;
	private List<String> voidMethodCall;
	public Map<Integer, String> resultString;
	public Map<Integer,List<String>> different;
	public Map<Integer, List<String>> javascript;
	public Map<Integer, List<String>> css;
	public Map<Integer, List<String>> lines;
	private  List<List<MyMethods>> globalReturn;

	public AllDefCoverage(Map<Program, MethodCall> defProgram, List<List<MyMethods>> globalReturn) {
		this.defProgram = defProgram;
		this.countDef = 0;
		this.countUse = 0;
		this.countDefTotal = 0;
		this.countUseTotal = 0;
		this.def = new ArrayList<>();
		this.totaldef = new ArrayList<>();
		this.use = new ArrayList<>();
		this.returnMethodCall = new ArrayList<>();
		this.voidMethodCall = new ArrayList<>();
		this.resultString = new LinkedHashMap<>();
		this.different = new LinkedHashMap<>();
		this.javascript = new LinkedHashMap<>();
		this.css = new LinkedHashMap<>();
		this.lines = new LinkedHashMap<>();
		this.globalReturn = globalReturn;
	}

	public void computeAllDef() {
		getString();
	}

	public void getString() {
		int i = 0;
		for(Map.Entry<Program, MethodCall> prog : defProgram.entrySet()) {
			Program p = prog.getKey();
			MethodCall methodcall = prog.getValue();
			List<MyMethods> globalMyMethods = this.globalReturn.get(i);
			String result = "";
			this.totaldef = new ArrayList<>();
			this.countDefTotal = 0;
			this.countUseTotal = 0;

			result += "game " + p.gameclass.className + " !<br><br>";

			List<String> mc = getListOfMethodCall(globalMyMethods, p, methodcall.getName());


			for(MyMethods mm : globalMyMethods) {
				this.def = new ArrayList<>();
				this.use = new ArrayList<>();
				this.countDef = 0;
				this.countUse = 0;

				if( mm.methodType instanceof MyReturnMethod) {
					MyReturnMethod mt = ((MyReturnMethod)mm.methodType);

					if((methodcall instanceof ReturnMethodCall && ((ReturnMethodCall)methodcall).methodName.equals(mm.methodName)) || mc.contains(mm.methodName) ) {
						getAllVariableReturn(mt, false);
						this.countDefTotal += this.countDef;
						this.countUseTotal += this.countUse;

						result += getNotUnderLinedReturn(mm.methodName, mt);
					}else {
						result += getNotUnderLinedReturn(mm.methodName, mt);
					}

				}else if(mm.methodType instanceof MyVoidMethod) {

					MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
					if((methodcall instanceof VoidMethodCall && ((VoidMethodCall)methodcall).methodname.equals(mm.methodName)) || mc.contains(mm.methodName) ) {
						getAllVariableVoid(mt, false);
						this.countDefTotal += this.countDef;
						this.countUseTotal += this.countUse;

						result += getNotUnderLinedVoid(mm.methodName, mt);
					}else {
						result += getNotUnderLinedVoid(mm.methodName, mt);
					}	  
				}

				for(String s : def) {
					if(!totaldef.contains(s)) {
						totaldef.add(s);
					}
				}
			}
			result += "!<br>";


			this.resultString.put(i, result);

			//////////////////////////////////////////
			List<String> tempdiff = new ArrayList<>();
			List<String> tempJS = new ArrayList<>();
			List<String> tmpcss = new ArrayList<>();

			//list of variable
			List<String> tmp = new LinkedList<>();
			int percent = 0;
			if(countDefTotal < countUseTotal) {
				percent = 100;
			}else {
				percent = ((int)((countUseTotal / (double) countDefTotal)*100));
			}
			tmp.add("<h3>Percentage = "+ percent + "%</h3>");			
			tmp.add("<ul>");
			for(String s: totaldef) {
				tmp.add("<li id=\"" + s + "\" onclick=\"" + s + "()\"><p class=\"varList\">" + s + "</p></li>");
			}
			tmp.add("</ul>");
			this.lines.put(i, tmp);


			String tmpString = "";
			for(String s: this.lines.get(i)) {
				tmpString += s + "\n";
			}
			String note = "<br><br><br><br><div class=\"note\"><u>Note:</u> " + "<br><mark style=\"background-color: green;\"> &emsp; </mark> &emsp;green => def" + "<br><mark style=\"background-color: yellow;\"> &emsp; </mark> &emsp;yellow => c-use" + "<br><mark style=\"background-color: #7B68EE;\"> &emsp; </mark> &emsp;purple => p-use" + "<br><mark style=\"background-color: red;\"> &emsp; </mark> &emsp;red => no c-use or p-use</div>";
			for(String d: totaldef) {
				tempdiff.add("<div id=\"" + d + "ans\" hidden>" 
						+ "<div class=\""+ d +"column\"><u class=\"topic\">All-Defs Coverage</u><br><br>" +getResultString(globalMyMethods, p, methodcall, d) + "<br>" + "</div>"
						+ "<div class=\""+ d +"column\"><h3><u>List of Variables - Click to see coverage:</u></h3>" 
						+ "<div class=\""+ d +"subcolumn\">" + tmpString + "</div>"
						+ "<div class=\""+ d +"subcolumn\">" + "<br>" + note + "</div>"
						+ "</div>"
						+"</div>" );

				tempJS.add("function "+ d +"(){\n"
						+ "document.getElementById(\"text\").innerHTML = document.getElementById(\""+d+"ans\").innerHTML;\n"
						+ "}");

				tmpcss.add("."+d+"subcolumn{\n"
						+ "    float:left;\n"
						+ "    width:50%;\n"
						+ "}\n"
						+ "\n"
						+ "."+d+"column:after{\n"
						+ "    content : \"\";\n"
						+ "    display: table;\n"
						+ "    clear: both;\n"
						+ "}");

				tmpcss.add("."+d+"column{\n"
						+ "    float:left;\n"
						+ "    width:50%;\n"
						+ "}\n"
						+ "\n"
						+ "#"+d+"ans:after{\n"
						+ "    content : \"\";\n"
						+ "    display: table;\n"
						+ "    clear: both;\n"
						+ "}");
			}
			this.different.put(i, tempdiff);
			this.javascript.put(i, tempJS); 
			this.css.put(i, tmpcss); 
			this.returnMethodCall = new ArrayList<>();
			this.voidMethodCall = new ArrayList<>();

			i++;
		}
	}

	private List<String> getListOfMethodCall(List<MyMethods> globalMyMethods, Program p, String name) {
		List<String> mc = new ArrayList<>();
		mc.add(name);
		for(String s: getMethodCallFromThis(globalMyMethods, p, name, mc)) {
			if(!mc.contains(s)) {
				mc.add(s);
			}
		}
		List<String> current = new ArrayList<>();
		current.addAll(mc);
		for(String s : current) {
			for(String s2:getMethodCallFromThis(globalMyMethods, p, s, mc)) {
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
				for(String s2:getMethodCallFromThis(globalMyMethods, p, s, mc)) {
					if(!mc.contains(s2)) {
						mc.add(s2);
					}
				}
			}
		}
		return mc;
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
	//				if((methodcall instanceof VoidMethodCall && ((VoidMethodCall)methodcall).methodname.equals(mm.methodName)) || this.voidMethodCall.contains(mm.methodName) ) {
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

	public String getResultString(List<MyMethods> globalMyMethods, Program p, MethodCall methodcall, String d) {
		String result = "";

		result += "game " + p.gameclass.className + " !<br><br>";

		List<String> mc = getListOfMethodCall(globalMyMethods, p, methodcall.getName());

		int i = 0;
		for(MyMethods mm : globalMyMethods) {

			if( mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);

				if((methodcall instanceof ReturnMethodCall && ((ReturnMethodCall)methodcall).methodName.equals(mm.methodName)) || mc.contains(mm.methodName)) {
					this.def = new ArrayList<>();
					this.use = new ArrayList<>();
					getAllVariableReturn(mt, false);
					result += this.getResult(((MyReturnMethod)mm.methodType), mm.methodName, mt.method_body, mt.parameter, mt.dataType, mt.varName, d);
				}else {
					result += getNotUnderLinedReturn(mm.methodName, mt);
				}

			}else if(mm.methodType instanceof MyVoidMethod) {

				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);

				if((methodcall instanceof VoidMethodCall && ((VoidMethodCall)methodcall).methodname.equals(mm.methodName)) || mc.contains(mm.methodName)) {
					this.def = new ArrayList<>();
					this.use = new ArrayList<>();
					getAllVariableVoid(mt, false);
					result += this.getResultVoid(mm.methodName, mt.method_body, mt.parameter, mt.voidType, d);
				}else {
					result += getNotUnderLinedVoid(mm.methodName, mt);
				}		  
			}
			i++;
		}
		result += "!<br>";


		return result; 
	}



	//	public String getUnderLinedReturn(String methodName, MyReturnMethod mt) {
	//		String result = "";
	//
	//		String para = ""; int i = 0;
	//		for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
	//			if(def.contains(p1.getKey())) {
	//				para += p1.getValue() + " " + "<p id=\"" + p1.getKey() + "\" onclick=\"" + p1.getKey() + "()\"><u>" + p1.getKey() + "</u></p>";
	//			}else {
	//				para += p1.getValue()+ " " + p1.getKey();
	//			}
	//
	//			if(i < mt.parameter.getParams().size()-1) {
	//				para+= ", ";
	//			}
	//			i++;
	//		} 
	//		result += "&emsp;mymethod " + methodName + " " + mt.dataType + " [" + para + "] !<br>";
	//
	//		result += "<br>";
	//
	//		result += getMethodBodyString(mt.method_body, "&emsp;");
	//
	//		result += "<br>";
	//
	//		result += "&emsp;&emsp;jackieReturns " + mt.varName + "<br>";
	//		result += "&emsp;!<br>";
	//
	//		return result;
	//	}


	private String getNotUnderLinedReturn(String methodName, MyReturnMethod mt) {
		String result = "";

		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
			para += p1.getValue()+ " " + p1.getKey();
			if(i < mt.parameter.getParams().size()-1) {
				para+= ", ";
			}
			i++;
		}
		result += "&emsp;mymethod " + methodName + " " + mt.dataType + " [" + para + "] !<br>";

		result += "<br>";

		result += getElseMethodBodyString(mt.method_body, "&emsp;");

		result += "<br>";

		result += "&emsp;&emsp;jackieReturns " + mt.varName + "<br>";
		result += "&emsp;!<br>";

		return result;
	}


	//	private String getUnderLinedVoid(String methodName, MyVoidMethod mt) {
	//		String result = "";
	//
	//
	//		String para = ""; int i = 0;
	//		for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
	//			if(def.contains(p1.getKey())) {
	//				para += p1.getValue() + " " + "<p id=\"" + p1.getKey() + "\" onclick=\"" + p1.getKey() + "()\"><u>" + p1.getKey() + "</u></p>";
	//			}else {
	//				para += p1.getValue()+ " " + p1.getKey();
	//			}
	//
	//			if(i < mt.parameter.getParams().size()-1) {
	//				para+= ", ";
	//			}
	//			i++;
	//		} 
	//
	//
	//		result += "&emsp;mymethod " + methodName + " " + mt.voidType + " [" + para + "] !<br>";
	//
	//		result += "<br>";
	//
	//		result += getMethodBodyString(mt.method_body, "&emsp;");
	//
	//		result += "<br>";
	//
	//		result += "&emsp;!<br>";
	//
	//		return result;	
	//	}

	private String getNotUnderLinedVoid(String methodName, MyVoidMethod mt) {
		String result = "";

		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
			para += p1.getValue()+ " " + p1.getKey();
			if(i < mt.parameter.getParams().size()-1) {
				para+= ", ";
			}
			i++;
		}
		result += "&emsp;mymethod " + methodName + " " + mt.voidType + " [" + para + "] !<br>";

		result += "<br>";

		result += getElseMethodBodyString(mt.method_body, "&emsp;");

		result += "<br>";

		result += "&emsp;!<br>";

		return result;
	}

	//	public String getMethodBodyString(MyMethodBody mm, String space) {
	//		String result = "";
	//		space = space + "&emsp;&emsp;";
	//
	//		for(Declaration d: mm.declList) {
	//			result += space + d.toString() + "<br>";
	//		}
	//
	//		if(mm.declList.size()>0 && mm.assiList.size()>0) {
	//			result += "<br>";
	//		}
	//
	//		for(Assignment a: mm.assiList) {
	//			if(def.contains(a.varName)) {
	//				result += space + "<p id=\"" + a.varName + "\" onclick=\"" + a.varName + "()\"><u>" + a.varName + "</u></p>" + " <- " + a.expr.toString() + "<br>";
	//			}else {
	//				result += space +  a.varName + " <- " + a.expr.toString() + "<br>";
	//			}
	//		}
	//
	//		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
	//			result += "<br>";
	//		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
	//			result += "<br>";
	//		}
	//
	//		for(IfStatement i1 : mm.ifStatList) {
	//			if(i1.CondEvaluatedTo) {
	//				result += space + "jackieAsks [ " + i1.cond.toString() + " ] !<br>";
	//				result += getMethodBodyString( i1.ifBody, space);
	//				result += space + "! elseJackie !<br>";
	//				result += getElseMethodBodyString(i1.elseBody, space);
	//				result += space + "!<br>";
	//			}else {
	//				result += space + "jackieAsks [ " + i1.cond.toString() + " ] !<br>";
	//				result += getElseMethodBodyString( i1.ifBody, space);
	//				result += space + "! elseJackie !<br>";
	//				result += getMethodBodyString(i1.elseBody, space);
	//				result += space + "!<br>";
	//			}
	//
	//
	//		}
	//
	//		if(mm.loops.size()>0) {
	//			result += "<br>";
	//		}
	//
	//		for(Loop lo : mm.loops) {
	//			result += space + "loop (" + lo.iterationGoal + ") !<br>";
	//			if(lo.iterationGoal == 0) {
	//				result += getElseMethodBodyString(lo.body, space);
	//			}else {
	//				result += getMethodBodyString(lo.body, space);
	//			}
	//			result += space + "!<br>";
	//		}
	//
	//		if(mm.methodCall.size()>0) {
	//			result += "<br>";
	//		}
	//
	//		for(MethodCall v: mm.methodCall) {
	//			if(v instanceof VoidMethodCall) {
	//
	//				String params = ""; int i = 0; 
	//				for(String p: ((VoidMethodCall)v).call_parameter.getCallParams()) {
	//					params += p;
	//
	//					if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
	//						params += ", ";
	//					}
	//					i++;
	//				}
	//
	//				result += space + ((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [ " + params + " ]<br>";
	//			}
	//		}
	//
	//		return result;
	//	}

	private String getElseMethodBodyString(MyMethodBody mm, String space) {
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
			result += getElseMethodBodyString( i1.ifBody, space);
			result += space + "! elseJackie !<br>";
			result += getElseMethodBodyString(i1.elseBody, space);
			result += space + "!<br>";
		}

		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space + "loop (" + lo.iterationGoal + ") !<br>";
			result += getElseMethodBodyString(lo.body, space);
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

				result += space + ((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [ " + params + " ]<br>";
			}
		}

		return result;
	}


	private String getResultVoid(String methodName, MyMethodBody method_body, Parameter parameter, String voidType, String d) {
		String result="";
		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 :parameter.getParams().entrySet()) {
			if(d.equals(p1.getKey())) {
				if(use.contains(p1.getKey())) {
					para += p1.getValue() + " " + "<mark style=\"background-color: lime;\">" + p1.getKey() + "</mark>";
				}else {
					para += p1.getValue() + " " + "<mark style=\"background-color: red; color: white;\">" + p1.getKey() + "</mark>";
				}
			}else {
				para += p1.getValue()+ " " + p1.getKey();
			}

			if(i < parameter.getParams().size()-1) {
				para+= ", ";
			}
			i++;
		} 
		result += "&emsp;mymethod " + methodName + " " + voidType + " [" + para + "] !<br>";

		result += "<br>";

		result += getResultBody(method_body, "&emsp;", d);

		result += "<br>";

		result += "&emsp;!<br>";

		return result;
	}

	private String getResult(MyReturnMethod methodType, String methodName, MyMethodBody method_body, Parameter parameter, String dataType, String varName, String d) {
		String result="";
		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 :parameter.getParams().entrySet()) {
			if(d.equals(p1.getKey())) {
				if(use.contains(p1.getKey())) {
					para += p1.getValue() + " " + "<mark style=\"background-color: lime;\">" + p1.getKey() + "</mark>";
				}else {
					para += p1.getValue() + " " + "<mark style=\"background-color: red; color: white;\">" + p1.getKey() + "</mark>";
				}
			}else {
				para += p1.getValue()+ " " + p1.getKey();
			}

			if(i < parameter.getParams().size()-1) {
				para+= ", ";
			}
			i++;
		} 
		result += "&emsp;mymethod " + methodName + " " + dataType + " [" + para + "] !<br>";

		result += "<br>";

		result += getResultBody(method_body, "&emsp;", d);

		result += "<br>";

		if(methodType.jackieReturnCovered) {
			if(d.equals(varName)) {
				result += "&emsp;&emsp;jackieReturns " + "<mark style=\"background-color: yellow;\">" + varName + "</mark><br>";
			}else {
				result += "&emsp;&emsp;jackieReturns " + varName + "<br>";
			}
		}else {
			result += "&emsp;&emsp;jackieReturns " + varName + "<br>";
		}

		result += "&emsp;!<br>";

		return result;
	}

	public String getResultBody(MyMethodBody mm, String space, String d) {
		String result = "";
		space = space + "&emsp;&emsp;";

		List<String> assignmentvar = new ArrayList<>();
		for(Assignment a: mm.assiList) {
			if(a.covered) {
				if(!assignmentvar.contains(a.varName)) {
					assignmentvar.add(a.varName);
				}	
			}
		}

		for(Declaration a: mm.declList) {
			if(a.covered) {
				if(assignmentvar.contains(a.varName)) {
					result += space + a.toString() + "<br>";
				}else {
					if(d.equals(a.varName)){
						if(use.contains(a.varName)) {
							result += space + "<mark style=\"background-color: lime;\">" + a.varName + "</mark>" + " << " + a.dataType + "<br>";
						}else {
							result += space + "<mark style=\"background-color: red; color: white;\">" + a.varName + "</mark>" + " << " + a.dataType  + "<br>";
						}
					}else {
						result += space + a.toString() + "<br>";
					}

				}
			}else {
				result += space + a.toString() + "<br>";

			}

		}

		if(mm.declList.size()>0 && mm.assiList.size()>0) {
			result += "<br>";
		}

		for(Assignment a: mm.assiList) {
			if(a.covered) {
				String expr = "";
				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						expr = getMathString(((ValueMath)((Values)a.expr)).math, d);
					}else{
						expr = ((Values)a.expr).getValues().toString();
					}
				}else if(a.expr instanceof ReturnMethodCall) {
					String para = ""; int i = 0;
					for(Input_List p : ((ReturnMethodCall)a.expr).call_parameter.getTestCallParams()) {
						if(p instanceof CallParamVarName) {
							CallParamVarName a1 = (CallParamVarName) p;
							if(d.equals(a1.varName)) {
								para += "<mark style=\"background-color: yellow;\">" + a1.varName + "</mark>";
							}else {
								para += a1.varName;
							}
						}else if(p instanceof CallParamDouble) {
							CallParamDouble a1 = (CallParamDouble) p;
							para += a1.input;
						}else if(p instanceof CallParamNum) {
							CallParamNum a1 = (CallParamNum) p;
							para += a1.num;
						}else if(p instanceof CallParamChar) {
							CallParamChar a1 = (CallParamChar) p;
							para += a1.input;
						}else if(p instanceof CallParamString) {
							CallParamString a1 = (CallParamString) p;
							para += a1.input;
						}else if(p instanceof CallParamBoolean) {
							CallParamBoolean a1 = (CallParamBoolean) p;
							para += a1.input;
						}

						if(i < ((ReturnMethodCall)a.expr).call_parameter.getTestCallParams().size()-1) {
							para+= ", ";
						}
						i++;
					}
					expr = ((ReturnMethodCall)a.expr).methodName + " [ " + para + " ]";
				}

				if(d.equals(a.varName)) {
					if(use.contains(a.varName)) {
						result += space + "<mark style=\"background-color: lime;\">" + a.varName + "</mark>" + " <- " + expr + "<br>";
					}else {
						result += space + "<mark style=\"background-color: red; color: white;\">" + a.varName + "</mark>" + " <- " + expr + "<br>";
					}
				}else {
					result += space + a.varName + " <- " + expr + "<br>";
				}
			}else {
				result += space + a.toString() + "<br>";

			}

		}

		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
			result += "<br>";
		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
			result += "<br>";
		}

		for(IfStatement i1 : mm.ifStatList) {
			String cond = getCondString(i1.cond, d);
			if(i1.jackieIf) {
				result += space + "jackieAsks [ " + cond + " ] !<br>";
			}else {
				result += space + "jackieAsks [ " + i1.cond.toString() + " ] !<br>";
			}

			if(i1.CondEvaluatedTo) {				
				result += getResultBody( i1.ifBody, space, d);
				result += space + "! elseJackie !<br>";
				result += getResultBody(i1.elseBody, space, d);
				result += space + "!<br>";
			}else {
				result += getResultBody(i1.ifBody, space, d);
				result += space + "! elseJackie !<br>";
				result += getResultBody(i1.elseBody, space, d);
				result += space + "!<br>";
			}


		}

		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space + "loop (" + lo.iterationGoal + ") !<br>";

			result += getResultBody(lo.body, space, d);

			result += space + "!<br>";
		}

		if(mm.methodCall.size()>0) {
			result += "<br>";
		}

		for(MethodCall v: mm.methodCall) {
			if(v instanceof VoidMethodCall) {

				String params = ""; int i = 0; 
				if(((VoidMethodCall)v).covered) {
					for(String p: ((VoidMethodCall)v).call_parameter.getCallParams()) {
						if(d.equals(p)) {
							params += "<mark style=\"background-color: yellow;\">"+ p + "</mark>";
						}else {
							params += p;
						}
						if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
							params += ", ";
						}
						i++;
					}
				}else {
					for(String p: ((VoidMethodCall)v).call_parameter.getCallParams()) {

						params += p;

						if(i < ((VoidMethodCall)v).call_parameter.getCallParams().size()) {
							params += ", ";
						}
						i++;
					}
				}



				result += space + ((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [ " + params + " ]<br>";

			}
		}

		return result;
	}






	public void getAllVariableReturn(MyReturnMethod mt, boolean yes) {

		for(Map.Entry<String, String> p : mt.parameter.getParams().entrySet()) {
			if(!def.contains(p.getKey())) {
				def.add(p.getKey());
			}	
			this.countDef++;
		}

		if(mt.jackieReturnCovered) {
			if(!use.contains(mt.varName)) {
				use.add(mt.varName);
			}
			this.countUse++;
		}

		getMethodVar(mt.method_body, yes);


	}

	public void getAllVariableVoid(MyVoidMethod mt, boolean yes) {

		for(Map.Entry<String, String> p : mt.parameter.getParams().entrySet()) {
			if(!def.contains(p.getKey())) {
				def.add(p.getKey());
			}
			this.countDef++;
		}

		//		if(!use.contains(mt.varName)) {
		//			use.add(mt.varName);
		//		}
		//		this.countUse++;


		getMethodVar(mt.method_body, yes);


	}

	private void getMethodVar(MyMethodBody mb, boolean yes) {

		List<String> assignmentvar = new ArrayList<>();
		for(Assignment a: mb.assiList) {
			if(a.covered) {
				if(!assignmentvar.contains(a.varName)) {
					assignmentvar.add(a.varName);
				}	
			}

		}

		for(Declaration a: mb.declList) {
			if(a.covered) {
				if(!assignmentvar.contains(a.varName)) {
					if(!def.contains(a.varName)) {
						def.add(a.varName);
					}
					this.countDef++;
				}
			}

		}

		for(Assignment a: mb.assiList) {
			if(a.covered) {
				if(!def.contains(a.varName)) {
					def.add(a.varName);
				}
				this.countDef++;

				if(a.expr instanceof Values) {
					if(((Values)a.expr) instanceof ValueMath) {
						List<String> list  = new ArrayList<>();
						list = getVariables(((ValueMath)((Values)a.expr)).math, list);

						for(String s : list) {
							if(!use.contains(s)) {
								use.add(s);
							}
							this.countUse++;
						}
					}
				}else if(a.expr instanceof ReturnMethodCall) {
					if(yes) {
						this.returnMethodCall.add(((ReturnMethodCall)a.expr).methodName);
					}

					for(Input_List p : ((ReturnMethodCall)a.expr).call_parameter.getTestCallParams()) {
						if(p instanceof CallParamVarName) {
							CallParamVarName a1 = (CallParamVarName) p;
							if(!use.contains(a1.varName)) {
								use.add(a1.varName);
							}
							this.countUse++;
						}else if(p instanceof CallParamDouble) {
							CallParamDouble a1 = (CallParamDouble) p;
						}else if(p instanceof CallParamNum) {
							CallParamNum a1 = (CallParamNum) p;
						}else if(p instanceof CallParamChar) {
							CallParamChar a1 = (CallParamChar) p;
						}else if(p instanceof CallParamString) {
							CallParamString a1 = (CallParamString) p;
						}else if(p instanceof CallParamBoolean) {
							CallParamBoolean a1 = (CallParamBoolean) p;
						}

					}
				}
			}
		}

		for(IfStatement i1 : mb.ifStatList) {
			List<String> condList = new ArrayList<>();
			condList = getCondVariableList(i1.cond, condList);

			if(i1.jackieIf) {
				for(String s: condList) {
					if(!use.contains(s)) {
						use.add(s);
					}
					this.countUse++;
				}
			}

			if(i1.CondEvaluatedTo) {
				getMethodVar(i1.ifBody, yes);
				getMethodVar(i1.elseBody, yes);
			}else {
				getMethodVar(i1.ifBody, yes);
				getMethodVar(i1.elseBody, yes);
			}
		}


		for(Loop lo : mb.loops) {
			if(lo.iterationGoal != 0) {
				getMethodVar(lo.body, yes);
			}
		}

		for(MethodCall v: mb.methodCall) {
			if(v instanceof VoidMethodCall) {
				if(yes) {
					this.voidMethodCall.add(((VoidMethodCall)v).methodname);
				}

				if(((VoidMethodCall)v).covered) {
					for(String s: ((VoidMethodCall)v).call_parameter.getCallParams()) {
						if(!use.contains(s)) {
							use.add(s);
						}
						this.countUse++;
					}
				}
			}
		}
	}

	//	private void getTestMethodCall( MyMethodBody mb) {
	//
	//		for(Assignment a: mb.assiList) {
	//			if(a.expr instanceof ReturnMethodCall) {
	//				if(!this.returnMethodCall.contains(((ReturnMethodCall)a.expr).methodName)){
	//					this.returnMethodCall.add(((ReturnMethodCall)a.expr).methodName);
	//				}
	//			}
	//		}
	//
	//		for(IfStatement i1 : mb.ifStatList) {
	//			if(i1.CondEvaluatedTo) {
	//				getTestMethodCall( i1.ifBody);
	//			}else {
	//				getTestMethodCall( i1.elseBody);
	//			}
	//		}
	//
	//		for(Loop lo : mb.loops) {
	//			if(lo.iterationGoal != 0) {
	//				getTestMethodCall( lo.body);
	//			}
	//		}
	//
	//		for(MethodCall v: mb.methodCall) {
	//			if(v instanceof VoidMethodCall) {
	//				if(!this.voidMethodCall.contains(((VoidMethodCall)v).methodname)) {
	//					this.voidMethodCall.add(((VoidMethodCall)v).methodname);
	//				}
	//			}
	//		}
	//	}


	private List<String> getVariables(Mathematics m, List<String> list) {
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			list= getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			list = getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			list = getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof Division) {
			Division a = (Division) m;
			list = getVariables(a.math1, list);
			list = getVariables(a.math2, list);
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(!list.contains(a.varName)) {
				list.add(a.varName);
			}
		}

		return list;
	}

	private String getMathString(Mathematics m, String d) {
		String result = "";
		if(m instanceof Addition) {
			Addition a = (Addition) m;
			String left = getMathString(a.math1, d);
			String right = getMathString(a.math2, d);
			result = left + " + " + right;
		}else if(m instanceof Subtraction) {
			Subtraction a = (Subtraction) m;
			String left = getMathString(a.math1, d);
			String right = getMathString(a.math2, d);
			result = left + " - " + right;
		}else if(m instanceof Multiplication) {
			Multiplication a = (Multiplication) m;
			String left = getMathString(a.math1, d);
			String right = getMathString(a.math2, d);
			result = left + " * " + right;
		}else if(m instanceof Division) {
			Division a = (Division) m;
			String left = getMathString(a.math1, d);
			String right = getMathString(a.math2, d);
			result = left + " / " + right;
		}else if(m instanceof MathParenthesis) {
			MathParenthesis a = (MathParenthesis) m;
			result = "(" + result + ")";
		}else if(m instanceof MathDouble) {
			MathDouble a = (MathDouble) m;
			result = Double.toString(a.num);
		}else if(m instanceof MathNumber) {
			MathNumber a = (MathNumber) m;
			result = Integer.toString(a.num);
		}else if(m instanceof MathVarName) {
			MathVarName a = (MathVarName) m;
			if(d.equals(a.varName)) {
				result = "<mark style=\"background-color: yellow;\">" + d + "</mark>";
			}else {
				result = a.varName;
			}
		}

		return result;
	}

	private List<String> getCondVariableList(Condition c, List<String> list) {
		if(c instanceof Negation) {
			Negation e = (Negation) c;
			list = getCondVariableList(e.cond, list);
		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			list = getCondVariableList(e.cond, list);
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			list = getCondVariableList(e.cond1, list);
			list = getCondVariableList(e.cond2, list);
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			list = getCondVariableList(e.cond1, list);
			list = getCondVariableList(e.cond2, list);
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			list = getCondVariableList(e.cond1, list);
			list = getCondVariableList(e.cond2, list);
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			list = getCondVariableList(e.left, list);
			list = getCondVariableList(e.right, list);
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			list = getVariables(e.left, list);
			list = getVariables(e.right, list);
		}else if(c instanceof More) {
			More e = (More) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof Less) {
			Less e = (Less) c;
			list = getVariables(e.math1, list);
			list = getVariables(e.math2, list);
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			if(!list.contains(e.varName)) {
				list.add(e.varName);
			}
		}
		return list;
	}

	private String getCondString(Condition c, String def) {
		String list = "";

		if(c instanceof Negation) {
			Negation e = (Negation) c;
			list = "not " + getCondString(e.cond, def);
		}else if(c instanceof CondParenthesis) {
			CondParenthesis e = (CondParenthesis) c;
			list = "(" + getCondString(e.cond, def) + ")";
		}else if(c instanceof Conjunction) {
			Conjunction e = (Conjunction) c;
			String left = getCondString(e.cond1, def);
			String right = getCondString(e.cond2, def);
			list = left + " && " + right;
		}else if(c instanceof Disjunction) {
			Disjunction e = (Disjunction) c;
			String left = getCondString(e.cond1, def);
			String right = getCondString(e.cond2, def);
			list = left + " || " + right;
		}else if(c instanceof EqualTo) {
			EqualTo e = (EqualTo) c;
			String left = getCondString(e.cond1, def);
			String right = getCondString(e.cond2, def);
			list = left + " == " + right;
		}else if(c instanceof NotEqualTo) {
			NotEqualTo e = (NotEqualTo) c;
			String left = getCondString(e.left, def);
			String right = getCondString(e.right, def);
			list = left + " != " + right;
		}else if(c instanceof CondBool) {
			CondBool e = (CondBool) c;
			list = Boolean.toString(e.bool);
		}else if(c instanceof CondEqual) {
			CondEqual e = (CondEqual) c;
			String left = getMathString(e.math1, def);
			String right = getMathString(e.math2, def);
			list = left + " == " + right;
		}else if(c instanceof CondNotEqual) {
			CondNotEqual e = (CondNotEqual) c;
			String left = getMathString(e.math1, def);
			String right = getMathString(e.math2, def);
			list = left + " != " + right;
		}else if(c instanceof MoreOrEqual) {
			MoreOrEqual e = (MoreOrEqual) c;
			String left = getMathString(e.math1, def);
			String right = getMathString(e.math2, def);
			list = left + " >= " + right;
		}else if(c instanceof LessOrEqual) {
			LessOrEqual e = (LessOrEqual) c;
			String left = getMathString(e.left, def);
			String right = getMathString(e.right, def);
			list = left + " <= " + right;
		}else if(c instanceof More) {
			More e = (More) c;
			String left = getMathString(e.math1, def);
			String right = getMathString(e.math2, def);
			list = left + " > " + right;
		}else if(c instanceof Less) {
			Less e = (Less) c;
			String left = getMathString(e.math1, def);
			String right = getMathString(e.math2, def);
			list = left + " < " + right;
		}else if(c instanceof CondVarName) {
			CondVarName e = (CondVarName) c;
			if(def.equals(e.varName)) {
				list = "<mark style=\"background-color: #7B68EE; color: white;\">" + def + "</mark>";
			}else {
				list = e.varName;
			}
		}
		return list;
	}

	private List<String> getMethodCallFromThis(List<MyMethods> globalMyMethods, Program p, String methodcall, List<String> list) {
		int i = 0;
		for(MyMethods mm : globalMyMethods) {
			if( mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
				if(mm.methodName.equals(methodcall) ) {
					list = getMethodCallFromThisMethod(mt.method_body ,list, false);
				}

			}else if(mm.methodType instanceof MyVoidMethod) {

				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);
				if(mm.methodName.equals(methodcall) ) {
					list = getMethodCallFromThisMethod(mt.method_body ,list, false);
				}

			}
			i++;
		}

		return list;
	}

	private List<String> getMethodCallFromThisMethod(MyMethodBody mb, List<String> list, boolean isLoop) {
		for(Assignment a: mb.assiList) {
			if(a.covered) {
				if(a.expr instanceof ReturnMethodCall) {
					if(!list.contains(((ReturnMethodCall)a.expr).methodName)) {
						list.add(((ReturnMethodCall)a.expr).methodName);
					}
				}
			}

		}

		for(IfStatement i1 : mb.ifStatList) {
			if(isLoop) {
				for(String s: getMethodCallFromThisMethod( i1.ifBody, list, isLoop)) {
					if(!list.contains(s)) {
						list.add(s);
					}
				}

				for(String s: getMethodCallFromThisMethod( i1.elseBody, list, isLoop)) {
					if(!list.contains(s)) {
						list.add(s);
					}
				}
			}else {


				if(i1.CondEvaluatedTo) {
					for(String s: getMethodCallFromThisMethod( i1.ifBody, list, isLoop)) {
						if(!list.contains(s)) {
							list.add(s);
						}
					}

					for(String s: getMethodCallFromThisMethod( i1.elseBody, list, isLoop)) {
						if(!list.contains(s)) {
							list.add(s);
						}
					}
				}else {
					for(String s: getMethodCallFromThisMethod( i1.ifBody, list, isLoop)) {
						if(!list.contains(s)) {
							list.add(s);
						}
					}

					for(String s: getMethodCallFromThisMethod( i1.elseBody, list, isLoop)) {
						if(!list.contains(s)) {
							list.add(s);
						}
					}
				}
			}
		}

		for(Loop lo : mb.loops) {
			if(lo.iterationGoal != 0) {
				for(String s: getMethodCallFromThisMethod( lo.body, list, true)) {
					if(!list.contains(s)) {
						list.add(s);
					}
				}
			}
		}

		for(MethodCall v: mb.methodCall) {
			if(v instanceof VoidMethodCall) {
				if(((VoidMethodCall)v).covered) {
					if(!list.contains(((VoidMethodCall)v).methodname)) {
						list.add(((VoidMethodCall)v).methodname);
					}
				}
			}
		}

		return list;
	}
}
