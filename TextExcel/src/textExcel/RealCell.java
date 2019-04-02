package textExcel;

public class RealCell implements Cell, Comparable<Cell>{
	private double input;
	private String value;
	
	public RealCell(String input) {
		if(input.contains("%")) {
			input = input.substring(0, input.length() - 1);
			this.input = getDoubleValue(input);
		}else if(input.contains("(")) {
			this.value = input;
		}else {
			this.input = getDoubleValue(input);
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
		return input + "";
	}

	@Override
	public int compareTo(Cell o) {
		return 0;
	}

}
