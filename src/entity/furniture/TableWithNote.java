package entity.furniture;

import java.util.ArrayList;

import entity.base.Container;
import entity.base.Item;
import entity.item.Key;
import entity.item.Note;
import entity.item.PocketKnife;

public class TableWithNote extends Container{

	public TableWithNote(String name, int xPosition, int yPosition, int z ) {
		super(name, xPosition, yPosition, z );
	}
	
	@Override
	public void observe() {
		
		ArrayList<Item> item = this.getItem();
		
		if(item.size() >= 0 ) {
			
			for( int i = item.size() - 1 ; i >= 0 ; i++ ) {
				if( item.get(i) instanceof Note ) {
					((Note)item.get(i)).read();
				}
				
				if( item.get(i) instanceof PocketKnife ) {
					((PocketKnife)item.get(i)).pick();
					item.remove(i);
				}
				
				if( item.get(i) instanceof Key ) {
					((Key)item.get(i)).pick();
					item.remove(i);
				}
			}
		}else{
			super.observe();
		}
	}

}
