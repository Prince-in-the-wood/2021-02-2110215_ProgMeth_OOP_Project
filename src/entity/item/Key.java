package entity.item;

import entity.base.Item;
import entity.base.Pickable;

public class Key extends Item implements Pickable{
	public Key(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.keyURL = "key.png";
		setPicked(false);
	}

	private final String keyURL;
	private boolean isPicked;
	
	@Override
	public void pick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPicked() {
		// TODO Auto-generated method stub
		return isPicked;
	}

	
	//getter and setter
	public String getKeyURL() {
		return keyURL;
	}

	public void setPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}

}
