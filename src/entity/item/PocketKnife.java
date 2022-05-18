package entity.item;

import entity.base.Furniture;
import entity.base.Item;
import entity.base.Pickable;
import gui.ItemInHandBox;
import logic.Player;
import sharedObject.RenderableHolder;

public class PocketKnife extends Item implements Pickable{

	private boolean isPicked;
	private Furniture matchedFurniture;
	
	public PocketKnife(String name, double xPosition, double yPosition, int z, Furniture matchedFurniture) {
		super(name, xPosition, yPosition, z);
		
		setMatchedFurniture(matchedFurniture);
		setIsPicked(false);
		
	}

	
	@Override
	public void pick() {
		ItemInHandBox.setImageInBox(RenderableHolder.itemSprite.get("PocketKnife") );
		Player.setItemInHand(this);
		setIsPicked(true);
		super.setIsVisible(false);
		
		RenderableHolder.soundFX.get("PickItem").play();
	}

	@Override
	public boolean isPicked() {
		return isPicked;
	}
	
	public boolean useWith(Furniture furniture) {
		if( furniture.equals(matchedFurniture)) {
			ItemInHandBox.deleteImageInBox();
			Player.setItemInHand(null);
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
