package entity.furniture;

import java.util.ArrayList;

import entity.base.Furniture;
import entity.base.Item;

public class Picture extends Furniture {
	
	private boolean isSomethingBehind;
	private ArrayList<Item> thingBehind;
	
	public Picture(String name, int xPosition, int yPosition, boolean isSomethingBehind) {
		super(name, xPosition, yPosition);
		setIsSomethingBehind(isSomethingBehind);
		thingBehind = new ArrayList<Item>();
	}
	
	
	//getter and setter
	
	public boolean isSomethingBehind() {
		return isSomethingBehind;
	}

	public void setIsSomethingBehind(boolean isSomethingBehind) {
		this.isSomethingBehind = isSomethingBehind;
	}


	public ArrayList<Item> getThingBehind() {
		return thingBehind;
	}


	public void setThingBehind(ArrayList<Item> thingBehind) {
		this.thingBehind = thingBehind;
	}
	

}
