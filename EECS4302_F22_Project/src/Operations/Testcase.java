package Operations;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import AntlrToObject.AntlrToProgram;
import AntlrToObject.AntlrToTestCase;
import model.Assignment;
import model.CallParamBoolean;
import model.CallParamChar;
import model.CallParamDouble;
import model.CallParamNum;
import model.CallParamString;
import model.CallParamVarName;
import model.Declaration;
import model.Expr;
import model.Input_List;
import model.MethodCall;
import model.Program;
import model.ReturnMethodCall;
import model.TestCase;
import model.TestMethodCall;
import model.Values;
import model.VoidMethodCall;

public class Testcase {
	private Program testProg;
	private AntlrToProgram testV;
	private Map<String, Values> result;
	public List<String> resultString = new LinkedList<>();
	public List<String> javascript = new LinkedList<>();
	public List<String> css = new LinkedList<>();
	public List<String> pressList = new LinkedList<>();

	public Testcase(Program testProg, AntlrToProgram testV) {
		this.testProg = testProg;
		this.testV = testV;
		this.result = new LinkedHashMap<>();
	}
	
	public void computeTest() {
		this.getResult();
		this.getStringResult();
	}

	public String getString() {
		String result ="";

		TestCase t = this.testProg.testcase;

		result += "<p class=\"lineNum\">"+ t.line + "</p>" + "&ensp;" + "test " + t.testName + " !<br>";

		for(Declaration d : t.decl) {
			if(d.line < 10) {
				result +=  "<p class=\"lineNum\"> "+ d.line + "</p>" + "&ensp;" + "&emsp;" + d.varName + " << " + d.dataType + "<br>";
			}else {
				result +=  "<p class=\"lineNum\">"+ d.line + "</p>" + "&ensp;" + "&emsp;" + d.varName + " << " + d.dataType + "<br>";
			}
		}

		if(t.decl.size()>0 && t.assi.size()>0) {
			result += "<br>";
		}

		//		 int total = 0;
		//		for(Assignment a: t.assi) {
		//			if(a.expr instanceof ReturnMethodCall) {
		//				total++;
		//			}
		//		}

		//		int i = total-1;
		int i = 0;
		for(Assignment a : t.assi) {
			if(a.expr instanceof Values) {
				if(a.line<10) {
					result += "<p class=\"lineNum\"> "+ a.line + "</p>" + "&ensp;" + "&emsp;" + a.varName + " <- " + a.expr + "<br>";

				}else {
					result += "<p class=\"lineNum\">"+ a.line + "</p>" + "&ensp;" + "&emsp;" + a.varName + " <- " + a.expr + "<br>";

				}
			}else if(a.expr instanceof ReturnMethodCall) {
				if(a.line < 10) {
					result += "<p class=\"lineNum\"> "+ a.line + "</p>" + "&ensp;" + "&emsp;" + a.varName + " <- " + "<a href=\"game"+i+".html\"><p><mark class=\"testcaseclick\">" + a.expr + "</mark></p></a>" + "<br>";
				}else {
					result += "<p class=\"lineNum\">"+ a.line + "</p>" + "&ensp;" + "&emsp;" + a.varName + " <- " + "<a href=\"game"+i+".html\"><p><mark class=\"testcaseclick\">" + a.expr + "</mark></p></a>" + "<br>";
				}
				i++;
			}
		}

		if(t.assi.size()>0 && t.t_method_call.size()>0) {
			result += "<br>";
		}else if(t.decl.size()>0 && t.t_method_call.size()>0 && t.assi.size()==0) {
			result += "<br>";
		}

		for(TestMethodCall tm : t.t_method_call) {
			if(tm.line < 10) {
				result += "<p class=\"lineNum\"> "+ tm.line + "</p>" + "&ensp;" + "&emsp;" + tm.toString();

			}else {
				result += "<p class=\"lineNum\">"+ tm.line + "</p>" + "&ensp;" + "&emsp;" + tm.toString();

			}
		}

		result += "!";

		return result;
	}

