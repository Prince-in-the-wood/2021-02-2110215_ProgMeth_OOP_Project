package gui.room;

import entity.base.Emotion;
import entity.base.Furniture;
import entity.base.Room;
import entity.furniture.*;
import entity.item.*;
import logic.Player;
import screen.PlayingScreen;
import sharedObject.RenderableHolder;

public class LivingRoom extends Room{

	public LivingRoom() {
		super("LivingRoom", "I walk along in the corridor. It seems to be only me here.\n"
				+ "I can feel this place is weird.\nI must leave this house as soon as possible...\n"
				+ "but how? Maybe I should find her dolls.\n"
				+ "She said that they keep the answer!\n");

		Player.setPlayerEmotion(Emotion.NORMAL);
		PlayingScreen.setCharacterPane();
		
		
		PictureWithItem ivyPic = new PictureWithItem("IvyPic", 80, 20, 1, "“Ivy, Lasting forever”");
		PictureWithItem shieldPic = new PictureWithItem("ShieldPic", 580, 20, 1, "“Shield”");
		Picture familyPic = new Picture("FamilyPic", 260, 20, 1, "“Our belove daughter, Anna”\n"
										+ "Family picture? But only the girl’s name is written.\n");
		
		ivyPic.getAreaForInteract()[1][1] = 180;
		shieldPic.getAreaForInteract()[1][1] = 180;
		familyPic.getAreaForInteract()[1][1] = 180;
		
		shieldPic.setIsSafeBehind(true);
		shieldPic.setIsLocked(true);
		
		
		Sofa bigSofa1 = new Sofa("FrontSofa", 260, 180, 2, true );
		bigSofa1.setName("Big Sofa");
		bigSofa1.getAreaForInteract()[0][1] = 220;
		
		Sofa leftSofa = new Sofa("LeftSofa", 180, 300, 3, false );
		leftSofa.setName("Sofa");
		leftSofa.getAreaForInteract()[0][1] = 320;
		
		Sofa rightSofa = new Sofa("RightSofa", 480, 300, 4, false );
		rightSofa.setName("Sofa");
		rightSofa.getAreaForInteract()[0][1] = 320;
		
		Sofa bigSofa2 = new Sofa("SouthSofa", 260, 420, 5, false );
		bigSofa2.setName("Big Sofa");
		bigSofa2.getAreaForInteract()[0][1] = 440;
		
		TableWithLamp tableWithLamp = new TableWithLamp("LongTableWithLamp", 280, 300, 2 );
		tableWithLamp.getAreaForInteract()[0][1] = 320;
		
		Door door = new Door("Door", 680, 420, -1);
		
		Note noteAtIvy = new Note("Note1",  80, 20, 1,
								"“Ivy, Lasting forever”\n"
								+ "There is some note here\n"
								+ "“In this house, it’s full of secrets. Everything keeps it inside.\n"
								+ "Tear and peer”\n"
								+ "It is a pocketknife behind\n");
		PocketKnife pocketKnife = new PocketKnife( "PocketKnife" , 80, 20, 1, bigSofa1 );
		ivyPic.getItemBehind().add(noteAtIvy);
		ivyPic.getItemBehind().add(pocketKnife);
		
		Note noteInSofa = new Note("Note2",  320, 220, 3,
							"There is something under the seat.\n"
							+ "“It’s safe behind the picture”\n");
		Key safeKey = new Key("Key", 310, 220, 3, shieldPic );
		bigSofa1.getThingBehind().add(noteInSofa);
		bigSofa1.getThingBehind().add(safeKey);
		
		Note noteWithDoll = new Note("Note3",  600, 60, 2,
							"“Ivy, the symbol of eternal life! That’s why I named her Ivy.\n"
							+ "Cause we will be along ever after! This room is full of memory\n"
							+ "mom and dad were here and play with me\n"
							+ "Keep Ivy here, and wish it would be the same forever!”\n"
							+ "I feel I have heard this story before…\n");
		noteWithDoll.setImageString("Ivy");
		Key doorKey = new Key("Key", 620, 80, 3, door );
		shieldPic.getItemBehind().add(noteWithDoll);
		shieldPic.getItemBehind().add(doorKey);
		
		this.getFurniture().add( ivyPic );
		this.getFurniture().add( shieldPic );
		this.getFurniture().add( familyPic );
		this.getFurniture().add( bigSofa1 );
		this.getFurniture().add( leftSofa );
		this.getFurniture().add( rightSofa );
		this.getFurniture().add( bigSofa2 );
		this.getFurniture().add(tableWithLamp);
		this.getFurniture().add(door);
		
		for( Furniture furniture: this.getFurniture() ) {
			RenderableHolder.getInstance().add(furniture);
		}
		
		RenderableHolder.getInstance().add(noteAtIvy);
		RenderableHolder.getInstance().add(pocketKnife);
		RenderableHolder.getInstance().add(noteInSofa);
		RenderableHolder.getInstance().add(safeKey);
		RenderableHolder.getInstance().add(noteWithDoll);
		RenderableHolder.getInstance().add(doorKey);
	}

}
