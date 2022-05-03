package gui.furniture;

import java.util.ArrayList;

import gui.base.Containable;
import gui.base.Furniture;
import gui.base.Item;

public class Picture extends Furniture implements Containable{
	private final String ivyPicURL;
	private final String familyPicURL;
	private final String shieldPicURL;
	private final String safePicURL;
	private String text;
	private boolean isContaining;
	private ArrayList<Item> item;
	
	public Picture(String name, int xPosition, int yPosition, String text, boolean isContaining) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.ivyPicURL = "ivyPic.png";
		this.familyPicURL = "familyPic.png";
		this.shieldPicURL = "shieldPic.png";
		this.safePicURL = "safePic.png";
		this.text = text;
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

	public String getIvyPicURL() {
		return ivyPicURL;
	}

	public String getFamilyPicURL() {
		return familyPicURL;
	}

	public String getShieldPicURL() {
		return shieldPicURL;
	}

	public String getSafePicURL() {
		return safePicURL;
	}

	public void setContaining(boolean isContaining) {
		this.isContaining = isContaining;
	}


}
