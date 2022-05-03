package gui.furniture;

import gui.base.Furniture;
import gui.base.Lockable;
import gui.base.Openable;

public class Window extends Furniture implements Openable{
	private final String openedWindowURL;
	private final String closedWindowURL;
	private final String text;
	private boolean isOpened;

	public Window(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.openedWindowURL = "openedWindow.png";
		this.closedWindowURL = "closedWindow.png";
		this.text = "";			// window text
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
	public void close() {
		// TODO Auto-generated method stub
		
	}

	
	// setter and getter 
	
	public String getOpenedWindowURL() {
		return openedWindowURL;
	}

	public String getClosedWindowURL() {
		return closedWindowURL;
	}

	public String getText() {
		return text;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}


}
