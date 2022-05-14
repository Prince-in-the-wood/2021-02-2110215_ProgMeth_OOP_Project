package entity.item;

import entity.base.Furniture;
import entity.base.Item;
import entity.base.Pickable;
import gui.ItemInHandBox;
import sharedObject.RenderableHolder;

public class PocketKnife extends Item implements Pickable{

	private boolean isPicked;
	private Furniture matchedFurniture;
	
	public PocketKnife(String name, Furniture matchedFurniture) {
		super(name);
		
		setMatchedFurniture(matchedFurniture);
		setIsPicked(false);
		
	}

	
	@Override
	public void pick() {
		ItemInHandBox.setImageInBox(RenderableHolder.itemSprite.get("PocketKnife") );
		setIsPicked(true);
		super.setIsVisible(false);
	}

	@Override
	public boolean isPicked() {
		return isPicked;
	}
	
	public boolean isMacthed(Furniture furniture) {
		if( furniture.equals(matchedFurniture)) {
			ItemInHandBox.deleteImageInBox();
			setIsPicked(false);
			return true;
		}
		return false;
	}


	//getter and setter

	public void setIsPicked(boolean isPicked) {
		this.isPicked = isPicked;
	}


	public Furniture getMatchedFurniture() {
		return matchedFurniture;
	}


	public void setMatchedFurniture(Furniture matchedFurniture) {
		this.matchedFurniture = matchedFurniture;
	}

}
