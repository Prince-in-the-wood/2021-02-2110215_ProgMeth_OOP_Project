package gui.furniture;

import java.util.ArrayList;

import gui.base.Containable;
import gui.base.Furniture;
import gui.base.Item;

public class TableWithNote extends Furniture implements Containable{
	private final String tableWithNoteURL;
	private String text;
	private boolean isContaining;
	private ArrayList<Item> item;

	public TableWithNote(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.tableWithNoteURL = "tableWithNote.png";
		setContaining(true);
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

	public String getTableWithNoteURL() {
		return tableWithNoteURL;
	}

	public void setContaining(boolean isContaining) {
		this.isContaining = isContaining;
	}

}
