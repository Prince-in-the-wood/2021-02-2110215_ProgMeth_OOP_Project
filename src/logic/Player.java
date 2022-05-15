package logic;

import java.util.ArrayList;

import entity.base.Direction;
import entity.base.Emotion;
import entity.base.Furniture;
import entity.base.Item;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sharedObject.RenderableHolder;

public class Player {

	private static Item itemInHand;
	private static Emotion playEmotion;
	private static double xPosition;
	private static double yPosition;
	private static Direction faceDirection;
	private final static double eachStep = 20;
	
	public Player() {
		itemInHand = null;
		playEmotion = Emotion.NORMAL;		
		//xPosition = ;
		//YPosition = ;
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
				furniture.get(i).useItem();
			}
		
		}
	}
	
	private static boolean isInfrontOf(Furniture furniture) {

		Image character = RenderableHolder.characterSprite.get(faceDirection);
		double startCX = xPosition;
		double startCY = yPosition;
		
		double endCX = startCX + character.getWidth();
		double endCY = startCY + character.getHeight();
		
		
		double startFX = furniture.getxPosition();
		double startFY = furniture.getyPosition();
		
		Image image = RenderableHolder.furnitureSprite.get(furniture.getImageString());
		double endFX = startFX + image.getWidth();
		double endFY = startFY + image.getHeight();
		
		if( faceDirection == Direction.DOWN ) {
			return ( startFX <= startCX && endCX <= endFX && endCY == startFY);
		}
		
		if( faceDirection == Direction.UP ) {
			return ( startFX <= startCX && endCX <= endFX && startCY == endFY ); 
		}
		
		if( faceDirection == Direction.LEFT) {
			return ( startFY <= startCY && endCY <= endFY && startCX == endFX );
		}
		
		if( faceDirection == Direction.RIGHT) {
			return ( startFY <= startCY && endCY <= endFY && endCX == startFX );
		}
		
		return false;

	}
	
	public static void move() {
		
		ArrayList<Furniture> furniture = GameController.getCurrentRoom().getFurniture();
		
		for( int i = 0 ; i < furniture.size() ; i++ ) {
			if( isInfrontOf(furniture.get(i)) ) {
				return;
			}
		}
		
		if( faceDirection == Direction.DOWN ) {
			Player.setyPosition( yPosition + eachStep );
		}
			
		
		if( faceDirection == Direction.UP ) {
			Player.setyPosition( yPosition - eachStep );
		}
			
		
		if( faceDirection == Direction.LEFT ) {
			Player.setxPosition( xPosition - eachStep );
		}
			
		
		if( faceDirection == Direction.RIGHT ) {
			Player.setxPosition( xPosition + eachStep );
		}
			
	}

	public static Item getItemInHand() {
		return itemInHand;
	}

	public static Emotion getPlayEmotion() {
		return playEmotion;
	}

	public static void setItemInHand(Item itemInHand) {
		Player.itemInHand = itemInHand;
	}

	public static void setPlayEmotion(Emotion playEmotion) {
		Player.playEmotion = playEmotion;
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
	
	public void draw(GraphicsContext gc) {
		gc.drawImage(RenderableHolder.characterSprite.get(faceDirection) , xPosition, yPosition);
	}
	
	
	
}
