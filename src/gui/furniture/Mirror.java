package gui.furniture;

import java.util.ArrayList;

import gui.base.Changeable;
import gui.base.Containable;
import gui.base.Furniture;
import gui.base.Item;

public class Mirror extends Furniture implements Changeable, Containable {
	private final String mirrorURL;
	private final String brokenMirrorURL;
	private String text;
	private boolean isContaining;
	private boolean isChangeed;
	private ArrayList<Item> item;
	
	public Mirror(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.mirrorURL = "mirror.png";
		this.brokenMirrorURL = "brokenMirror";
		setContaining(false);
		setChangeed(false);
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
	public void change() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isChanged() {
		// TODO Auto-generated method stub
		return isChangeed;
	}

	
	//setter and getter
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isChangeed() {
		return isChangeed;
	}

	public void setChangeed(boolean isChangeed) {
		this.isChangeed = isChangeed;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	public String getMirrorURL() {
		return mirrorURL;
	}

	public String getBrokenMirrorURL() {
		return brokenMirrorURL;
	}

	public void setContaining(boolean isContaining) {
		this.isContaining = isContaining;
	}
}
