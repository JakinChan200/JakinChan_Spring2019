package textExcel;

public class FormulaCell extends RealCell{
	private String formula;
	
	public FormulaCell(String formula) {
		super(formula);
		this.formula = formula;
	}
	
	public String fullCellText(String text) {
		return formula;
	}
	
	public String abbreviatedCellText(String text) {
		return text;
	}
}
