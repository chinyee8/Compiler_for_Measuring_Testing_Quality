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
import model.ValueMath;
import model.Values;
import model.VoidMethodCall;

public class AllCUsesCoverage {
	private Map<Program, MethodCall> defProgram;
	private List<String> def;
	private List<String> use;
	private int countDef;
	private int countUse;
	private List<String> returnMethodCall;
	private List<String> voidMethodCall;
	public Map<Integer, String> resultString;
	public Map<Integer,List<String>> different;
	public Map<Integer, List<String>> javascript;

	public AllCUsesCoverage(Map<Program, MethodCall> defProgram) {
		this.defProgram = defProgram;
		this.countDef = 0;
		this.countUse = 0;
		this.def = new ArrayList<>();
		this.use = new ArrayList<>();
		this.returnMethodCall = new ArrayList<>();
		this.voidMethodCall = new ArrayList<>();
		this.resultString = new LinkedHashMap<>();
		this.different = new LinkedHashMap<>();
		this.javascript = new LinkedHashMap<>();
	}
	
	public void computeAllDef() {
		getString();
	}

	public void getString() {
		int i = 0;
		for(Map.Entry<Program, MethodCall> prog : defProgram.entrySet()) {
			Program p = prog.getKey();
			MethodCall methodcall = prog.getValue();
			String result = "";

			result += "game " + p.gameclass.className + " !<br><br>";

			for(MyMethods mm : p.gameclass.body.myMethodList) {

				if( mm.methodType instanceof MyReturnMethod) {
					MyReturnMethod mt = ((MyReturnMethod)mm.methodType);

					if(methodcall instanceof ReturnMethodCall && ((ReturnMethodCall)methodcall).methodName.equals(mm.methodName) || this.returnMethodCall.contains(mm.methodName) ) {
						result += getUnderLinedReturn(mm.methodName, mt);
						
					}else {
						result += getNotUnderLinedReturn(mm.methodName, mt);
					}



				}else if(mm.methodType instanceof MyVoidMethod) {

					MyVoidMethod mt = ((MyVoidMethod)mm.methodType);

					if(methodcall instanceof VoidMethodCall && ((VoidMethodCall)methodcall).methodname.equals(mm.methodName) || this.voidMethodCall.contains(mm.methodName)) {
						result += getUnderLinedVoid(mm.methodName, mt);
					}else {
						result += getNotUnderLinedVoid(mm.methodName, mt);
					}		  
				}
			}
			result += "!<br>";
			
			result += "<br>" +  ((int)((countUse / (double) countDef)*100)) + "%";
			
			this.resultString.put(i, result);

			List<String> tempdiff = new ArrayList<>();
			List<String> tempJS = new ArrayList<>();
			
			for(String d: def) {
				tempdiff.add("<div id=\"" + d + "ans\" hidden>" +getResultString(p, methodcall, d) + "<br>" +  ((int)((countUse / (double) countDef)*100)) + "%"+ "</div>" );
				tempJS.add("function "+ d +"(){\n"
						+ "document.getElementById(\"text\").innerHTML = document.getElementById(\""+d+"ans\").innerHTML;\n"
						+ "}");
			}
			this.different.put(i, tempdiff);
			this.javascript.put(i, tempJS); 
			this.returnMethodCall = new ArrayList<>();
			this.voidMethodCall = new ArrayList<>();
			this.def = new ArrayList<>();
			this.use = new ArrayList<>();
			i++;
		}
	}
	
	public String getResultString(Program p, MethodCall methodcall, String d) {
		String result = "";
		
		result += "game " + p.gameclass.className + " !<br><br>";

		for(MyMethods mm : p.gameclass.body.myMethodList) {

			if( mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);

				if(methodcall instanceof ReturnMethodCall && ((ReturnMethodCall)methodcall).methodName.equals(mm.methodName) || this.returnMethodCall.contains(mm.methodName)) {
						result += this.getResult(mm.methodName, mt.method_body, mt.parameter, mt.dataType, mt.varName, d);
				}else {
					result += getNotUnderLinedReturn(mm.methodName, mt);
				}

			}else if(mm.methodType instanceof MyVoidMethod) {

				MyVoidMethod mt = ((MyVoidMethod)mm.methodType);

				if(methodcall instanceof VoidMethodCall && ((VoidMethodCall)methodcall).methodname.equals(mm.methodName) || this.voidMethodCall.contains(mm.methodName)) {
					result += this.getResultVoid(mm.methodName, mt.method_body, mt.parameter, mt.voidType, d);
				}else {
					result += getNotUnderLinedVoid(mm.methodName, mt);
				}		  
			}
		}
		result += "!<br>";


