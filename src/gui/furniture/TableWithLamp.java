package gui.furniture;

import gui.base.Changeable;
import gui.base.Furniture;

public class TableWithLamp extends Furniture implements Changeable{
	private final String tableWithTurnOnLampURL;
	private final String tableWithTurnOffLampURL;
	private String text;
	private boolean isChange;

	public TableWithLamp(String name, int xPosition, int yPosition) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		this.tableWithTurnOnLampURL = "tableWithTurnOnLamp.png";
		this.tableWithTurnOffLampURL = "tableWithTurnOffLamp.png";
		setChange(false);
		
	}


	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isChanged() {
		// TODO Auto-generated method stub
		return isChange;
	}

	
	//setter and getter
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isChange() {
		return isChange;
	}

	public void setChange(boolean isChange) {
		this.isChange = isChange;
	}


	public String getTableWithTurnOnLampURL() {
		return tableWithTurnOnLampURL;
	}

	public String getTableWithTurnOffLampURL() {
		return tableWithTurnOffLampURL;
	}
}
