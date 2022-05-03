package gui.base;
//Abstract Class

public abstract class Furniture {
	private String name;
	private int xPosition;
	private int yPosition;
	
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

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}
	
}
