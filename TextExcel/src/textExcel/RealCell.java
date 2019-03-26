package textExcel;

public class RealCell implements Cell{
	private String input;
	
	public RealCell(String input) {
		if(input.contains("%")) {
			input = input.substring(0, input.length() - 1);
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
		return "Nay, Thee";
	}

	@Override
	public String fullCellText() {
		return input;
	}

}