	public void getStringResult() {
		int i = 0;
		
		this.pressList.add("<ul>");
		for(Map.Entry<String, Values> val: this.result.entrySet()) {
			this.pressList.add("<li id=\"testlist" + i + "\" onclick=\"testlist" + i + "()\"><p class=\"varList\">" + val.getKey() + "</p></li>");

			this.resultString.add("<div id=\"testresult" + i + "\" hidden>"
								+ "Result = " +val.getValue().toString() 
								+ "</div>" );

			this.javascript.add(  "function testlist"+ i +"(){\n"
								+ "document.getElementById(\"right\").innerHTML = document.getElementById(\"testresult"+ i +"\").innerHTML;\n"
								+ "}");

			i++;
		}
		this.pressList.add("</ul>");
		
		this.css.add("#left{\n"
				+ "    float:left;\n"
				+ "    width:50%;\n"
				+ "}\n"
				+ "\n"
				+ ".testString:after{\n"
				+ "    content : \"\";\n"
				+ "    display: table;\n"
				+ "    clear: both;\n"
				+ "}");
		
		this.css.add("ul{\n"
				+ "    list-style-type: none;\n"
				+ "    margin: 0;\n"
				+ "    padding: 0;\n"
				+ "    width: 500px;\n"
				+ "    background-color: #F0F8FF;\n"
				+ "}\n"
				+ "li .varList{\n"
				+ "    display: block;\n"
				+ "    color: #000;\n"
				+ "    padding: 8px 16px;\n"
				+ "    text-decoration: none;\n"
				+ "		border-style: outset;"
				+ "		margin: 0;"
				+ "}\n"
				+ "li .varList:hover{\n"
				+ "    background-color: blue;\n"
				+ "    color: white;\n"
				+ "}");
		
		this.css.add(".lineNum{"
					+ " color: grey;"
					+ " font-size:12px;"
					+ "}");

//		this.css.add("mark{"
//				+ "border-style: outset;"
//				+ "}");
	}

	public void getResult() {
		List<MethodCall> methodCall = this.testV.testKey;
		Map<Integer, Values> values = this.testV.assignedValues;
		Map<Integer, String> assignedTo = this.testV.assignedTo;

		int i = 0;
		for(MethodCall mc: methodCall) {
			String tmp = "";

			if(mc instanceof ReturnMethodCall) {
				ReturnMethodCall m = (ReturnMethodCall) mc;
				List<Input_List> inputList = m.call_parameter.getTestCallParams();
				String params = getParameter(inputList);

				int j = 0;
				for(Map.Entry<Integer, String> assi : assignedTo.entrySet()) {
					if(i == j) {
						tmp += "Line " + assi.getKey() + " : " + assi.getValue() + " <- ";
					}
					j++;
				}

				tmp += m.methodName + " [ " + params + " ]";

			}

			int j = 0;
			for(Map.Entry<Integer, Values> v: values.entrySet()) {
				if(i == j) {
					this.result.put(tmp, v.getValue());
				}
				j++;
			}

			//			else if(mc instanceof VoidMethodCall) {
			//				VoidMethodCall m = (VoidMethodCall) mc;
			//				List<Input_List> inputList = m.call_parameter.getTestCallParams();
			//				String params = getParameter(inputList);
			//				
			//				int j = 0;
			//				for(Map.Entry<Integer, String> assi : assignedTo.entrySet()) {
			//					if(i == j) {
			//						tmp += "Line " + assi.getKey() + "==> " + assi.getValue() + " <- ";
			//					}
			//					j++;
			//				}
			//				
			//				tmp += m.methodname + " [ " + params + " ]";
			//			}
			i++;
		}
	}

	private String getParameter(List<Input_List> inputList) {
		String para = ""; int i = 0;

		for(Input_List s: inputList) {
			if(s instanceof CallParamVarName) {
				CallParamVarName a1 = (CallParamVarName) s;
				para += a1.varName;
			}else if(s instanceof CallParamDouble) {
				CallParamDouble a1 = (CallParamDouble) s;
				para += a1.input;
			}else if(s instanceof CallParamNum) {
				CallParamNum a1 = (CallParamNum) s;
				para += a1.num;
			}else if(s instanceof CallParamChar) {
				CallParamChar a1 = (CallParamChar) s;
				para += a1.input;
			}else if(s instanceof CallParamString) {
				CallParamString a1 = (CallParamString) s;
				para += a1.input;
			}else if(s instanceof CallParamBoolean) {
				CallParamBoolean a1 = (CallParamBoolean) s;
				para += a1.input;
			}

			if(i < inputList.size()-1) {
				para+= ", ";
			}
			i++;

		}

		return para;
	}
}
