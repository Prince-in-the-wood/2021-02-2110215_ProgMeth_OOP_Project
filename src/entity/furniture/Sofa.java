package entity.furniture;

import java.util.ArrayList;

import entity.base.Cuttable;
import entity.base.Furniture;
import entity.base.Container;
import entity.base.Item;
import entity.item.Key;
import entity.item.Note;
import entity.item.PocketKnife;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import logic.Player;
import sharedObject.RenderableHolder;

public class Sofa extends Furniture implements Cuttable{

	private boolean isCut;
	private boolean isSomethingBehind;
	private ArrayList<Item> thingBehind;
	
	public Sofa(String name, int xPosition, int yPosition, int z,boolean isSomethingBehind) {
		super(name, xPosition, yPosition, z);		
		
		setIsCut(false);	
		setIsSomethingBehind(isSomethingBehind);
		this.thingBehind = new ArrayList<Item>(); 
	}



	@Override
	public void cut() {
		
		this.setIsCut(true);
		this.setImageString("CutSofa");
		
		for( int i = thingBehind.size() - 1 ; i >= 0 ; i-- ) {
			thingBehind.get(i).setIsVisible(true);
		}
	}

	@Override
	public boolean isCut() {
		return isCut;
	}
	
	@Override
	public void useItem() {
		if( !isSomethingBehind || isCut() )
			super.useItem();
		else {
			Item itemInHand = Player.getItemInHand();
			if( itemInHand instanceof PocketKnife && ((PocketKnife)itemInHand).useWith(this) ) {
				this.cut();
			}else {
				DialoguePane.setGameText("I think it doesn't fit here.");
			}
		}
	}
	
	@Override
	public void observe() {
		if( !isSomethingBehind() ) {
		
			super.observe();
			
		}else if( !isCut() ) {
			
			DialoguePane.setGameText("I think there is something under the sofa");			
		
		}else if( thingBehind.size() > 0 ) {
			
			for( int i = thingBehind.size() - 1 ; i >= 0 ; i-- ) {
				
				if( thingBehind.get(i) instanceof Note ) {
				
					((Note)thingBehind.get(i)).read();
				
				}else if( thingBehind.get(i) instanceof PocketKnife ) {
				
					((PocketKnife)thingBehind.get(i)).pick();
					thingBehind.remove(i);
				
				}else if( thingBehind.get(i) instanceof Key ) {
					
					((Key)thingBehind.get(i)).pick();
					thingBehind.remove(i);
				
				}
			}
		}else {
			
			DialoguePane.setGameText("Little sorry, to make it's torn");			
		
		}

	}
	

	public void setIsCut(boolean isCut) {
		this.isCut = isCut;
	}



	public boolean isSomethingBehind() {
		return isSomethingBehind;
	}



	public void setIsSomethingBehind(boolean isSomethingBehind) {
		this.isSomethingBehind = isSomethingBehind;
	}



	public ArrayList<Item> getThingBehind() {
		return thingBehind;
	}

	public void setThingBehind(ArrayList<Item> thingBehind) {
		this.thingBehind = thingBehind;
	}
	
}
