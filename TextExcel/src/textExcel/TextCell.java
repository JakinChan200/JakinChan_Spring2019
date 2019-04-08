/*
 * @author Jakin Chan
 * @version 29 March 2019
 */

package textExcel;

public class TextCell implements Cell, Comparable<Cell>{
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	
	@Override
	public String abbreviatedCellText() {
		String abbrevText = text;
		if(text.startsWith("\"")) {
			abbrevText = text.substring(1, text.length() - 1);
		}
		abbrevText += "           ";
		return abbrevText.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		return text;
	}

	@Override
	public int compareTo(Cell o) {
		/*for(int i = 0; i < t) {
			
		}*/
		return 0;
	}
}