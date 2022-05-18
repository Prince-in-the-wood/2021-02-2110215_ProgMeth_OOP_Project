package entity.furniture;

import java.util.ArrayList;

import entity.base.Container;
import entity.base.Item;
import entity.base.Lockable;
import entity.base.Openable;
import entity.item.Key;
import entity.item.Note;
import entity.item.PocketKnife;
import gui.DialoguePane;
import gui.ItemInHandBox;
import javafx.scene.canvas.GraphicsContext;
import logic.GameController;
import logic.Player;
import sharedObject.RenderableHolder;

public class Cupboard extends Container implements Lockable, Openable{

	private boolean isLocked;
	private boolean isOpened;
	private ArrayList<Item> item;
	
	public Cupboard(String name, int xPosition, int yPosition, int z ) {
		super(name, xPosition, yPosition, z);
		
		item  = new ArrayList<Item>();
		setIsLocked(true);
		setIsOpened(false);
	}


	@Override
	public void open() {
		if( this.isLocked() ) {
			DialoguePane.setGameText("It's locked");
			RenderableHolder.soundFX.get("Lock").play();
		}else {
			this.setIsOpened(true);
			this.setImageString("OpenedCupboard");

			RenderableHolder.soundFX.get("OpenCupboard").play();	
			
			if( item.size() > 0 ) {
				for( int i = item.size() - 1 ; i >= 0 ; i-- ) 
					item.get(i).setIsVisible(true);
			}
		}
	}
	
	@Override
	public void close() {
		this.setIsOpened(false);
		this.setImageString(this.getName());
		RenderableHolder.soundFX.get("CloseCupboard").play();
		if( item.size() > 0 ) {
			for( int i = item.size() - 1 ; i >= 0 ; i-- ) 
				item.get(i).setIsVisible(false);
		}
	}


	@Override
	public boolean isOpened() {
		return isOpened;
	}

	@Override
	public boolean isLocked() {
		return isLocked;
	}

	@Override
	public void unlock() {
		Item itemInHand = Player.getItemInHand();
		
		if( itemInHand instanceof Key && ((Key)itemInHand).useWith(this) ) {
			
			setIsLocked(false);
			this.open();
			
		}else {
			DialoguePane.setGameText("I think it doesn't fit here.");
		}
	}	
	
	@Override
	public void useItem() {
		if( this.isLocked() )
			unlock();
		else
			super.useItem();
			
	}
	
	@Override
	public void observe() {
		if( isOpened() && item.size() <= 1 ) {
			close();
			return;
		}
		
		if( !this.isOpened() )
			open();
		
		
		if( isLocked() )
			return;
		
		if( item.size() > 0 ) {
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
			DialoguePane.setGameText("It's just an empty cupboard.");
		}
	}


	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public void setIsOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}


	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}
	
	

}
