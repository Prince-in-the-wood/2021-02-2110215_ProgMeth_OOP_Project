package entity.furniture;

import entity.base.Furniture;

public class Bed extends Furniture{

	public Bed(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
