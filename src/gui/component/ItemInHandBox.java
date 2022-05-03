package gui.component;

import javafx.scene.layout.Pane;

public class ItemInHandBox extends Pane{
	private final String boxBG_URL;
	
	public ItemInHandBox() {
		this.boxBG_URL = "boxBG.png";
	}

	//getter and setter
	public String getBoxBG_URL() {
		return boxBG_URL;
	}

}
