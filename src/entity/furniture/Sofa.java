package entity.furniture;

import java.util.ArrayList;

import entity.base.Cuttable;
import entity.base.Furniture;
import entity.base.Container;
import entity.base.Item;

public class Sofa extends Furniture implements Cuttable{

	private boolean isCut;
	private boolean isSomethingBehind;
	private ArrayList<Item> thingBehind;
	
	public Sofa(String name, int xPosition, int yPosition, boolean isSomethingBehind) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		setCut(false);	
		setIsSomethingBehind(isSomethingBehind);
	}



	@Override
	public void cut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCut() {
		// TODO Auto-generated method stub
		return isCut;
	}


	public void setCut(boolean isCut) {
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
