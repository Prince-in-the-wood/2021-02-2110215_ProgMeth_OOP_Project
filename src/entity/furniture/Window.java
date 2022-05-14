package entity.furniture;

import entity.base.Furniture;
import entity.base.Lockable;
import entity.base.Openable;

public class Window extends Furniture implements Openable{

	private boolean isOpened;

	public Window(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		setOpened(false);
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOpened() {
		// TODO Auto-generated method stub
		return isOpened;
	}


	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	
	// setter and getter

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

}
