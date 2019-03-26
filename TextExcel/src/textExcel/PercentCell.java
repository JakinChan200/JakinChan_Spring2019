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
			wholeNum = (int)percent + "%         ";
		}else {
			wholeNum = percent + "%          ";
		}
		return wholeNum.substring(0, 10);
	}
}
