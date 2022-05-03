package gui.item;

import gui.base.Item;
import gui.base.Pickable;

public class PocketKnife extends Item implements Pickable{
	private final String pocketKnifeURL;
	private boolean isPicked;
	
	public PocketKnife(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		
		this.pocketKnifeURL = "pocketKnife.png";
		setPicked(false);
		
	}

	
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
	public String getPocketKnifeURL() {
		return pocketKnifeURL;
	}


	public void setPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}

}
