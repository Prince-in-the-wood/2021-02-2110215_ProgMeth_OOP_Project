package entity.furniture;

import entity.base.Updateable;
import entity.base.Furniture;

public class Statue extends Furniture implements Updateable{
	
	private String letterOnState;
	private String answerLetter;
	private boolean isMatch;

	public Statue(String name, int xPosition, int yPosition, String letterOnStatue, String answerLetter, boolean isMatch) {
		super(name, xPosition, yPosition);
	
		this.letterOnState = letterOnStatue;
		this.answerLetter = answerLetter;
		setMatch(false);
	}


	//setter and getter
	public String getLetterOnState() {
		return letterOnState;
	}

	public void setLetterOnState(String letterOnState) {
		this.letterOnState = letterOnState;
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


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isUpdated() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
