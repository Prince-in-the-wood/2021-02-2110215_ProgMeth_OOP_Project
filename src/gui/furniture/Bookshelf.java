package gui.furniture;

import java.util.ArrayList;

import gui.base.Containable;
import gui.base.Furniture;
import gui.base.Item;

public class Bookshelf extends Furniture implements Containable{
	private final String topViewBookShelfURL;
	private final String frontViewBookShelfURL;
	private String text;
	private ArrayList<Item> item;
	private boolean isTopView;
	private boolean isContaining;
	

	public Bookshelf(String name, int xPosition, int yPosition, String text, boolean isTopView) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.topViewBookShelfURL = "topViewBookShelf.png";
		this.frontViewBookShelfURL = "frontViewBookShelf.png";
		this.text = text;
		setTopView(isTopView);
		setContaining(false);
		
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

	public boolean isTopView() {
		return isTopView;
	}

	public void setTopView(boolean isTopView) {
		this.isTopView = isTopView;
	}

	public String getTopViewBookShelfURL() {
		return topViewBookShelfURL;
	}

	public String getFrontViewBookShelfURL() {
		return frontViewBookShelfURL;
	}
	
	public void setContaining(boolean isContaining) {
		this.isContaining = isContaining;
	}


}
