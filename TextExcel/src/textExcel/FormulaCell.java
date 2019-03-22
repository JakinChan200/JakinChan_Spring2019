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
		formula = formula + "          ";
		return formula.substring(0, 10);
	}
}
