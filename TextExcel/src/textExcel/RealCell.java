package textExcel;

public class RealCell implements Cell, Comparable<Cell>{
	String origUserInput;
	double cellValue;
	Cell[][] sheet;
	
	public RealCell(String input, Cell[][] sheet) {
		origUserInput = input;
		this.sheet = sheet;
		this.cellValue = getDoubleValue(input);
	}
	
	public double getDoubleValue(String input) {
		return Double.parseDouble(input);
	}
	
	@Override
	public String abbreviatedCellText() {
		String fullCellText = cellValue + "          ";
		return fullCellText.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return origUserInput;
	}
	
	public double getCellValue() {
		return cellValue;
	}

	@Override
	public int compareTo(Cell cell) {
		if(cellValue > ((RealCell) cell).getCellValue()){
			return 1;
		}else if(cellValue < ((RealCell) cell).getCellValue()) {
			return -1;
		}else {
			return 0;
		}
	}

}
