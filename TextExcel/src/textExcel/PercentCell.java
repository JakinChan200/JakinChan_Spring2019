package textExcel;

public class PercentCell extends RealCell{
	private double percent;
	private String fullPercent;
	
	public PercentCell(String fullPercent) {
		super(fullPercent);
		this.fullPercent = fullPercent;
		this.percent = getDoubleValue(fullPercent);
	}
	
	public double getDoubleValue(String percent) {
		String value = percent.substring(0, percent.length() - 1);
		return Double.parseDouble(value);
	}
	
	public String fullCellText() {
		return fullPercent;
	}
	
	public String abbreviatedCellText() {
		String wholeNum;
		String percent2 = percent + "";
		if(percent2.contains(".")) {
			String[] percentParts = percent2.split(".");
			System.out.println(percentParts.length);
			for(int i = 0; i < percentParts.length - 1; i++) {
				System.out.println(percentParts[i]);
			}
			//System.out.println(percentParts);
			wholeNum = "123445678910";//.percentParts[0] + "%         ";
			wholeNum = wholeNum.substring(0, 9);
		}else {
			wholeNum = percent + "%          ";
			wholeNum = wholeNum.substring(0, 9);
		}
		return wholeNum;
	}

}
