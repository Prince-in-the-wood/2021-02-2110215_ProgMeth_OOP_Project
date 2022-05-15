package entity.furniture;

import entity.base.Updateable;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;
import entity.base.Furniture;

public class TableWithLamp extends Furniture implements Updateable{
	
	private boolean isUpdated;
	private String imageString;

	public TableWithLamp(String name, int xPosition, int yPosition) {
		
		super(name, xPosition, yPosition);
		setIsUpdated(false);
	}

	@Override
	public void update() {
		
		if(isUpdated()) {
			setImageString(this.getName());
			setIsUpdated(false);
		}else {
			setImageString("TableWithOpenedLamp");
			setIsUpdated(true);
		}
		
	}
	
	@Override
	public void observe() {
		super.observe();
		update();
	}

	@Override
	public boolean isUpdated() {
		return isUpdated;
	}
	
	public void setIsUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
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
