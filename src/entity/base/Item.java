package entity.base;

import sharedObject.IRenderable;

public class Item implements IRenderable{
	private String name;
	
	public Item(String name) {
		setName(name);
	}

	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
