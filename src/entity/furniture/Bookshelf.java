package entity.furniture;

import java.util.ArrayList;

import entity.base.Container;
import entity.base.Item;
import entity.item.Key;
import entity.item.Note;
import entity.item.PocketKnife;
import gui.DialoguePane;

public class Bookshelf extends Container{
	
	private ArrayList<Item> item;
	private boolean isObserve;
	
	public Bookshelf(String name, int xPosition, int yPosition, int z) {
		super(name, xPosition, yPosition, z);		
		item = new ArrayList<Item>();
		isObserve = false;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}
	
	@Override
	public void observe() {
		if( !isObserve ) {
			isObserve = true;
			
			for( int i = 0 ; i < item.size() ; i++ )
				item.get(i).setIsVisible(true);
			
		}else if( item.size() > 0 ) {
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
			DialoguePane.setGameText("There is a lot of books here, "
									 + "I would love to read if I have time.");
		}
		
	}

}
