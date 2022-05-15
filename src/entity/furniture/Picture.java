package entity.furniture;

import entity.base.Furniture;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class Picture extends Furniture {

	private String description;
	private String imageString;
	
	public Picture(String name, int xPosition, int yPosition, String description) {
		super(name, xPosition, yPosition);
		setImageString(name);
		setDescription(description);
	}
	
	
	public String getImageString() {
		return imageString;
	}


	public void setImageString(String imageString) {
		this.imageString = imageString;
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
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.furnitureSprite.get(this.imageString) , super.getxPosition(), super.getyPosition());
	}


	

}
