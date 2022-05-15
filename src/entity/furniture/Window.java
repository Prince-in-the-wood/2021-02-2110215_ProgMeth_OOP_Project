package entity.furniture;

import entity.base.Furniture;
import entity.base.Lockable;
import entity.base.Openable;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class Window extends Furniture implements Openable{

	private boolean isOpened;
	private String imageString;

	public Window(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		setIsOpened(false);
		setImageString(name);
	}

	@Override
	public void open() {
		setImageString("OpenedWindow");
		setIsOpened(true);
	}

	@Override
	public boolean isOpened() {
		return isOpened;
	}


	@Override
	public void close() {
		setImageString(this.getName());
		setIsOpened(false);
	}

	@Override
	public void observe() {
		if( this.isOpened() )
			this.close();
		else
			this.isOpened();
		
		DialoguePane.setGameText("Why everything is silent?");
	}
	// setter and getter

	public void setIsOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.furnitureSprite.get(this.getImageString()), this.getxPosition(), this.getyPosition());
	}
	

}
