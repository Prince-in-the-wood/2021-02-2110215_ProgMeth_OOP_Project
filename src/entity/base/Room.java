package entity.base;

import java.util.ArrayList;

import gui.DialoguePane;
import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.Player;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public abstract class Room extends Canvas{
	
	private String name;
	private String startText;
	private String endText;
	private ArrayList<Furniture> furniture;
	private boolean isEnd;
	
	private double floorStartX;
	private double floorStartY;
	
	
	public Room() {

		setEnd(false);
		
	}
	

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});

	}

	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		
		boolean isCharacterDraw = false;
		
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			
			if( !isCharacterDraw ) {
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
	public void start() {
		DialoguePane.setGameText(startText);
	}
	
	public void end() {
		DialoguePane.setGameText(endText);
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

	public String getEndText() {
		return endText;
	}

	public void setEndText(String endText) {
		this.endText = endText;
	}

	public ArrayList<Furniture> getFurniture() {
		return furniture;
	}

	public void setFurniture(ArrayList<Furniture> furniture) {
		this.furniture = furniture;
	}
	
	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}


	public double getFloorStartX() {
		return floorStartX;
	}


	public void setFloorStartX(double floorStartX) {
		this.floorStartX = floorStartX;
	}


	public double getFloorStartY() {
		return floorStartY;
	}


	public void setFloorStartY(double floorStartY) {
		this.floorStartY = floorStartY;
	}


}
