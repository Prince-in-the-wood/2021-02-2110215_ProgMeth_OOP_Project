package entity.furniture;

import entity.base.Updateable;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

import java.util.ArrayList;
import java.util.Arrays;

import entity.base.Furniture;

public class Statue extends Furniture implements Updateable{
	 
	private final ArrayList<Character> characterSet = new ArrayList<Character>(
													  Arrays.asList('M', 'H' ,'I' , 'P' , 'E', 'N' ,'A' , 'S' ,'O' ));
	private final double translationDisY = 50;
	private final double translationDisX = 35;
	
	private char letterOnStatue;
	private char answerLetter;
	private boolean isUpdated;

	public Statue(String name, int xPosition, int yPosition, int z, char letterOnStatue, char answerLetter) {
		super(name, xPosition, yPosition, z);
	
		this.letterOnStatue = letterOnStatue;
		this.answerLetter = answerLetter;
		this.isUpdated = false;
	}


	//setter and getter
	public char getLetterOnStatue() {
		return letterOnStatue;
	}

	public void setLetterOnStatue(char letterOnStatue) {
		this.letterOnStatue = letterOnStatue;
	}


	public char getAnswerLetter() {
		return answerLetter;
	}

	public void setAnswerLetter(char answerLetter) {
		this.answerLetter = answerLetter;
	}

	public boolean isMatch() {
		return this.answerLetter == this.letterOnStatue;
	}

	public ArrayList<Character> getCharacterSet() {
		return characterSet;
	}


	@Override
	public void update() {
		isUpdated = true;
	}


	@Override
	public boolean isUpdated() {
		return isUpdated;
	}
	
	@Override
	public void observe() {
		
		if( !isUpdated() ) {
			super.observe();			
		}else {
			
			int i = ( characterSet.indexOf(this.letterOnStatue) + 1 ) % characterSet.size();
			this.setLetterOnStatue( characterSet.get(i));
			DialoguePane.setGameText("This statue is strange!\nI think this is the puzzle\n"
									+ "but how can I solve this.");
			RenderableHolder.soundFX.get("Tab").play();
		}
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
		super.draw(gc);
		
		double x = super.getxPosition();
		double y = super.getyPosition();
		
		gc.setFont(RenderableHolder.juiceICTFont);
		gc.setFill(Color.BROWN);
		gc.fillText(Character.toString(letterOnStatue), x + translationDisX, y + translationDisY );
		
	}
}
