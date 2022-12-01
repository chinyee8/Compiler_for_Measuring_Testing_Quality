package Operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Addition;
import model.Assignment;
import model.Declaration;
import model.Division;
import model.IfStatement;
import model.Loop;
import model.MathDouble;
import model.MathNumber;
import model.MathParenthesis;
import model.MathVarName;
import model.Mathematics;
import model.MethodCall;
import model.Multiplication;
import model.MyMethodBody;
import model.MyMethods;
import model.MyReturnMethod;
import model.MyVoidMethod;
import model.Program;
import model.ReturnMethodCall;
import model.Subtraction;
import model.ValueMath;
import model.Values;
import model.VoidMethodCall;

public class AllDefCoverage {
	private ArrayList<Program> defProgram;
	private List<String> def;
	private List<String> use;
	private int countDef;
	private int countUse;

//	public AllDefCoverage(Map<Integer, List<Integer>> defLines, Map<Integer, List<Integer>> useLines,
//			Map<Integer, List<String>> lines, Map<Integer, Integer> percentage) {
//		this.defLines = defLines;
//		this.useLines = useLines;
//		this.lines = lines;
//		this.percentage = percentage;
//	}
	
	public AllDefCoverage(ArrayList<Program> defProgram) {
		this.defProgram = defProgram;
		this.countDef = 0;
		this.countUse = 0;
	}
	
	
	public String getString(int testnum) {
		String result = "";
		Program p = defProgram.get(testnum);

		result += "game " + p.gameclass.className + " !<br><br>";

		for(MyMethods mm : p.gameclass.body.myMethodList) {
			if( mm.methodType instanceof MyReturnMethod) {
				MyReturnMethod mt = ((MyReturnMethod)mm.methodType);
				
				this.def = new ArrayList<>();
				this.use = new ArrayList<>();
				getAllVariable(mt);
				this.countDef += this.def.size();
				this.countUse += this.use.size();

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
//				  
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
	
	public void getAllVariable(MyReturnMethod mt) {
		
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
				for(String s : ((ReturnMethodCall)a.expr).call_parameter.getCallParams()) {
					if(!use.contains(s)) {
						use.add(s);
					}
				}
			}
		}
		
		for(IfStatement i1 : mb.ifStatList) {
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
