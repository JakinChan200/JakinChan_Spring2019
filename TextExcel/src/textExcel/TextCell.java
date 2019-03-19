package textExcel;

public class TextCell implements Cell{
	private String text, fullText;
	
	public TextCell(String text) {
		this.text = text;
		this.fullText = text;
	}
	
	@Override
	public String abbreviatedCellText() {
		if(text.startsWith("\"")) {
			text = text.substring(1, text.length() - 1);
		}
		
		if(text.length() < 10) {
			for(int i = text.length(); i < 10; i++) {
				text += " ";
			}
		}else {
			text = text.substring(0, 10);
		}
		return text;
	}

	@Override
	public String fullCellText() {
		return fullText;
	}

}
