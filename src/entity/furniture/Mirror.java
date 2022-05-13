package entity.furniture;

import entity.base.Updateable;
import entity.base.Container;


public class Mirror extends Container implements Updateable {

	private boolean isUpdated;
	
	public Mirror(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		setIsUpdated(false);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUpdated() {
		// TODO Auto-generated method stub
		return isUpdated;
	}


	public void setIsUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

	
}
