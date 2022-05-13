package entity.item;

import entity.base.Item;


public class Note extends Item {
	private final String noteURL;
	private String textOnNote;
	
	public Note(String textOnNote) {
		super(textOnNote);
		// TODO Auto-generated constructor stub
		
		this.noteURL = "note.png";
		
	}

	//getter and setter
	public String getTextOnNote() {
		return textOnNote;
	}

	public void setTextOnNote(String textOnNote) {
		this.textOnNote = textOnNote;
	}

	public String getNoteURL() {
		return noteURL;
	}
	
}
