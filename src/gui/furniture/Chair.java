package gui.furniture;

import gui.base.Furniture;

public class Chair extends Furniture{
	private final String chairURL;
	private final String text;

	public Chair(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.chairURL = "chair.png";
		this.text = "";						// chair text
	}

}
