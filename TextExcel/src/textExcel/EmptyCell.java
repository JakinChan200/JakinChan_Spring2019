/* This class is for an empty cell
 * 
 *@author Jakin Chan
 *@version 4 March 2019
 */
package textExcel;

public class EmptyCell implements Cell{
	
	public EmptyCell() {
		
	}
	
	public String abbreviatedCellText() {
		return "          ";
	}
	
	public String fullCellText() {
		return "";
	}

	@Override
	public int compareTo(Cell cell) {
		return 0;
	}
}
