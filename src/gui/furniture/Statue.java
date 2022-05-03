package gui.furniture;

import gui.base.Changeable;
import gui.base.Furniture;

public class Statue extends Furniture implements Changeable{
	private final String statueWithMoonURL;
	private final String statueWithBookURL;
	private final String statueWithFlowerURL;
	private String letterOnState;
	private String text;
	private String answerLetter;
	private boolean isMatch;

	public Statue(String name, int xPosition, int yPosition, String letterOnStatue, String text, String answerLetter, boolean isMatch) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.statueWithMoonURL = "statueWithMoon.png";
		this.statueWithBookURL = "statueWIthBook.png";
		this.statueWithFlowerURL = "statueWithFlower.png";
		
		this.letterOnState = letterOnStatue;
		this.text = text;
		this.answerLetter = answerLetter;
		setMatch(false);
	}

	
	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isChanged() {
		// TODO Auto-generated method stub
		return isMatch;
	}

	//setter and getter
	public String getLetterOnState() {
		return letterOnState;
	}

	public void setLetterOnState(String letterOnState) {
		this.letterOnState = letterOnState;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswerLetter() {
		return answerLetter;
	}

	public void setAnswerLetter(String answerLetter) {
		this.answerLetter = answerLetter;
	}

	public boolean isMatch() {
		return isMatch;
	}

	public void setMatch(boolean isMatch) {
		this.isMatch = isMatch;
	}

	public String getStatueWithMoonURL() {
		return statueWithMoonURL;
	}

	public String getStatueWithBookURL() {
		return statueWithBookURL;
	}

	public String getStatueWithFlowerURL() {
		return statueWithFlowerURL;
	}

}
