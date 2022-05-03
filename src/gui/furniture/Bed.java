package gui.furniture;

import gui.base.Furniture;

public class Bed extends Furniture{
	private final String bedURL;
	private final String text;

	public Bed(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		 this.bedURL = "bed.png";
		 this.text = "";						// text for Bed
	}

	//setter and getter
	public String getBedURL() {
		return bedURL;
	}

	public String getText() {
		return text;
	}

}
