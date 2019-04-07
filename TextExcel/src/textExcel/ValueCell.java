package textExcel;

public class ValueCell extends RealCell{
	
	public ValueCell(String input, Cell[][] sheet) {
		super(input, sheet);
	}
	
	public double getDoubleValue(String text) {
		return Double.parseDouble(text);
	}
	
	public String fullCellText() {
		return origUserInput + "";
	}
	
	public String abbreviatedCellText() {
		String value = cellValue + "          ";
		return value.substring(0, 10);

	}
}