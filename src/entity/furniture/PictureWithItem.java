package entity.furniture;

import java.util.ArrayList;

import entity.base.Item;
import entity.item.Key;
import entity.item.Note;
import entity.item.PocketKnife;
import gui.DialoguePane;
import logic.Player;

public class PictureWithItem extends Picture{
	
	private ArrayList<Item> itemBehind;
	private boolean isReveal;
	private boolean isSafeBehind;
	private boolean isLocked;
	
	public PictureWithItem(String name, int xPosition, int yPosition, int z, String description) {
		super(name, xPosition, yPosition, z, description);
		
		itemBehind = new ArrayList<Item>();
		setIsSafeBehind(false);
		setIsLocked(false);
		setIsReveal(false);
	}
	

	@Override
	public void observe() {
		
		if( isSafeBehind )
			observeWithSafe();
		else 
			observeBehind();
	}
	
	private void observeWithSafe() {
		if( !isReveal ) {
			
			setIsReveal(true);
			this.setImageString("ClosedSafe");
			DialoguePane.setGameText("There is a safe behind.");
			
		}else if( isLocked ) {
			
			DialoguePane.setGameText("It's locked");
			
		}else {
			
			observeBehind();
		
		}
	}
	
	private void observeBehind() {
		
		if( itemBehind.size() > 0 ) {
			
			for( int i = itemBehind.size() - 1 ; i >= 0 ; i-- ) {
				
				if( itemBehind.get(i) instanceof Note ) {
				
					((Note)itemBehind.get(i)).read();
				
				}else if( itemBehind.get(i) instanceof PocketKnife ) {
					
					((PocketKnife)itemBehind.get(i)).pick();
					itemBehind.remove(i);
					
				}else if( itemBehind.get(i) instanceof Key ) {
				
					((Key)itemBehind.get(i)).pick();
					itemBehind.remove(i);
				
				}
			}
			
		}else {
			DialoguePane.setGameText("I never thought items can hide here");
		}
		
	}
	
	@Override
	public void useItem() {
		if( this.isSafeBehind() && this.isReveal() && this.isLocked() )
			unlock();
		else
			super.useItem();
	}
	
	private void unlock() {
		Item itemInHand = Player.getItemInHand();
		
		if( itemInHand instanceof Key && ((Key)itemInHand).useWith(this) ) {
			
			setIsLocked(false);
			this.setImageString("OpenedSafe");
			
			for( int i = itemBehind.size() - 1 ; i >= 0 ; i-- ) {
				itemBehind.get(i).setIsVisible(true);
			}
			
		}else {
			DialoguePane.setGameText("I think it doesn't fit here.");
		}
	}
	
	

	public ArrayList<Item> getItemBehind() {
		return itemBehind;
	}

	public void setItemBehind(ArrayList<Item> itemBehind) {
		this.itemBehind = itemBehind;
	}

	public boolean isReveal() {
		return isReveal;
	}

	public void setIsReveal(boolean isReveal) {
		this.isReveal = isReveal;
	}

	public boolean isSafeBehind() {
		return isSafeBehind;
	}

	public void setIsSafeBehind(boolean isSafeBehind) {
		this.isSafeBehind = isSafeBehind;
	}


	public boolean isLocked() {
		return isLocked;
	}


	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}	
	
}
