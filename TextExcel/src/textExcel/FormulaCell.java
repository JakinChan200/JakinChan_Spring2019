package textExcel;

public class FormulaCell extends RealCell{
	private String formula;
	
	public FormulaCell(String formula) {
		super(formula);
		this.formula = formula;
	}
	
	public String fullCellText() {
		return formula;
	}
	
	public String abbreviatedCellText() {
		return formula;
	}
}
