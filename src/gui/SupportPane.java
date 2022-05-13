package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SupportPane extends VBox{
	private Text headerText;
	private Text contentText;
	private Button button;
	
	public SupportPane() {
		
	}

	//getter and setter
	public Text getHeaderText() {
		return headerText;
	}

	public void setHeaderText(Text headerText) {
		this.headerText = headerText;
	}

	public Text getContentText() {
		return contentText;
	}

	public void setContentText(Text contentText) {
		this.contentText = contentText;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	
	
}
