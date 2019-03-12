package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location{
	String cellName = "";
	private int row, col;
	
    public SpreadsheetLocation(String cellName){
    	this.cellName = cellName;
    	col = cellName.toUpperCase().charAt(0) - 65;
    	row = Integer.parseInt(cellName.substring(1)) - 1;
    }
    
	@Override
    public int getRow(){
        return row;
    }

    @Override
    public int getCol(){
        return col;
    }

}
