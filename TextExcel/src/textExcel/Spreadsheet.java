package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{
	private int row, col;
	private int[][] spreadsheet = new int[20][12];
	
	public Spreadsheet() {
		int[] rows = new int[20];
	}
	
	@Override
	public String processCommand(String command){
		return null;
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
		return null;
	}

	@Override
	public String getGridText(){
		// TODO Auto-generated method stub
		return null;
	}
}
