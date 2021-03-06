/*
 * @author Jakin Chan
 * @version 29 March 2019
 */
package textExcel;

import java.util.ArrayList;

public class Spreadsheet implements Grid{
	private int numRows, numCols;
	private Cell[][] sheet;
	Location loc;
	
	public Spreadsheet() {
		numRows = 20;
		numCols = 12;
		sheet = new Cell [numRows][numCols];
		emptyGrid();	
	}
	
	@Override
	public String processCommand(String command){
		if(command.equals("")){
			return "";
		}
		String[] commandParts = command.split(" ");
		String[] commandParts2 = command.split(" ", 3);
		if(command.length() <= 3) {
			return getCell(new SpreadsheetLocation(command)).fullCellText();
		}else if(command.toLowerCase().contains("clear") && commandParts.length <= 2) {
			if(commandParts.length == 2) {
				loc = new SpreadsheetLocation(commandParts[1]);
				sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			}else {
				emptyGrid();
			}
		}else if(commandParts2[1].equals("=")){
			loc = new SpreadsheetLocation(commandParts2[0]);
			if(command.contains("%")) {
				sheet[loc.getRow()][loc.getCol()] = new PercentCell(commandParts2[2], sheet);
			}else if(commandParts2[2].startsWith("(") && commandParts2[2].endsWith(")")) {
				sheet[loc.getRow()][loc.getCol()] = new FormulaCell(commandParts2[2], sheet);
			}else {
				boolean isText = false;
				for(int i = 0; i < commandParts2[2].length(); i++){
					if(commandParts2[2].charAt(i) >= 65 || commandParts2[2].charAt(i) == '"'){
						sheet[loc.getRow()][loc.getCol()] = new TextCell(commandParts2[2]);
						isText = true;
						break;
					}
				}
				if(!isText){
					sheet[loc.getRow()][loc.getCol()] = new ValueCell(commandParts2[2], sheet);
				}
			}
		}else if(commandParts[0].equalsIgnoreCase("sorta") || commandParts[0].equalsIgnoreCase("sortd")){
			sortCells(commandParts);
			return getGridText();
		}else{
				System.out.println("unknown command");
		}
		return getGridText();
	}

	@Override
	public int getRows(){
		return numRows;
	}

	@Override
	public int getCols(){
		return numCols;
	}

	@Override
	public Cell getCell(Location loc){
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String grid = "   |";
		for(int i = 0; i < numCols; i++) {
			grid += (char)(i + 'A') + "         |";
		}
 		
		for(int i = 1; i <= numRows; i++) {
			if(i < 10) {
				grid += "\n" + i + "  |";
			}else {
				grid += "\n" + i + " |";
			}
			
			for(int j = 0; j < numCols; j++) {
				grid += sheet[i-1][j].abbreviatedCellText() + "|";
			}
		}
		return grid + "\n";
	}

	public void emptyGrid() {
		for(int rows = 0; rows < numRows; rows++) {
			for(int cols = 0; cols < numCols; cols++) {
				sheet[rows][cols] = new EmptyCell();
			}
		}
	}
	
	public void sortCells(String[] command){
		ArrayList<Cell> list = new ArrayList<Cell>();
		String[] valueBoundaries = command[1].split("-");
		Location beginningLoc = new SpreadsheetLocation(valueBoundaries[0]);
		Location endingLoc = new SpreadsheetLocation(valueBoundaries[1]);
		list.add(sheet[beginningLoc.getRow()][beginningLoc.getCol()]);
		for(int row = beginningLoc.getRow() + 1; row <= endingLoc.getRow(); row++){
			for(int col = beginningLoc.getCol() + 1; col <= endingLoc.getCol(); col++){
				String tempCellName = ((char)(col + 'A') + row) + "";
				Location tempLoc = new SpreadsheetLocation(tempCellName);
				if(command[0].equalsIgnoreCase("sorta")){
					for(int i = 0; i < list.size() - 1; i++){
						if(getCell(tempLoc).compareTo(list.get(i)) <= 0){
							list.add(i, sheet[row][col]);
							break;
						}else if(i == list.size() - 1){
							list.add(sheet[row][col]);
						}
					}
				}else{
					for(int i = 0; i < list.size() - 1; i++){
						if(getCell(tempLoc).compareTo(list.get(i)) >= 0){
							list.add(i, sheet[row][col]);
							break;
						}else if(i == list.size() - 1){
							list.add(sheet[row][col]);
						}
					}
				}
			}
		}
		int index = 0;
		for(int row = beginningLoc.getRow() + 1; row <= endingLoc.getRow(); row++){
			for(int col = beginningLoc.getCol() + 1; col <= endingLoc.getCol(); col++){
				
			}
		}
	}
}