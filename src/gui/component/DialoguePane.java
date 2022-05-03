package gui.component;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class DialoguePane extends Pane{
	private final String dialogueBG_URL;
	private Text gameText;
	
	public DialoguePane() {
		this.dialogueBG_URL = "dialogueBG.png";
	}
	
	//getter and setter
	public String getDialogueBG_URL() {
		return dialogueBG_URL;
	}
	
}
