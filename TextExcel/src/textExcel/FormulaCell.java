package textExcel;

public class FormulaCell extends RealCell{
	private String formula;
	
	public FormulaCell(String formula) {
		super(formula);
		this.formula = formula;
	}
	
	public double getDoubleValue(String equation){
		String[] equationParts = equation.split(" ");
		if(equationParts[1].equals("SUM")) {
			return 0.0;
		}else if(equationParts[1].equals("AVG")) {
			return 0.0;
		}else {
			double finalValue = getValue(equationParts[1]);
			for(int i = 1; i < equationParts.length - 2; i+=2){
				finalValue = operation(finalValue, equationParts[i+1], equationParts[i+2]);
			}
			return finalValue;
		}
	}
	
	public double operation(double firstValue, String operator, String secondValue) {
		double finalValue = firstValue;
		switch(operator){
			case "+":
				finalValue += Double.parseDouble(secondValue);
				break;
			case "-":
				finalValue -= Double.parseDouble(secondValue);
				break;
			case "*":
				finalValue *= Double.parseDouble(secondValue);
				break;
			default:
				finalValue /= Double.parseDouble(secondValue);
		}
		return finalValue;
	}
	
	public double getValue(String value) {
		if(value.charAt(0) >= 65) {
			sheet[][];
		}else {
			return Double.parseDouble(value);
		}
	}
	
	public String fullCellText() {
		return formula;
	}
	
	public String abbreviatedCellText() {
		String formula2 = getDoubleValue(formula) + "          ";
		return formula2.substring(0, 10);
	}
}
