package Operations;

import java.util.ArrayList;
import java.util.HashMap;
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
import model.Values;
import model.VoidMethodCall;

public class ConditionCoverage{
	
	//String htmlPrint;
	Map<String, TestCase> componentMap;
	boolean isComponentState;
	String ifStatString;
	String resultString;
	//Map.Entry<MethodCall, Map<String, Values>> testMethod;
	public HashMap<String, Values> localVarMap;
	
	
	String calledMethod; // called method from test
	public List<String> methodCallParamOrder;
	String curMethod; // source code's current method
	
	//for html
	List<Program> programList;
	int hoverIndex;
	Map<String, String> tableHTMLMap;
	
	public class TestCase{

		public ArrayList<String> components; // # = n
		public boolean[] results; //vertical value. #= 2^n
		public int resultCount;
		
		public TestCase() {
			components = new ArrayList<>();
			results = null;
			resultCount = 0;
		}
	}
	
	public ConditionCoverage() {
		componentMap = new HashMap<>();
		//htmlPrint = ""; // for pretty printing
		isComponentState = true;
		//testMethod = null;
		calledMethod = "";
		
		programList = new ArrayList<>();
		hoverIndex = 0;
		tableHTMLMap = new HashMap<>();
	}
	
	
	public boolean isComponentState() {
		return isComponentState;
	}


	public void setComponentState(boolean isComponentState) {
		this.isComponentState = isComponentState;
	}

	
	public String getIfStatString() {
		return ifStatString;
	}

	public void setIfStatString(String ifStatString) {
		String temp = ifStatString.replace(" ", "");
		if (this.ifStatString == null || !this.ifStatString.equals(temp)) {
			this.ifStatString = temp;
			resetResultString();
		}
	}

	public void appendResultString(String addedString) {
		this.resultString += addedString;
	}
	
	public void resetResultString() {
		this.resultString = "";
	}
	/*
	public Map.Entry<MethodCall, Map<String, Values>> getTestMethod() {
		return testMethod;
	}


	public void setTestMethod(Map.Entry<MethodCall, Map<String, Values>> testMethod) {
		this.testMethod = testMethod;
	}*/

	public String getMethodParam(String varName) {
		return localVarMap.get(varName).toString();
		//return testMethod.getValue().containsKey(varName) ? testMethod.getValue().get(varName).toString() : null;
	}
	
	// should be called when you parse the game class. (AntlrToIfStatement?)
	public void addComponent(String component) {
		if (!componentMap.containsKey(ifStatString)){ // if not exist, make new
			componentMap.put(ifStatString, new TestCase());
		}
		
		TestCase curTestCase = componentMap.get(ifStatString);
		
		if (!curTestCase.components.contains(component)) {
			curTestCase.components.add(component);
			curTestCase.results = new boolean[(int)Math.pow(2, curTestCase.components.size())];
		}
	}
	
	// should be called when it gets input for the condition parameter
	// binary form 
	// for example, if there are two components, and first component is true and second conpoenents is false, "01" should be in the parameter
	public boolean addResult() { 
		TestCase curTestCase = componentMap.get(ifStatString);
		if (!resultString.isEmpty() && curTestCase != null && isCalledMethod()) {
			int n = Integer.parseInt(this.resultString, 2);
			int index = (int) Math.pow(2, curTestCase.components.size()) - n - 1;
			
			resetResultString();
			
			if (index  < 0 || index >= curTestCase.results.length) 
				return false;
			if (!curTestCase.results[index]) {
				curTestCase.results[index] = true; 
				curTestCase.resultCount++;
			}
			return true;
		}
		return false;
	}
	
	public String getCalledMethod() {
		return this.calledMethod;
	}
	
	public void setCalledMethod(String curMethod) {
		this.calledMethod = curMethod;		
	}
	
	public boolean isCalledMethod() {
		return (calledMethod == null) ? false : calledMethod.equals(curMethod);
		//return (testMethod == null) ? false : calledMethod.equals(testMethod.getKey().getName());
	}

	public List<String> getMethodCallParamOrder() {
		return methodCallParamOrder;
	}


	public void setMethodCallParamOrder(List<String> methodCallParamOrder) {
		this.methodCallParamOrder = methodCallParamOrder;
	}

