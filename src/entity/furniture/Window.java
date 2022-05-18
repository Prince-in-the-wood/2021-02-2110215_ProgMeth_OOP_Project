package entity.furniture;

import entity.base.Furniture;
import entity.base.Lockable;
import entity.base.Openable;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class Window extends Furniture implements Openable{

	private boolean isOpened;

	public Window(String name, int xPosition, int yPosition, int z) {
		super(name, xPosition, yPosition , z );
		setIsOpened(false);
	}

	@Override
	public void open() {
		RenderableHolder.soundFX.get("Open").play();
		setIsOpened(true);
		setImageString("OpenedWindow");
	}
	
	@Override
	public void close() {
		RenderableHolder.soundFX.get("Open").play();
		setImageString(this.getName());
		setIsOpened(false);
	}

	@Override
	public boolean isOpened() {
		return isOpened;
	}

	@Override
	public void observe() {
		if( !this.isOpened() )
			this.open();
		else
			this.close();
		
		DialoguePane.setGameText("Why everything is silent?");
	}
	// setter and getter

	public void setIsOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}	

}
