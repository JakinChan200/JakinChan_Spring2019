/*
 * 
 * @author Jakin Chan
 * @version 29 March 2019
 */

package textExcel;

public class FormulaCell extends RealCell{
	
	public FormulaCell(String formula, Cell[][] sheet) {
		super(formula, sheet);
	}
	
	public double getDoubleValue(String equation){
		String[] equationParts = equation.split(" ");
		String[] valueBoundaries = equationParts[2].split("-");
		if(equation.contains("-") && (equationParts.length == 4)){
			double sum = 0;
			double counter = 0;
			Location beginningLoc = new SpreadsheetLocation(valueBoundaries[0]);
			Location endingLoc = new SpreadsheetLocation(valueBoundaries[1]);
			for(int row = beginningLoc.getRow(); row <= endingLoc.getRow(); row++){
				for(int col = beginningLoc.getCol(); col <= endingLoc.getCol(); col++){
					sum += Double.parseDouble(sheet[row][col].abbreviatedCellText());
					if(equationParts[1].toUpperCase().equals("AVG")){
						counter++;
					}
				}
			}
			if(equationParts[1].toUpperCase().equals("AVG")){
				return sum / counter;
			}else{
				return sum;
			}
		}else{
			double finalValue = getValue(equationParts[1]);
			for(int i = 1; i < equationParts.length - 2; i+=2){
				finalValue = operation(finalValue, equationParts[i+1], equationParts[i+2]);
			}
			return finalValue;
		}
	}
	
	
	public double operation(double firstValue, String operator, String secondValue) {
		switch(operator){
			case "+":
				firstValue += getValue(secondValue);
				break;
			case "-":
				firstValue -= getValue(secondValue);
				break;
			case "*":
				firstValue *= getValue(secondValue);
				break;
			default:
				firstValue /= getValue(secondValue);
		}
		return firstValue;
	}
	
	public double getValue(String value) {
		if(value.charAt(0) >= 65) {
			Location loc = new SpreadsheetLocation(value);
			return Double.parseDouble(sheet[loc.getRow()][loc.getCol()].abbreviatedCellText());
		}else {
			return Double.parseDouble(value);
		}
	}
	
	public String abbreviatedCellText() {
		String formula2 = getDoubleValue(origUserInput) + "          ";
		return formula2.substring(0, 10);
	}
}