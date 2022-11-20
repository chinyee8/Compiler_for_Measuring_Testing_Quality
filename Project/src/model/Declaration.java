package model;

public class Declaration {
	public String varName;
	public String dataType;
	public Values defaultValue;
	public boolean covered ;
	
	public Declaration(String varName, String dataType) {
		this.varName = varName;
		this.dataType = dataType;
		covered = false;
		if(this.dataType.equals("BOOLEAN")) {
			this.defaultValue = new ValueBool(false);
		}
		else if (this.dataType.equals("INT")) {
			this.defaultValue = new ValueNum(0);
		}
		else if (this.dataType.equals("DOUBLE")) {
			this.defaultValue = new ValueDouble((double)0);
		}
		else if (this.dataType.equals("STRING")) {
			this.defaultValue = new ValueString("");
		}
		else if (this.dataType.equals("CHAR")) {
			this.defaultValue = new ValueChar('\u0000');
		}
		
	}
	
	@Override
	public String toString() {
		return varName + " << " + dataType;
	}
	
}
