package entity.item;

import entity.base.Item;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;


public class Note extends Item {
	
	private String textOnNote;
	private String imageString; // for note with doll
	
	public Note(String name, double xPosition, double yPosition, int z, String textOnNote) {
		super(name, xPosition, yPosition, z);
		super.setIsVisible(false);
		setTextOnNote(textOnNote);	
		imageString = "";
	}

	//getter and setter
	public String getTextOnNote() {
		return textOnNote;
	}

	public void setTextOnNote(String textOnNote) {
		this.textOnNote = textOnNote;
	}
	
	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}

	public void read() {
		DialoguePane.setGameText(textOnNote);
	}
	

	@Override
	public void draw(GraphicsContext gc) {
		
		if( this.imageString.isEmpty() )
			return;
		
		gc.drawImage(RenderableHolder.itemSprite.get(this.imageString) , this.getxPosition(), this.getyPosition());
	}

	
}
