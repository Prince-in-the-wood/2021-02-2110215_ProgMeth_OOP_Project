package entity.base;
//Abstract Class

import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public abstract class Furniture implements IRenderable{
	private String name;
	private double xPosition;
	private double yPosition;
	private int z;
	private boolean isVisible;
	private String imageString;
	
	public Furniture(String name, int xPosition, int yPosition, int z) {
		setName(name);
		setxPosition(xPosition);
		setyPosition(yPosition);
		setImageString(name);
		setIsVisible(true);
		
		this.z = z;
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
	public boolean isVisible() {
		return isVisible;
	}


	public void setIsVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	
	
	public String getImageString() {
		return imageString;
	}


	public void setImageString(String imageString) {
		this.imageString = imageString;
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
		gc.drawImage(RenderableHolder.furnitureSprite.get(imageString) , xPosition, yPosition);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Furniture other = (Furniture) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(xPosition) != Double.doubleToLongBits(other.xPosition))
			return false;
		if (Double.doubleToLongBits(yPosition) != Double.doubleToLongBits(other.yPosition))
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	
	public void observe() {
		DialoguePane.setGameText(this.toString());
	}
	
	public void useItem() {
		DialoguePane.setGameText("I think it's better to use it somewhere");
	}
	
	
}
