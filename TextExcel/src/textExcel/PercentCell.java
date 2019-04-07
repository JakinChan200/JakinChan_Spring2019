package textExcel;

public class PercentCell extends RealCell{
	
	public PercentCell(String fullPercent, Cell[][] sheet) {
		super(fullPercent, sheet);
	}
	
	public double getDoubleValue(String percent) {
		String value = percent.substring(0, percent.length() - 1);
		return Double.parseDouble(value);
	}
	
	public String fullCellText() {
		return (cellValue /= 100) + "";
	}
	
	public String abbreviatedCellText() {
		String wholeNum;
		String percent2 = cellValue + "";
		if(percent2.contains(".")) {
			String[] percentParts = percent2.split("\\."); // apparently the period has a special escape sequence b/c it means something, so you have to use the two backslashes
			wholeNum = percentParts[0] + "%         ";
		}else {
			wholeNum = cellValue + "%          ";
		}
		wholeNum = wholeNum.substring(0, 10);
		return wholeNum;
	}
}
