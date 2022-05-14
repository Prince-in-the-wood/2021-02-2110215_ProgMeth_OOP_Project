package entity.item;

import entity.base.Item;
import gui.DialoguePane;


public class Note extends Item {
	
	private String textOnNote;
	
	public Note(String name, String textOnNote) {
		super(name);
		super.setIsVisible(false);
		setTextOnNote(textOnNote);	
	}

	//getter and setter
	public String getTextOnNote() {
		return textOnNote;
	}

	public void setTextOnNote(String textOnNote) {
		this.textOnNote = textOnNote;
	}
	
	public void read() {
		DialoguePane.setGameText(textOnNote);
	}
	
}
