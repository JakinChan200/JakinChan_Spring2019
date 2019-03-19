package textExcel;

public class PercentCell extends RealCell{

	public PercentCell(String input) {
		super(input);
	}
	
	public String fullCellText(String text) {
		return text;
	}
	
	public String abbreviatedCellText(String text) {
		return text;
	}

}