		return result; 
	}

	

	public String getUnderLinedReturn(String methodName, MyReturnMethod mt) {
		String result = "";
		getAllVariableReturn(mt);
		this.countDef += this.def.size();
		this.countUse += this.use.size();

		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
			if(def.contains(p1.getKey())) {
				para += p1.getValue() + " " + "<p id=\"" + p1.getKey() + "\" onclick=\"" + p1.getKey() + "()\"><u>" + p1.getKey() + "</u></p>";
			}else {
				para += p1.getValue()+ " " + p1.getKey();
			}

			if(i < mt.parameter.getParams().size()-1) {
				para+= ", ";
			}
			i++;
		} 
		result += "&emsp;mymethod " + methodName + " " + mt.dataType + " [" + para + "] !<br>";

		result += "<br>";

		result += getMethodBodyString(mt.method_body, "&emsp;");

		result += "<br>";

		result += "&emsp;&emsp;jackieReturns " + mt.varName + "<br>";
		result += "&emsp;!<br>";

		return result;
	}


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


	private String getUnderLinedVoid(String methodName, MyVoidMethod mt) {
		String result = "";
		this.def = new ArrayList<>();
		this.use = new ArrayList<>();
		getAllVariableVoid(mt);
		this.countDef += this.def.size();
		this.countUse += this.use.size();

		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 : mt.parameter.getParams().entrySet()) {
			if(def.contains(p1.getKey())) {
				para += p1.getValue() + " " + "<p id=\"" + p1.getKey() + "\" onclick=\"" + p1.getKey() + "()\"><u>" + p1.getKey() + "</u></p>";
			}else {
				para += p1.getValue()+ " " + p1.getKey();
			}

			if(i < mt.parameter.getParams().size()-1) {
				para+= ", ";
			}
			i++;
		} 


		result += "&emsp;mymethod " + methodName + " " + mt.voidType + " [" + para + "] !<br>";

		result += "<br>";

		result += getMethodBodyString(mt.method_body, "&emsp;");

		result += "<br>";

		result += "&emsp;&emsp;jackieReturns " + mt.varName + "<br>";
		result += "&emsp;!<br>";

		return result;	
	}
	
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

		result += "&emsp;&emsp;jackieReturns " + mt.varName + "<br>";
		result += "&emsp;!<br>";

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
			if(def.contains(a.varName)) {
				result += space + "<p id=\"" + a.varName + "\" onclick=\"" + a.varName + "()\"><u>" + a.varName + "</u></p>" + " <- " + a.expr.toString() + "<br>";
			}
		}

		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
			result += "<br>";
		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
			result += "<br>";
		}

		for(IfStatement i1 : mm.ifStatList) {
			if(i1.CondEvaluatedTo) {
				result += space + "jackieAsks [ " + i1.cond.toString() + " ] !<br>";
				result += getMethodBodyString( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += getElseMethodBodyString(i1.elseBody, space);
				result += space + "!<br>";
			}else {
				result += space + "jackieAsks [ " + i1.cond.toString() + " ] !<br>";
				result += getElseMethodBodyString( i1.ifBody, space);
				result += space + "! elseJackie !<br>";
				result += getMethodBodyString(i1.elseBody, space);
				result += space + "!<br>";
			}


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
			result += getElseMethodBodyString(lo.myMethodBodyList.get(0), space);
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


	private String getResultVoid(String methodName, MyMethodBody method_body, Parameter parameter, String voidType, String d) {
		String result="";
		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 :parameter.getParams().entrySet()) {
			if(d.equals(p1.getKey())) {
				para += p1.getValue() + " " + "<mark style=\"background-color: lime;\">" + p1.getKey() + "</mark>";
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

	private String getResult(String methodName, MyMethodBody method_body, Parameter parameter, String dataType, String varName, String d) {
		String result="";
		String para = ""; int i = 0;
		for(Map.Entry<String, String> p1 :parameter.getParams().entrySet()) {
			if(d.equals(p1.getKey())) {
				para += p1.getValue() + " " + "<mark style=\"background-color: lime;\">" + p1.getKey() + "</mark>";
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

		if(d.equals(varName)) {
			result += "&emsp;&emsp;jackieReturns " + "<mark style=\"background-color: yellow;\">" + varName + "</mark><br>";
		}else {
			result += "&emsp;&emsp;jackieReturns " + varName + "<br>";
		}

		result += "&emsp;!<br>";

		return result;
	}

	public String getResultBody(MyMethodBody mm, String space, String d) {
		String result = "";
		space = space + "&emsp;&emsp;";

		for(Declaration a: mm.declList) {
			result += space + a.toString() + "<br>";
		}

		if(mm.declList.size()>0 && mm.assiList.size()>0) {
			result += "<br>";
		}

		for(Assignment a: mm.assiList) {
			String expr = "";
			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					expr = getMathString(((ValueMath)((Values)a.expr)).math, d);
				}else{
					expr = ((Values)a.expr).getValues().toString();
				}
			}else if(a.expr instanceof ReturnMethodCall) {
				String para = ""; int i = 0;
				for(String s : ((ReturnMethodCall)a.expr).call_parameter.getCallParams()) {
					if(d.equals(s)) {
						para += "<mark style=\"background-color: yellow;\">" + s + "</mark>";
					}else {
						para += s;
					}

					if(i < ((ReturnMethodCall)a.expr).call_parameter.getCallParams().size()-1) {
						para+= ", ";
					}
					i++;
				}
				expr = ((ReturnMethodCall)a.expr).methodName + " [" + para + "]";
			}

			if(d.equals(a.varName)) {
				result += space + "<mark style=\"background-color: lime;\">" + a.varName + "</mark>" + " <- " + expr + "<br>";
			}else {
				result += space + a.varName + " <- " + expr + "<br>";
			}
		}

		if(mm.assiList.size()>0 && mm.ifStatList.size()>0) {
			result += "<br>";
		}else if(mm.declList.size()>0 && mm.ifStatList.size()>0 && mm.assiList.size()==0) {
			result += "<br>";
		}

		for(IfStatement i1 : mm.ifStatList) {
			String cond = getCondString(i1.cond, d);

			if(i1.CondEvaluatedTo) {				
				result += space + "jackieAsks [ " + cond + " ] !<br>";
				result += getResultBody( i1.ifBody, space, d);
				result += space + "! elseJackie !<br>";
				result += getElseMethodBodyString(i1.elseBody, space);
				result += space + "!<br>";
			}else {
				result += space + "jackieAsks [ " + cond + " ] !<br>";
				result += getElseMethodBodyString( i1.ifBody, space);
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
			result += getResultBody(lo.myMethodBodyList.get(0), space, d);
			result += space + "!<br>";
		}

		if(mm.methodCall.size()>0) {
			result += "<br>";
		}

		for(MethodCall v: mm.methodCall) {
			if(v instanceof VoidMethodCall) {

				String params = ""; int i = 0; 
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

				result += space + ((VoidMethodCall)v).voidcall + ((VoidMethodCall)v).methodname + " [" + params + "]<br>";
			}
		}

		return result;
	}
	
	

	
	

	public void getAllVariableReturn(MyReturnMethod mt) {

		for(Map.Entry<String, String> p : mt.parameter.getParams().entrySet()) {
			if(!def.contains(p.getKey())) {
				def.add(p.getKey());
			}
		}

		if(!use.contains(mt.varName)) {
			use.add(mt.varName);
		}

		getMethodVar(mt.method_body);


	}

	public void getAllVariableVoid(MyVoidMethod mt) {

		for(Map.Entry<String, String> p : mt.parameter.getParams().entrySet()) {
			if(!def.contains(p.getKey())) {
				def.add(p.getKey());
			}
		}

		if(!use.contains(mt.varName)) {
			use.add(mt.varName);
		}

		getMethodVar(mt.method_body);


	}

	private void getMethodVar(MyMethodBody mb) {

		for(Assignment a: mb.assiList) {
			if(!def.contains(a.varName)) {
				def.add(a.varName);
			}

			if(a.expr instanceof Values) {
				if(((Values)a.expr) instanceof ValueMath) {
					List<String> list  = new ArrayList<>();
					list = getVariables(((ValueMath)((Values)a.expr)).math, list);

					for(String s : list) {
						if(!use.contains(s)) {
							use.add(s);
						}
					}
				}
			}else if(a.expr instanceof ReturnMethodCall) {
				this.returnMethodCall.add(((ReturnMethodCall)a.expr).methodName);
				for(String s : ((ReturnMethodCall)a.expr).call_parameter.getCallParams()) {
					if(!use.contains(s)) {
						use.add(s);
					}
				}
			}
		}

		for(IfStatement i1 : mb.ifStatList) {
			List<String> condList = new ArrayList<>();
			condList = getCondVariableList(i1.cond, condList);
			
			for(String s: condList) {
				if(!use.contains(s)) {
					use.add(s);
				}
			}
			
			if(i1.CondEvaluatedTo) {
				getMethodVar(i1.ifBody);
			}else {
				getMethodVar(i1.elseBody);
			}
		}


		for(Loop lo : mb.loops) {
			getMethodVar(lo.myMethodBodyList.get(0));
		}

		for(MethodCall v: mb.methodCall) {
			if(v instanceof VoidMethodCall) {
				this.voidMethodCall.add(((VoidMethodCall)v).methodname);

				for(String s: ((VoidMethodCall)v).call_parameter.getCallParams()) {
					if(!use.contains(s)) {
						use.add(s);
					}
				}
			}
		}
	}

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
				list = "<mark style=\"background-color: yellow;\">" + def + "</mark>";
			}else {
				list = e.varName;
			}
		}
		return list;
	}


}
