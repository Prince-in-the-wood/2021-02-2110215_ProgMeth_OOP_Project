package gui.room;

import java.util.ArrayList;

import entity.base.Emotion;
import entity.base.Furniture;
import entity.base.Room;
import entity.furniture.*;
import entity.item.Note;
import logic.Player;
import screen.PlayingScreen;
import sharedObject.RenderableHolder;


public class Garden extends Room{
	
	public Garden() {
		super("Garden", "“This is a garden! Garden in the house?\n"
				+ "Why such a thing can be here…\n"
				+ "The door is locked suddenly after I came here\n"
				+ "What the world is it?”");
		
		Player.setPlayerEmotion(Emotion.NORMAL);
		PlayingScreen.setCharacterPane();
		
		Mirror mirror = new Mirror("Mirror", 320, 20, 1);
		Note noteWithDoll = new Note("Note1",  340, 60, 2,
							"“Oh, am I Anna? Why…? Why am I here?”\n"
							+"“To our beloved daughter, Anna…\n"
							+ "We hope you will be with us. Today is your eleventh birthday.\n"
							+ "I have a present for you, Snowdrop I wish you love it\n"
							+ "Your mom”");
		noteWithDoll.setImageString("Snowdrop");
		mirror.getItem().add(noteWithDoll);
		mirror.getAreaForInteract()[1][1] = 180;
		
		Statue statueWithMoon = new Statue("StatueWithMoon", 80, 80, 3, 'H', 'M');
		Statue statueWithSofa = new Statue("StatueWithSofa", 520, 80, 4, 'A', 'I');
		Statue statueWithBook = new Statue("StatueWithBook", 80, 300, 6, 'M', 'S');
		Statue statueWithLeaf = new Statue("StatueWithLeaf", 520, 300, 7, 'I', 'S');
		
		statueWithMoon.getAreaForInteract()[0][1] = 200;
		statueWithSofa.getAreaForInteract()[0][1] = 200;
		statueWithBook.getAreaForInteract()[0][1] = 420;
		statueWithLeaf.getAreaForInteract()[0][1] = 420;
		
		Bed realBed = new Bed("RealBed", 300, 220, 5 );
		realBed.getAreaForInteract()[0][1] = 240;
		
		
		this.getFurniture().add(mirror);
		this.getFurniture().add(statueWithMoon);
		this.getFurniture().add(statueWithBook);
		this.getFurniture().add(statueWithSofa);
		this.getFurniture().add(statueWithLeaf);
		this.getFurniture().add(realBed);
		
		for( Furniture furniture: this.getFurniture() ) {
			RenderableHolder.getInstance().add(furniture);
		}
		
		RenderableHolder.getInstance().add(noteWithDoll);
	}

	public void setUpdate() {

		Player.setPlayerEmotion(Emotion.SHOCK);
		PlayingScreen.setCharacterPane();
		
		for( Furniture furniture: this.getFurniture() ) {
			
			if( furniture instanceof Statue )
				((Statue)furniture).update();
		}
	}
	
	@Override
	public boolean isGameEnd() {
		
		if( this.getFurniture().isEmpty() )
			return false;
		
		for( Furniture furniture: this.getFurniture() ) {
			
			if( furniture instanceof Statue && !((Statue)furniture).isMatch()) {
				return false;
			}
				
		}
		return true;
	}
	
}
