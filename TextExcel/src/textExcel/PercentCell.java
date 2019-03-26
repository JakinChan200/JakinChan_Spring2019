package textExcel;

public class PercentCell extends RealCell{
	private double percent;
	
	public PercentCell(String fullPercent) {
		super(fullPercent);
		this.percent = getDoubleValue(fullPercent);
	}
	
	public double getDoubleValue(String percent) {
		String value = percent.substring(0, percent.length() - 1);
		return Double.parseDouble(value);
	}
	
	public String fullCellText() {
		percent /= 100;
		return percent + "";
	}
	
	public String abbreviatedCellText() {
		String wholeNum;
		String percent2 = percent + "";
		if(percent2.contains(".")) {
			String[] percentParts = percent2.split("\\."); // apparently the period has a special escape sequence b/c it means something, so you have to use the two backslashes
			wholeNum = percentParts[0] + "%         ";
			wholeNum = wholeNum.substring(0, 10);
		}else {
			wholeNum = percent + "%          ";
			wholeNum = wholeNum.substring(0, 10);
		}
		return wholeNum;
	}
}
