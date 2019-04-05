package textExcel;

public class RealCell implements Cell, Comparable<Cell>{
	private double input;
	Cell[][] sheet;
	
	public RealCell(String input, Cell[][] sheet) {
		this.sheet = sheet;
		if(input.contains("%")) {
			input = input.substring(0, input.length() - 1);
			this.input = getDoubleValue(input);
		}else if(input.contains("(")) {
			this.input = getDoubleValue(input);
		}else {
			this.input = getDoubleValue(input);
		}
	}
	
	public double getDoubleValue(String input) {
		return Double.parseDouble(input);
	}
	
	@Override
	public String abbreviatedCellText() {
		String formula2 = input + "          ";
		return formula2.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return "Nay, Thee";
	}

	@Override
	public int compareTo(Cell o) {
		return 0;
	}

}
