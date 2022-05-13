package entity.base;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Item implements IRenderable{
	
	private String name;
	private double xPosition;
	private double yPosition;
	private int z;
	public boolean isVisible;
	
	public Item(String name) {
		setName(name);
		setIsVisible(false);
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.furnitureSprite.get(this.name) , xPosition, yPosition);
	}

}
