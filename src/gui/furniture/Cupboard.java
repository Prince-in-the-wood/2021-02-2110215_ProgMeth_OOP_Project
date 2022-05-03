package gui.furniture;

import java.util.ArrayList;

import gui.base.Containable;
import gui.base.Furniture;
import gui.base.Item;
import gui.base.Lockable;
import gui.base.Openable;

public class Cupboard extends Furniture implements Lockable, Containable, Openable{
	private final String closedCupboardURL;
	private final String openedCupboardURL;
	private String text;
	private boolean isLocked;
	private boolean isOpened;
	private boolean isContaining;
	private ArrayList<Item> item;
	
	
	public Cupboard(String name, int xPosition, int yPosition, String text) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.closedCupboardURL = "closedCupboard.png";
		this.openedCupboardURL = "openedCupboard.png";
		this.text = text;
		setLocked(true);
		setOpened(false);
		setContaining(false);
		
	}


	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOpened() {
		// TODO Auto-generated method stub
		return isOpened;
	}

	@Override
	public void contain() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isContaining() {
		// TODO Auto-generated method stub
		return isContaining;
	}

	@Override
	public void lock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLocked() {
		// TODO Auto-generated method stub
		return isLocked;
	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	
	
	//getter and setter
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	public String getClosedCupboardURL() {
		return closedCupboardURL;
	}

	public String getOpenedCupboardURL() {
		return openedCupboardURL;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	public void setContaining(boolean isContaining) {
		this.isContaining = isContaining;
	}


}
