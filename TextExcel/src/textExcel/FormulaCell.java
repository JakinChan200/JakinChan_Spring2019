package textExcel;

public class FormulaCell extends RealCell{
	private String formula;
	
	public FormulaCell(String formula) {
		super(formula);
		this.formula = formula;
	}
	
	public double getDoubleValue(String equation){
		String[] equationParts = equation.split(" ");
		double finalValue = Double.parseDouble(equationParts[1]);
		for(int i = 1; i < equationParts.length - 2; i+=2){
			switch(equationParts[i+1]){
				case "+":
					finalValue += Double.parseDouble(equationParts[i+2]);
					break;
				case "-":
					finalValue -= Double.parseDouble(equationParts[i+2]);
					break;
				case "*":
					finalValue *= Double.parseDouble(equationParts[i+2]);
					break;
				default:
					finalValue /= Double.parseDouble(equationParts[i+2]);
			}
		}
		return finalValue;
	}
	
	public String fullCellText() {
		return formula;
	}
	
	public String abbreviatedCellText() {
		String formula2 = getDoubleValue(formula) + "          ";
		return formula2.substring(0, 10);
	}
}
