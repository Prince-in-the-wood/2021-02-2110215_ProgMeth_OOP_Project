package entity.furniture;

import entity.base.Updateable;
import entity.base.Furniture;

public class TableWithLamp extends Furniture implements Updateable{


	public TableWithLamp(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUpdated() {
		// TODO Auto-generated method stub
		return false;
	}


}
