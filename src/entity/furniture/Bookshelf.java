package entity.furniture;

import java.util.ArrayList;

import entity.base.Container;
import entity.base.Item;

public class Bookshelf extends Container{
	

	public Bookshelf(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

}
