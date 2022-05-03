package gui.furniture;

import java.util.ArrayList;

import gui.base.Containable;
import gui.base.Cuttable;
import gui.base.Furniture;
import gui.base.Item;

public class Sofa extends Furniture implements Cuttable, Containable{
	private final String smallSofaURL;
	private final String largeSofaURL;
	private String text;
	private boolean isContaining;
	private boolean isCut;
	private ArrayList<Item> item;

	public Sofa(String name, int xPosition, int yPosition, String text, boolean isContaining) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.smallSofaURL = "smallSofa.png";
		this.largeSofaURL = "largeSofa.png";
		this.text = text;
		setContaining(false);
		setCut(false);
		
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

	public String getSmallSofaURL() {
		return smallSofaURL;
	}

	public String getLargeSofaURL() {
		return largeSofaURL;
	}

	public void setContaining(boolean isContaining) {
		this.isContaining = isContaining;
	}
	
	public void setCut(boolean isCut) {
		this.isCut = isCut;
	}
}
