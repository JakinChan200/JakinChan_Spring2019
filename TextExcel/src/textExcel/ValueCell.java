package textExcel;

public class ValueCell extends RealCell{
	private double value;
	
	public ValueCell(String input) {
		super(input);
	}
	
	public double getDoubleValue(String text) {
		return 5;
	}
	
	public String fullCellText(String text) {
		return text;
	}
	
	public String abbreviatedCellText() {
		value *= 100;
		return (int)value + "%";
	}
}
