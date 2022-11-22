package Operations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllDefCoverage {
	private Map<Integer, List<Integer>> defLines;
	private Map<Integer, List<Integer>> useLines;
	private Map<Integer, List<String>> lines;

	public AllDefCoverage(Map<Integer, List<Integer>> defLines, Map<Integer, List<Integer>> useLines,
			Map<Integer, List<String>> lines) {
		this.defLines = defLines;
		this.useLines = useLines;
		this.lines = lines;
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
				modifiedLines.add("<mark style=\"background-color: green;\">"+s+"</mark><br>");
			}else if(useLines.get(testnum).contains(i)) {
				modifiedLines.add("<mark style=\"background-color: yellow;\">"+s+"</mark><br>");
			}else {
				modifiedLines.add(s);
			}
			i++;
		}
		
		result += "<p id=\"allDef\" hidden>";
		for(String s: modifiedLines) {
			result += s  + "<br>";
		}
		result += "</p><br>\n";
		
		return result;
	}

}
