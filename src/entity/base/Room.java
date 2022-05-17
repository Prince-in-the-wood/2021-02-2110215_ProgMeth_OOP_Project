package entity.base;

import java.util.ArrayList;

import entity.furniture.Door;
import entity.item.Note;
import gui.DialoguePane;
import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.GameController;
import logic.Player;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public abstract class Room extends Canvas{
	
	private String name;
	private String startText;
	private ArrayList<Furniture> furniture;
	private boolean isGameEnd;
	
	private final double floorStartX = 0;
	private final double floorStartY = 140;
	
	
	public Room(String name, String startText ) {
		super();
		
		this.setName(name);
		this.setWidth(720);
		this.setHeight(520);
		
		furniture = new ArrayList<Furniture>();
		
		setStartText(startText);
		setIsGameEnd(false);
		
		startGame();
	}
	
	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		
		gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
		
		gc.drawImage(RenderableHolder.background.get(GameController.getCurrentRoom().getName()), 0 , 0 );
		boolean isCharacterDraw = false;
		
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			
			if( !isCharacterDraw && !( entity instanceof Door) ) {
				if( entity instanceof Furniture && ((Furniture)entity).getyPosition() > Player.getyPosition()) {
					Player.draw(gc);
					isCharacterDraw = true;
				}else if( entity instanceof Item && ((Item)entity).getyPosition() > Player.getyPosition()) {
					Player.draw(gc);
					isCharacterDraw = true;
				}
			}
			
			if ( entity.isVisible() ) {
				entity.draw(gc);
			}
		}
		
		if( !isCharacterDraw )
			Player.draw(gc);

	}

	

	// method
	public void startGame() {
		DialoguePane.setGameText(startText);
	}
	
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartText() {
		return startText;
	}

	public void setStartText(String startText) {
		this.startText = startText;
	}

	public ArrayList<Furniture> getFurniture() {
		return furniture;
	}

	public void setFurniture(ArrayList<Furniture> furniture) {
		this.furniture = furniture;
	}
	
	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setIsGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}


	public double getFloorStartX() {
		return floorStartX;
	}

	public double getFloorStartY() {
		return floorStartY;
	}

}
