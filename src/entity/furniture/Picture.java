package entity.furniture;

import entity.base.Furniture;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class Picture extends Furniture {

	private String description;
	
	public Picture(String name, int xPosition, int yPosition, String description) {
		super(name, xPosition, yPosition);

		setDescription(description);
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public void observe() {
		DialoguePane.setGameText(this.getDescription());
	}
	

}
