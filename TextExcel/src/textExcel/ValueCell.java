package textExcel;

public class ValueCell extends RealCell{
	private double value;
	
	public ValueCell(String input) {
		super(input);
		value = getDoubleValue(input);
	}
	
	public double getDoubleValue(String text) {
		double decimalText = Double.parseDouble(text);
		return decimalText;
	}
	
	public String fullCellText() {
		return value + "";
	}
	
	public String abbreviatedCellText() {
		value = (double)value;
		String value2 = value + "";
		
		if(value2.length() < 10) {
			for(int i = value2.length(); i < 10; i++) {
				value2 += " ";
			}
		}else {
			value2 = value2.substring(0, 10);
		}
		return value2 + "";
	}
}
