package logic;

import java.util.ArrayList;

import entity.base.Direction;
import entity.base.Emotion;
import entity.base.Furniture;
import entity.base.Item;
import gui.ItemInHandBox;
import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import sharedObject.RenderableHolder;

public class Player {

	private static Item itemInHand;
	private static Emotion playerEmotion;
	private static double xPosition;
	private static double yPosition;
	private static Direction faceDirection;
	private final static double eachStep = 4.5;
	private final static double areaForFoot = 40;
	
	public static void initializePlayer() {
		itemInHand = null;
		ItemInHandBox.deleteImageInBox();
		playerEmotion = Emotion.WORRIED;		
		xPosition = 40;
		yPosition = 260;
		faceDirection = Direction.DOWN;
	}
	
	
	public static void useItem() { 
		
		ArrayList<Furniture> furniture = GameController.getCurrentRoom().getFurniture();
		
		for( int i = 0 ; i < furniture.size() ; i++ ) {
			
			if( isInfrontOf(furniture.get(i)) ) {
				furniture.get(i).useItem();
			}
		
		}
	}
	
	public static void observe() {
		ArrayList<Furniture> furniture = GameController.getCurrentRoom().getFurniture();
		
		for( int i = 0 ; i < furniture.size() ; i++ ) {
			
			if( isInfrontOf(furniture.get(i)) ) {
				furniture.get(i).observe();
			}
		
		}
	}
	
	private static boolean isInfrontOf(Furniture furniture) {

		Image character = RenderableHolder.characterSprite.get(faceDirection);
		double startCX = xPosition;
		double startCY = yPosition;
		
		double endCX = startCX + character.getWidth();
		double endCY = startCY + character.getHeight();
		
		double[][] xyFurniture = furniture.getAreaForInteract();
		
			
		if ( startCY > xyFurniture[1][1] || endCY < xyFurniture[0][1] ) {
			return false;
		}
	    if ( endCX < xyFurniture[0][0] || startCX > xyFurniture[1][0] ) {
	        return false;
	    }
		
		if( faceDirection == Direction.DOWN ) {
			return endCY == xyFurniture[0][1];
		}
		
		if( faceDirection == Direction.UP ) {
			return startCY <= xyFurniture[1][1]; 
		}
		
		if( faceDirection == Direction.LEFT) {
			return endCX == xyFurniture[1][0];
		}
		
		if( faceDirection == Direction.RIGHT) {
			return endCX == xyFurniture[0][0];
		}
		
		return false;

	}
	
	public static void move() {
		
		double startCX = xPosition;
		double startCY = yPosition;
		
		if( faceDirection == Direction.DOWN ) {
			startCY += eachStep;
		}
			
		if( faceDirection == Direction.UP ) {
			startCY -= eachStep;
		}	
		
		if( faceDirection == Direction.LEFT ) {
			startCX -= eachStep;
		}
		
		if( faceDirection == Direction.RIGHT ) {
			startCX += eachStep;
		}
		
		Image character = RenderableHolder.characterSprite.get(faceDirection);		
		double endCX = startCX + character.getWidth();
		double endCY = startCY + character.getHeight();
		
		
		ArrayList<Furniture> furniture = GameController.getCurrentRoom().getFurniture();
		
		for( int i = 0 ; i < furniture.size() ; i++ ) {
			
			double[][] xyFurniture = furniture.get(i).getAreaForInteract();
			
			if ( startCY + areaForFoot >= xyFurniture[1][1] || endCY <= xyFurniture[0][1] ) {
				continue;
			}
		    if ( endCX <= xyFurniture[0][0] || startCX >= xyFurniture[1][0] ) {
		        continue;
		    }
			
			if( faceDirection == Direction.DOWN ) {
				startCY = startCY + (xyFurniture[0][1] - endCY);
				break;
			}
				
			if( faceDirection == Direction.UP ) {
				startCY = xyFurniture[1][1] - areaForFoot;
				break;
			}	
			
			if( faceDirection == Direction.LEFT ) {
				startCX = xyFurniture[1][0];
				break;
			}
			
			if( faceDirection == Direction.RIGHT ) {
				startCX = startCX - ( endCX - xyFurniture[0][0] );
				break;
			}
		}
		
		setxPosition(startCX);
		setyPosition(startCY);	
	}

	public static Item getItemInHand() {
		return itemInHand;
	}

	public static Emotion getPlayerEmotion() {
		return playerEmotion;
	}

	public static void setItemInHand(Item itemInHand) {
		Player.itemInHand = itemInHand;
	}

	public static void setPlayerEmotion(Emotion playerEmotion) {
		Player.playerEmotion = playerEmotion;
	}

	public static double getxPosition() {
		return xPosition;
	}

	public static void setxPosition(double xPosition) {
		
		Image image = RenderableHolder.characterSprite.get(faceDirection);
		
		double startX = GameController.getCurrentRoom().getFloorStartX();
		double endX = GameController.getCurrentRoom().getWidth() - image.getWidth();
		
		if( xPosition < startX  )
			xPosition = startX;
		
		if( xPosition > endX )
			xPosition = endX;
		
		Player.xPosition = xPosition;
	}

	public static double getyPosition() {
		return yPosition;
	}

	public static void setyPosition(double yPosition) {
		Image image = RenderableHolder.characterSprite.get(faceDirection);
	
		double startY = GameController.getCurrentRoom().getFloorStartY();
		double endY = GameController.getCurrentRoom().getHeight() - image.getHeight();
		
		if( yPosition < startY  )
			yPosition = startY;
		
		if( yPosition > endY )
			yPosition = endY;
		
		Player.yPosition = yPosition;
	}

	public static Direction getFaceDirection() {
		return faceDirection;
	}

	public static void setFaceDirection(Direction faceDirection) {
		Player.faceDirection = faceDirection;
	}
	
	public static void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.characterSprite.get(faceDirection) , xPosition, yPosition);
	}

	public static void logicUpdate() {
		if (InputUtility.getKeyPressed(KeyCode.A)) {
			setFaceDirection(Direction.LEFT);
			move();
		}
		
		if (InputUtility.getKeyPressed(KeyCode.D)) {
			setFaceDirection(Direction.RIGHT);
			move();
		}
		
		if (InputUtility.getKeyPressed(KeyCode.W)) {
			setFaceDirection(Direction.UP);
			move();
		}
		
		if (InputUtility.getKeyPressed(KeyCode.S)) {
			setFaceDirection(Direction.DOWN);
			move();
		}
		
		if (InputUtility.getKeyPressed(KeyCode.K)) {
			observe();
		}
		
		if (InputUtility.getKeyPressed(KeyCode.L)) {
			useItem();
		}
		
		
	}
	
	
	
}
