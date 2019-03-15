package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	private int row, col;
	private Cell[][] sheet;
	
	public Spreadsheet() {
		row = 20;
		col = 12;
		sheet = new Cell [row][col];
		for(int rows = 0; rows < row; rows++) {
			for(int cols = 0; cols < col; cols++) {
				sheet[rows][cols] = new EmptyCell();
			}
		}		
	}
	
	@Override
	public String processCommand(String command){
		command = command.toLowerCase();
		if(command.length() <= 3) {
			return sheet[Integer.parseInt(command.substring(1))][command.charAt(0)-65].fullCellText();
		}else if(command.equals("clear")) {
			return getGridText();
		}else {
			String[] commandParts = command.split(" ");
			sheet[Integer.parseInt(commandParts[0].substring(1))][commandParts[0].charAt(0)-65] = commandParts[2];
			return getGridText();
		}
	}

	@Override
	public int getRows(){
		return row;
	}

	@Override
	public int getCols(){
		return col;
	}

	@Override
	public Cell getCell(Location loc){
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String grid = "  ";
		for(int i = 0; i < col; i++) {
			grid += "|" + (char)(i + 'A') + "         ";
		}
 		
		for(int i = 1; i <= row; i++) {
			if((i - 10) < 0) {
				grid += "|\n" + i + " ";
			}else {
				grid += "|\n" + i;
			}
			
			for(int j = 0; j < col; j++) {
				grid += "|          ";
			}
		}
		grid += "|";
		return grid;
	}
}
