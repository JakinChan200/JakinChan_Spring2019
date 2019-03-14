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
		return "";
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
		// TODO Auto-generated method stub
		return null;
	}
}
