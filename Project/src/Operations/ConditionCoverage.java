package Operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConditionCoverage{
	
	String htmlPrint;
	Map<String, TestCase> componentMap;
	
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
		htmlPrint = ""; // for pretty printing
	}
	
	public void addComponent(String ifStat, String component) {

		if (!componentMap.containsKey(ifStat)){ // if not exist, make new
			componentMap.put(ifStat, new TestCase());
		}
		
		TestCase curTestCase = componentMap.get(ifStat);
		
		if (!curTestCase.components.contains(component)) {
			curTestCase.components.add(component);
			curTestCase.results = new boolean[(int)Math.pow(2, curTestCase.components.size())];
		}
	}
	
	// should be called in testcase part
	// binary form 
  // for example, if there are two components, and first component is true and second conpoenents is false, "01" should be in the parameter
	public void addResult(String ifStat, String results) { 
		TestCase curTestCase = componentMap.get(ifStat);
		
		if (curTestCase != null) {
			int n = Integer.parseInt(results, 2);
			int index = (int) Math.pow(2, curTestCase.components.size()) - n - 1;
			curTestCase.results[index] = true; // Tested
			curTestCase.resultCount++;
		}
	}
	
	// should be called when html is generated
	public String getPrint() { 
		htmlPrint += "<style>table,th,td{border:1px solid black;}</style>"; // for table border
		htmlPrint += "<h2>Condition Coverage</h2>"; // for condition coverage header
		
		for (String curIfStat : componentMap.keySet()) { // iterate for all if statements
			htmlPrint += "<div>";
			htmlPrint += "<p>" + curIfStat + "</p>"; // current if statement
			htmlPrint += "<table style=\"width:100%\">"; // for table format
			
			// table column header
			htmlPrint += "<tr>";
			htmlPrint += "<th>" + "possible case #" + "</th>";
			for (String curComp : componentMap.get(curIfStat).components) { 
				htmlPrint += "<th>" + curComp + "</th>";
			}
			htmlPrint += "<th>" + "is tested?" + "</th>";
			htmlPrint += "</tr>";
			
			//table contents (each row)
			int componentNum = componentMap.get(curIfStat).components.size();
			int possibleCaseNum = (int) Math.pow(2, componentNum); // 2^n (componenet Num)
			for (int i = 0; i < possibleCaseNum ; i++) {
				htmlPrint += "<tr>";
				htmlPrint += "<th>" + (i + 1) + "</th>"; // possible case column
				
				for (int j = 0; j < componentNum; j++) { 
					
					int repeatNum = (int) (possibleCaseNum / Math.pow(2, j + 1));
					int flag = (int)(i / repeatNum) % 2;
					
					if (flag == 0) {
						htmlPrint += "<th>" + "T" + "</th>";
					}
					else {
						htmlPrint += "<th>" + "F" + "</th>";
					}
					
				}
				
				// is tested?
				if (componentMap.get(curIfStat).results[i] == true) {
					htmlPrint += "<th>" + "V" + "</th>";
				}
				else {
					htmlPrint += "<th>" + "" + "</th>";
				}
				
				htmlPrint += "</tr>";
			}
			htmlPrint += "</table></div>";
			double coveragePercent = (((double)componentMap.get(curIfStat).resultCount / (double)possibleCaseNum) * 100);
			htmlPrint += "<p2> Condition Coverage percentage:" + String.format("%.2f", coveragePercent) + "% <p2>";
		}
		
		return htmlPrint;
	}

}

