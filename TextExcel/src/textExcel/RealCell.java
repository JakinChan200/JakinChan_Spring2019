package textExcel;

public class RealCell implements Cell{
	private String input;
	
	public RealCell(String input) {
		this.input = input;
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
