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
		String value = percent.substring(percent.length() - 2);
		return Double.parseDouble(value);
	}
	
	public String fullCellText() {
		return fullPercent;
	}
	
	public String abbreviatedCellText() {
		percent *= 100;
		String percent2 = percent + "";
		String[] percentParts = percent2.split(".");
		
		if(percentParts[0].length() < 10) {
			for(int i = percentParts[0].length(); i < 10; i++) {
				percentParts[0] += " ";
			}
		}else {
			percentParts[0] = percentParts[0].substring(0, 9);
		}
		
		return (int)percent + "%";
	}

}
