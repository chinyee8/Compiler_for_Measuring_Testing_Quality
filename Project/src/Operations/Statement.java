package Operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Program;

public class Statement {
	private ArrayList<Program> programList;
	private Map<Integer, List<String>> lines;
	
	public Statement(ArrayList<Program> programList, Map<Integer, List<String>> lines) {
		this.programList = programList;
		this.lines = lines;
	}
	
	public String getString(int testnum) {
		String result = "";
		Program p = programList.get(testnum);
		
		System.out.println(p.gameclass.toString());
		
		return result; 
	}

}
