package entity.furniture;

import entity.base.Furniture;

public class Chair extends Furniture{

	public Chair(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub

	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
