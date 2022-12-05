package Operations;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import model.MethodCall;
import model.Program;
import model.TestCase;
import model.Values;

public class PrettyPrinter{

	private AllDefCoverage allDef;
	private AllPUsesCoverage allP;
	private ConditionCoverage condCov;
	private AllCUsesCoverage allC;
	private Statement statement;
	private Original ori;
	private Map<MethodCall, Map<String, Values>> allMethodCalls;
	private Testcase test;


	public PrettyPrinter(Map<MethodCall, Map<String, Values>> allMethodCalls) {
		this.allMethodCalls = allMethodCalls;
	}

	public void prettyPrint( ) {
		try {
			this.test.computeTest();

			File test = new File("index.html");
			test.createNewFile();
			System.out.println("File created in Project folder: index.html");
			FileWriter myWriter = new FileWriter("index.html");
			myWriter.write(getTest());
			myWriter.close();

			this.statement.getString();
			this.allDef.computeAllDef(); 
			this.allC.computeAllC(); 
			this.allP.computeAllP(); 
			
			for(int i = 0; i < this.allMethodCalls.size() ; i++) {
				File game = new File("game" + i + ".html");
				game.createNewFile();
				FileWriter myWriter2 = new FileWriter("game"+i+".html");
				myWriter2.write(getFunction(i));
				myWriter2.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/*
	 * Test Case
	 */
	public String getTestStyle() {
		String result = "";
		
		result += "<style>\n";
		
		result += "h1{"
				+ "font-size: 3rem;"
				+ "font-family: Times;"
				+ " font-weight: bold;"
				+ " text-align: center;"
				+ " }";
		
		result += ".result{"
				+ "	font-size:1.5rem;"
				+ " font-weight: bold;"
				+ "}";

		result += "p{\n"
				+ "display: inline;\n"
				+ "}\n";
		
		result += ".testcaseclick{"
				+ "background-color: #7B68EE;"
				+ "color: white;"
				+ "}";
		
		result += ".testcaseclick:hover{"
				+ "background-color: #E6E6FA;"
				+ "color: black;"
				+ "}";
		
		result += "h3{ width: max-content; padding:0;border: 3px dotted #7B68EE;}";

		for(String s: this.test.css) {
			result += s + "\n";
		}

		result += "</style>\n";

		return result;
	}

	private String getTest() {
		String result ="";

		result +="<html>\n";

		//css
		result += getTestStyle();

		//html
		result += "<h1>TestCase</h1>";
		result += "<div class=\"testString\">"
					+ "<div id=\"left\">" + "<h3>Click method call below for more coverage &darr; &emsp;</h3>" + "</div>" 
					+ "<div id=\"left\">" + "<h3>Click button below for result &darr; &emsp;</h3>" + "</div>"
				+ "</div>";
		String tmp = "";
		for(String s: this.test.pressList) {
			tmp += s;
		}
		
		result += "<div class=\"testString\">" 
						+ "<div id=\"left\">" +this.test.getString() + "</div>" 
						+ "<div id=\"left\">" 
								+ "<div id=\"right\" class=\"result\"> Result" + "</div><br>"
								+ "<div id=\"right\">" + tmp + "</div>"
						+ "</div>"
				+ "</div>";
		
		for(String s: this.test.resultString) {
			result += s;
		}
		
		//javascript
		result += this.getTestJS();
		
		result += "</html>";

		return result;
	}

	private String getTestJS() {
		String result = "";

		result = "<script>\n";

		for(String s: this.test.javascript) {
			result += s + "\n";
		}

		result += "</script>";

		return result;
	}

	
	/*
	 * Game Class
	 */
	public String getGameStyle(int i) {
		String result = "";
		result += "<style>\n";
		
		result += "h1{"
				+ "font-size: 3rem;"
				+ "font-family: Times;"
				+ " font-weight: bold;"
				+ " text-align: center;"
				+ " }";

		result += "p{\n"
				+ "display: inline;\n"
				+ "}\n";
		
		result += "button{"
				+ "	width: 200px;"
				+ " align-items: center;"
				+ " font-weight: bold;"
				+ "	height: 30px;"
				+ " font-size: 1rem;"
				+ "	background-color: #00008B;"
				+ " color: white;"
				+ "}";
		
		result += "button:hover{"
				+ "	background-color: #B0E0E6;"
				+ " color: black;"
				+ "}";
		
		result += ".topic{"
				+ " font-weight: bold;"
				+ " font-size: 1.2rem;"
				+ "}";
		
		result += ".navbar{"
				+ " text-align: center;"
				+ "}";
		
		result += this.defCSS(i);
		
		result += "</style>\n";

		return result;
	}

	public String getFunction(int i) {
		String result ="";

		result +="<html>\n";

		//css
		result += getGameStyle(i);

		//html
		result += "<h1>Game Class</h1>";
		result += "<h3 style=\"text-align: center;\">Click button below for coverage 	&darr;</h3>";
		
		result += "<div class=\"navbar\">";
		result += "<a href=\"index.html\"><button>&larr; TestCase </button></a>\n";
			result += "<button onclick=\"statement()\"> Statement Coverage </button>\n";
			result += "<button onclick=\"condition()\"> Condition Coverage </button>\n";
			result += "<button onclick=\"allDef()\"> All-Defs Coverage </button>\n";
			result += "<button onclick=\"allCUse()\"> All-C-Uses Coverage </button>\n";
			result += "<button onclick=\"allPUse()\"> All-P-Uses Coverage </button>\n";
		result += "</div>";

		result += "<br><br>";

		result += "<div id=\"text\">\n" + this.ori.getString() + "</div>"; //original code

		
//		String tmp = "";
//		for(String s: this.statement.statementcoverage.get(i)) {
//			tmp+= s + "\n";
//		}
		String percentage = "<h3>Percentage = "+ this.statement.percent.get(i) + "%</h3>";
		String note = "<div class=\"note\"><u>Note:</u> " + "<br><mark style=\"background-color: yellow;\"> &emsp; </mark> &emsp;statement coverage" + "</div>";
		result += "<div id=\"statement\" hidden>\n" + "<div class=\"allDefcolumn\"><u class=\"topic\">Statement Coverage</u><br><br>" +this.statement.resultString.get(i) + "</div><div class=\"allDefcolumn\">" + "<br><h3><mark style=\"background-color: orange;\"> &emsp;&larr;&emsp; </mark> &emsp;Click method call for coverage</h3>" +"<div id=\"statementpercentagenote\"><div id=\"statementpercentagenotecolumn\">" +percentage +  "</div><div id=\"statementpercentagenotecolumn\"><br>" + note +"</div></div>"  + "</div></div>\n"; //statement
		for(String s: this.statement.statementcoverage.get(i)) {
			result+= s + "\n";
		}
		
		result += "<div id=\"condition\" hidden>\n<u class=\"topic\">Condition Coverage</u><br><br>" + this.getCondCoverageString() + "</div>"; //condition

		String tmp ="";
		for(String s: this.allDef.lines.get(i)) {
			tmp += s + "\n";
		}
		note = "<br><br><br><br><div class=\"note\"><u>Note:</u> " + "<br><mark style=\"background-color: green;\"> &emsp; </mark> &emsp;green => def" + "<br><mark style=\"background-color: yellow;\"> &emsp; </mark> &emsp;yellow => c-use" + "<br><mark style=\"background-color: #7B68EE;\"> &emsp; </mark> &emsp;purple => p-use" + "<br><mark style=\"background-color: red;\"> &emsp; </mark> &emsp;red => no c-use or p-use</div>";
		result += "<div id=\"allDef\" hidden>\n" + "<div class=\"allDefcolumn\"><u class=\"topic\">All-Defs Coverage</u><br><br>" +this.allDef.resultString.get(i) + "</div><div class=\"allDefcolumn\"><h3><u>List of Variables - Click to see coverage:</u></h3>"+ "<div class=\"allDefsubcolumn\">" + tmp + "</div>"+ "<div class=\"allDefsubcolumn\">" + "<br>" + note + "</div></div></div>\n"; //alldef
		for(String s: this.allDef.different.get(i)) {
			result+= s + "\n";
		}
		
		tmp ="";
		for(String s: this.allC.lines.get(i)) {
			tmp += s + "\n";
		}
		note = "<br><br><br><br><div class=\"note\"><u>Note:</u> "+ "<br><u class=\"paragraph_underline\"> &emsp; </u> &emsp;underline => def" + "<br><mark style=\"background-color: yellow;\"> &emsp; </mark> &emsp;yellow => c-use" + "<br><mark style=\"background-color: red;\"> &emsp; </mark> &emsp;red => no c-use</div>";
		result += "<div id=\"allCUse\" hidden>\n" + "<div class=\"allDefcolumn\"><u class=\"topic\">All-C-Uses Coverage</u><br><br>" +this.allC.resultString.get(i) + "</div><div class=\"allDefcolumn\"><h3><u>List of Variables - Click to see coverage:</u></h3>"+ "<div class=\"allDefsubcolumn\">" + tmp + "</div>"+ "<div class=\"allDefsubcolumn\">" + "<br>" + note + "</div></div></div>\n"; //allC
		for(String s: this.allC.different.get(i)) {
			result+= s + "\n";
		}
		
		tmp ="";
		for(String s: this.allP.lines.get(i)) {
			tmp += s + "\n";
		}
		note = "<br><br><br><br><div class=\"note\"><u>Note:</u> "+ "<br><u class=\"paragraph_underline\"> &emsp; </u> &emsp;underline => def" + "<br><mark style=\"background-color: yellow;\"> &emsp; </mark> &emsp;yellow => p-use" + "<br><mark style=\"background-color: red;\"> &emsp; </mark> &emsp;red => no p-use</div>";
		result += "<div id=\"allPUse\" hidden>\n" + "<div class=\"allDefcolumn\"><u class=\"topic\">All-P-Uses Coverage</u><br><br>" +this.allP.resultString.get(i) + "</div><div class=\"allDefcolumn\"><h3><u>List of Variables - Click to see coverage:</u></h3>"+ "<div class=\"allDefsubcolumn\">" + tmp + "</div>"+ "<div class=\"allDefsubcolumn\">" + "<br>" + note + "</div></div></div>\n"; //allP
		for(String s: this.allP.different.get(i)) {
			result+= s + "\n";
		}
		
		
		//javascript
		result += this.getGameJS(i);

		result += "</html>";

		return result;
	}

	public String getGameJS(int i) {
		String result = "";

		result = "<script>\n";

		result += "function statement(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"statement\").innerHTML;\n"
				+ "}\n";

		result += "function condition(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"condition\").innerHTML;\n"
				+ "}\n";

		result += "function allDef(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"allDef\").innerHTML;\n"
				+ "}\n";

		result += "function allCUse(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"allCUse\").innerHTML;\n"
				+ "}\n";
		
		result += "function allPUse(){\n"
				+ "document.getElementById(\"text\").innerHTML = document.getElementById(\"allPUse\").innerHTML;\n"
				+ "}\n";

		for(String s: this.statement.javascript.get(i)) {
			result += s;
		}
		
		for(String s: this.allDef.javascript.get(i)) {
			result += s;
		}
		
		for(String s: this.allC.javascript.get(i)) {
			result += s;
		}
		
		for(String s: this.allP.javascript.get(i)) {
			result += s;
		}


		result += "</script>";

		return result;
	}


	public void addStatement(Statement s) {
		this.statement = s;		
	}

	public void addAllDefCoverage(AllDefCoverage alldef) {
		this.allDef = alldef;
	}
	
	public String defCSS(int i) {
		String result = "";
		
		result+= ".statementmc{\n"
				+ "    background-color: 	orange;\n"
				+ "}\n"
				+ "\n"
				+ ".statementmc:hover{\n"
				+ "    background-color: red;\n"
				+ "    color: white;\n"
				+ "}";
		
		result+= "#statementcov{\n"
				+ "    background-color: #F0F8FF;\n"
				+ "	   width: max-content;"
				+ "}";
		
		
		for(String s: this.statement.css.get(i)) {
			result += s;
		}
		
		for(String s: this.allDef.css.get(i)) {
			result += s;
		}
		
		for(String s: this.allC.css.get(i)) {
			result += s;
		}
		
		for(String s: this.allP.css.get(i)) {
			result += s;
		}
		
		result += "#statementpercentagenotecolumn{\n"
				+ "    float:left;\n"
				+ "    width:50%;\n"
				+ "}\n"
				+ "\n"
				+ "#statementpercentagenote:after{\n"
				+ "    content : \"\";\n"
				+ "    display: table;\n"
				+ "    clear: both;\n"
				+ "}";
		
		result += ".allDefsubcolumn{\n"
				+ "    float:left;\n"
				+ "    width:50%;\n"
				+ "}\n"
				+ "\n"
				+ "#allDefcolumn:after{\n"
				+ "    content : \"\";\n"
				+ "    display: table;\n"
				+ "    clear: both;\n"
				+ "}";
		
		result += ".allDefcolumn{\n"
				+ "    float:left;\n"
				+ "    width:50%;\n"
				+ "}\n"
				+ "\n"
				+ "#allDef:after{\n"
				+ "    content : \"\";\n"
				+ "    display: table;\n"
				+ "    clear: both;\n"
				+ "}";
		
		result += ".allDefsubcolumn{\n"
				+ "    float:left;\n"
				+ "    width:50%;\n"
				+ "}\n"
				+ "\n"
				+ "#allDefcolumn:after{\n"
				+ "    content : \"\";\n"
				+ "    display: table;\n"
				+ "    clear: both;\n"
				+ "}";
		
		result += "ul{\n"
				+ "    list-style-type: none;\n"
				+ "    margin: 0;\n"
				+ "    padding: 0;\n"
				+ "    width: 300px;\n"
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
				+ "}";
		
		result += ".paragraph_underline{color:red;}";
		
		result += ".note{width: 200px; padding:0;border: 3px dotted grey;}";
		
		return result;
	}

	public void addCondCoverage(ConditionCoverage condCov) {
		this.condCov = condCov;
	}

	public String getCondCoverageString() {
		return condCov.getPrint();
	}

	public void addAllCUseCoverage(AllCUsesCoverage allc) {
		this.allC = allc;		
	}
	
	public void addAllPUseCoverage(AllPUsesCoverage allp) {
		this.allP = allp;		
	}

	public void addOriginal(Original ori) {
		this.ori = ori;
	}

	public void addTest(Testcase test) {
		this.test = test;
	}

}