	public List<Program> getProgramList() {
		return programList;
	}


	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}

	
	public String getCurMethod() {
		return curMethod;
	}

	public void setCurMethod(String curMethod) {
		this.curMethod = curMethod;
	}

	public HashMap<String, Values> getLocalVarMap() {
		return localVarMap;
	}


	public void setLocalVarMap(HashMap<String, Values> localVarMap) {
		this.localVarMap = localVarMap;
	}


	public String hoverStyle() {
		if (hoverIndex >= tableHTMLMap.size()) {
			return "";
		}
		String hoverStyle = "";
		hoverStyle += "<style> .popup {\n"
				+ "  position: absolute;\n"
				+ "  display: inline-block;\n"
				+ "  cursor: pointer;\n"
				+ "  -webkit-user-select: none;\n"
				+ "  -moz-user-select: none;\n"
				+ "  -ms-user-select: none;\n"
				+ "  user-select: none;\n"
				+ "}"
				+ ".popuptext {  visibility: hidden;\n"
				+ "  width: 160px;\n"
				+ "  background-color: yellow;\n"
				+ "  color: black;\n"
				+ "  text-align: center;\n"
				+ "  border-radius: 6px;\n"
				+ "  padding: 8px 0;\n"
				+ "  position: relative;\n"
				+ "  z-index: 1;\n"
				+ "  bottom: 125%;\n"
				+ "  left: 50%;\n"
				+ "  margin-left: -80px;}"
				+ " .popup .show {\n"
				+ "  visibility: visible;\n"
				+ "}</style>"; // pop up style & hide
		return hoverStyle;
	}
	public String hoverScript(String curCondString) {
		
		if (hoverIndex >= tableHTMLMap.size()) {
			return "";
		}
		
		String hoverScript = ""; 

		hoverScript += " <script> function showTable" + hoverIndex + "() { var popup = document.getElementById(\"Popup" + hoverIndex + "\"); popup.classList.toggle(\"show\");}</script>";
		
		return hoverScript;
		
	}
	
	public String hoverButton(String curCondString) {
		
		// match if statement and it's table
		if (hoverIndex >= tableHTMLMap.size()) {
			return "";
		}
		String hoverButton = "";
		hoverButton += "<a" + hoverIndex + " class =\"popup\" onclick=\"showTable" + hoverIndex + "()\"> ☞ See Coverage" ;
		hoverButton +=  " <span id=\"Popup" + hoverIndex + "\" class=\"popuptext\">" + tableHTMLMap.get( curCondString.replace(" ", "")) + "</span>  </a" + hoverIndex + ">";
		hoverIndex++;
		return hoverButton;
		
	}
	
	// should be called when html is generated
	public String getPrint() { 
		settableHTMLMap();
		
		hoverIndex = 0;
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
				
				result += getMethodBodyString(mt.method_body, "&emsp;", mm.methodName);
				
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
				
				result += getMethodBodyString(mt.method_body, "&emsp;", mm.methodName);
				
				result += "<br>";

				result += "&emsp;!<br>";
			}
		}
		result += "!<br>";

		return result;

	}

	public String getMethodBodyString(MyMethodBody mm, String space, String methodName) {
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
			String tempIfSt = "jackieAsks [ " + i1.cond.toString() + " ]";
			result += hoverStyle(); // css
			result += hoverScript(i1.cond.toString()) ; // js
			result += space + tempIfSt + " !" + hoverButton(methodName + "." + tempIfSt) + "<br>"; // hover button
			result += getMethodBodyString(i1.ifBody, space, methodName);
			result += space + "! elseJackie !<br>";
			result += getMethodBodyString(i1.elseBody, space, methodName);
			result += space + "!<br>";
		}
		
		if(mm.loops.size()>0) {
			result += "<br>";
		}

		for(Loop lo : mm.loops) {
			result += space + "loop (" + lo.iterationGoal + ") !<br>";
			result += getMethodBodyString(lo.body, space, methodName);
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

	public void settableHTMLMap() {

		for (String curIfStat : componentMap.keySet()) { // iterate for all if statements
			String curTableHTML = ""; 
			curTableHTML += "<style>table,th,td{border:1px solid black;}</style>";
			curTableHTML += "<div>";
			curTableHTML += "<p>" + curIfStat.replace("<", "&lt").replace(">", "&gt") + "</p>"; // current if statement
			curTableHTML += "<table style=\"width:100%\">"; // for table format
			
			// table column header
			curTableHTML += "<tr>";
			curTableHTML += "<th>" + "possible case #" + "</th>";
			for (String curComp : componentMap.get(curIfStat).components) {
				curTableHTML += "<th>" + curComp.replace("<", "&lt").replace(">", "&gt") + "</th>";
				/*
				if (curComp.contains("<")) {
					curTableHTML += "<th>" + curComp.substring(curComp.indexOf("."), curComp.indexOf("<")) + "&lt" + curComp.substring(curComp.indexOf("<") + 1) + "</th>";
				}
				else if (curComp.contains(">")) {
					curTableHTML += "<th>" + curComp.substring(curComp.indexOf("."), curComp.indexOf(">")) + "&gt" + curComp.substring(curComp.indexOf(">") + 1) + "</th>";
					
				}
				else{
					
				}*/
			}
			curTableHTML += "<th>" + "is tested?" + "</th>";
			curTableHTML += "</tr>";
			
			//table contents (each row)
			int componentNum = componentMap.get(curIfStat).components.size();
			int possibleCaseNum = (int) Math.pow(2, componentNum); // 2^n (componenet Num)
			for (int i = 0; i < possibleCaseNum ; i++) {
				curTableHTML += "<tr>";
				curTableHTML += "<th>" + (i + 1) + "</th>"; // possible case column
				
				for (int j = 0; j < componentNum; j++) { 
					
					int repeatNum = (int) (possibleCaseNum / Math.pow(2, j + 1));
					int flag = (int)(i / repeatNum) % 2;
					
					if (flag == 0) {
						curTableHTML += "<th>" + "T" + "</th>";
					}
					else {
						curTableHTML += "<th>" + "F" + "</th>";
					}
					
				}
				
				// is tested?
				if (componentMap.get(curIfStat).results[i] == true) {
					curTableHTML += "<th>" + "✔" + "</th>";
				}
				else {
					curTableHTML += "<th>" + "" + "</th>";
				}
				
				curTableHTML += "</tr>";
			}
			curTableHTML += "</table></div>";
			double coveragePercent = (((double)componentMap.get(curIfStat).resultCount / (double)possibleCaseNum) * 100);
			curTableHTML += "<p2>" + String.format("%.2f", coveragePercent) + "% covered! <p2>";
			
			tableHTMLMap.put(curIfStat.replace(" ", ""), curTableHTML); //add into list
			
		}

	}
	

}

