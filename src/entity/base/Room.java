package entity.base;

import java.util.ArrayList;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public abstract class Room extends Canvas{
	
	private String name;
	private String startText;
	private String endText;
	private ArrayList<Furniture> furniture;
	private boolean isStart;
	private boolean isEnd;
	
	private double floorStartX;
	private double floorStartY;
	
	
	public Room() {
		
		setStart(false);
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
		gc.setFill(Color.BLACK);
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible() ) {
				entity.draw(gc);
			}
		}


	}

	

	// method
	public void start() {
		// start method
	}
	
	public void end() {
		// end method
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
	
	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
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
