package Operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllDefCoverage {
	private Map<Integer, List<Integer>> defLines;
	private Map<Integer, List<Integer>> useLines;
	private Map<Integer, List<String>> lines;
	private Map<Integer, Integer> percentage;

	public AllDefCoverage(Map<Integer, List<Integer>> defLines, Map<Integer, List<Integer>> useLines,
			Map<Integer, List<String>> lines, Map<Integer, Integer> percentage) {
		this.defLines = defLines;
		this.useLines = useLines;
		this.lines = lines;
		this.percentage = percentage;
	}

	public String getString(int testnum) { //testnum 0->infinity
		String result = "";
		List<String> modifiedLines = new LinkedList<>();
		List<Integer> use = useLines.get(testnum);
		
		for(Integer i : defLines.get(testnum)) {
			if(useLines.get(testnum).contains(i)) {
				use.remove(i);
			}
		}
		
		int i = 0;
		for(String s : lines.get(testnum)) {
			if(defLines.get(testnum).contains(i)) {
				modifiedLines.add("<mark style=\"background-color: #C2DFFF;\">"+s+"</mark>\n");
			}else if(useLines.get(testnum).contains(i)) {
				modifiedLines.add("<mark style=\"background-color: yellow;\">"+s+"</mark>\n");
			}else {
				modifiedLines.add(s + "\n");
			}
			i++;
		}
		
		result += "<p id=\"allDef\" hidden>\n";
		for(String s: modifiedLines) {
			result += s  + "<br>";
		}
		
//		result+= "<div style=\"font-size:2rem; border-bottom:1px solid red; position:relative;\">";
		result+= "<br><mark style=\"background-color: red;\">"  + percentage.get(testnum) + "% </mark>\n";
			
		result += "</p><br>\n";
		
		return result;
	}

}
