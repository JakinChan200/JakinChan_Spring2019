package textExcel;

public class RealCell implements Cell{
	private String input;
	
	public RealCell(String input) {
		if(input.contains("%")) {
			input = input.substring(input.length() - 1);
			this.input = input;
		}else if(input.contains("(")) {
			this.input = input;
		}else {
			this.input = input;
		}
	}
	
	public double getDoubleValue(String input) {
		return Double.parseDouble(input);
	}
	
	@Override
	public String abbreviatedCellText() {
		return null;
	}

	@Override
	public String fullCellText() {
		return input;
	}

}
