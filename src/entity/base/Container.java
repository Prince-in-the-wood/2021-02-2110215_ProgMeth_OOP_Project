package entity.base;

import java.util.ArrayList;

public abstract class Container extends Furniture{
	
	private ArrayList<Item> item;
	
	public Container(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		
		item = new ArrayList<Item>();
	}
	
	public boolean isContaining() {
		return item.size() != 0;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}
	
}
