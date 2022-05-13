package entity.base;
//Abstract Class

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public abstract class Furniture implements IRenderable{
	private String name;
	private double xPosition;
	private double yPosition;
	private int z;
	
	public Furniture(String name, int xPosition, int yPosition) {
		setName(name);
		setxPosition(xPosition);
		setyPosition(yPosition);
	}

	
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String toString() {
		return "This is a normal " + this.name;
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
