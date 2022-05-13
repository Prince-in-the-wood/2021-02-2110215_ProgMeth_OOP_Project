package entity.furniture;

import java.util.ArrayList;

import entity.base.Container;
import entity.base.Furniture;
import entity.base.Item;
import entity.base.Lockable;
import entity.base.Openable;

public class Cupboard extends Container implements Lockable, Openable{

	private boolean isLocked;
	private boolean isOpened;
	
	
	public Cupboard(String name, int xPosition, int yPosition, String text) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		setLocked(true);
		setOpened(false);
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


	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}


}
