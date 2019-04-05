package textExcel;

public class ValueCell extends RealCell{
	private double value;
	private String input;
	
	public ValueCell(String input, Cell[][] sheet) {
		super(input, sheet);
		this.input = input;
		value = getDoubleValue(input);
	}
	
	public double getDoubleValue(String text) {
		return Double.parseDouble(text);
	}
	
	public String fullCellText() {
		return input;
	}
	
	public String abbreviatedCellText() {
		String value2 = value + "          ";
		return value2.substring(0, 10);

	}
}
