package textExcel;

public class TextCell implements Cell{
	private String text;
	
	public TextCell(String text) {
		this.text = text;
	}
	
	@Override
	public String abbreviatedCellText() {
		if(text.length() < 10) {
			for(int i = text.length(); i < 10; i++) {
				text += " ";
			}
		}else {
			text = text.substring(0, 9);
		}
		return text;
	}

	@Override
	public String fullCellText() {
		return "";
	}

}
