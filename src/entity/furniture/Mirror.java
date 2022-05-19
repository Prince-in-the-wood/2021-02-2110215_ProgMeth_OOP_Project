package entity.furniture;

import entity.base.Updateable;
import entity.item.Key;
import entity.item.Note;
import entity.item.PocketKnife;
import gui.DialoguePane;
import gui.room.Garden;
import logic.GameController;
import sharedObject.RenderableHolder;

import java.util.ArrayList;

import entity.base.Container;
import entity.base.Item;


public class Mirror extends Container implements Updateable {

	private boolean isUpdated;
	
	public Mirror(String name, int xPosition, int yPosition, int z) {
		super(name, xPosition, yPosition, z);
		
		isUpdated = false;
	}


	@Override
	public void update() {
		
		ArrayList<Item> item = this.getItem();
		
		setImageString("BehindMirror");
		
		RenderableHolder.soundFX.get("BreakingGlass").play();
		
		for( int i = item.size() - 1 ; i >= 0 ; i-- ) {
			item.get(i).setIsVisible(true);
		}
		
		setIsUpdated(true);
		DialoguePane.setGameText("My face... Oh, am I Anna? Why…? Why am I here?");
	}
	
	public void observe() {
		
		if( !this.isUpdated() ) {
			this.update();
		}else{ 
			
			ArrayList<Item> item = this.getItem();
			
			if( item.size() > 0 ) 
			{
				for( int i = item.size() - 1 ; i >= 0 ; i-- ) {
					
					if( item.get(i) instanceof Note ) {
						
						((Note)item.get(i)).read();
					
					}else if( item.get(i) instanceof PocketKnife ) {
						
						((PocketKnife)item.get(i)).pick();
						item.remove(i);
				
					}else if( item.get(i) instanceof Key ) {
						
						((Key)item.get(i)).pick();
						item.remove(i);
					
					}
				}
			}else {
				DialoguePane.setGameText("It's broken...");
			}
		}
	}

	@Override
	public boolean isUpdated() {
		return isUpdated;
	}

	public void setIsUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
		
		if( GameController.getCurrentRoom() instanceof Garden )
			((Garden)GameController.getCurrentRoom()).setUpdate();
	}	
	
	
}
