package gui.room;

import entity.base.Emotion;
import entity.base.Furniture;
import entity.base.Room;
import entity.furniture.*;
import entity.item.*;
import logic.Player;
import screen.PlayingScreen;
import sharedObject.RenderableHolder;

public class Library extends Room{

	public Library() {
		super("Library", "I walk along the corridor again and again.\n"
				+ "My brain still thinking, and it becomes curiouser and curiouser.\n"
				+ "I think this place is a maze more than a house.\n"
				+ "I wonder how Anna lives here.\n"
				+ "And now I found myself in the familiar library.\n");

		Player.setPlayerEmotion(Emotion.NORMAL);
		PlayingScreen.setCharacterPane();
		
		Door door = new Door("Door", 680, 420, -1);

		TableWithLamp leftTable = new TableWithLamp("LeftTableWithLamp", 20, 100, 1);
		TableWithLamp rightTable = new TableWithLamp("RightTableWithLamp", 620, 100, 2);
		
		Bookshelf bigBookshelf = new Bookshelf("BigBookshelf", 140, 80, 3);
		Bookshelf bookshelf1 = new Bookshelf("Bookshelf1", 150, 220, 4 );
		Bookshelf bookshelf2 = new Bookshelf("Bookshelf2", 400, 220, 5 );
		Bookshelf bookshelf3 = new Bookshelf("Bookshelf3", 150, 360, 6 );
		Bookshelf bookshelf4 = new Bookshelf("Bookshelf4", 400, 360, 7 );
		
		bookshelf1.getAreaForInteract()[0][1] = 300;
		bookshelf2.getAreaForInteract()[0][1] = 300;
		bookshelf3.getAreaForInteract()[0][1] = 440;
		bookshelf4.getAreaForInteract()[0][1] = 440;
		
		TableWithNote tableWithNote = new TableWithNote("TableWithBook", 0, 340, 8 );
		Chair chair = new Chair("LeftChair", 60, 420, 9 );
		
		Note note1 = new Note("Note1",  0, 340, 9,
							"“Doubt is the clue to make sure.\n"
							+ "Make it simply. Sometime the answer is nearer than you think”\n"
							+ "If I doubt about myself... So, I should begin with myself?");
		Note note2 = new Note("Note2",  420, 300, 5,
							"“This is really large library. I love to read here\n"
							+ "My mom and dad build it for me...\n"
							+ "Although, Sometime I think everyone forget me\n"
							+ "I stay here since the morning but no one call me for lunch”\n"
							+ "Forget? Is she their child?");
		
		Note noteWithDoll = new Note("Note3",  280, 420, 7,
							"“Scilla, I first met her in this library. My mom gave it to me.\n"
							+ "She said Scilla is beautiful and meaningful. Constancy…\n"
							+ "I think my mom wants me to still believe in my health.\n"
							+ "Thanks, mom. I always love your gifts.”\n"
							+ "Believe in her health? Is she sick?\n");
		noteWithDoll.setImageString("Scilla");
		Key doorKey = new Key("Key", 300, 440, 8, door ); 
		
		tableWithNote.getItem().add(note1);
		bookshelf2.getItem().add(note2);
		bookshelf3.getItem().add(noteWithDoll);
		bookshelf3.getItem().add(doorKey);
		
		this.getFurniture().add( door );
		this.getFurniture().add( leftTable );
		this.getFurniture().add( rightTable );
		this.getFurniture().add( bigBookshelf );
		this.getFurniture().add( bookshelf1 );
		this.getFurniture().add( bookshelf2 );
		this.getFurniture().add( bookshelf3 );
		this.getFurniture().add( bookshelf4 );
		this.getFurniture().add( tableWithNote );
		this.getFurniture().add( chair );
		

		
		for( Furniture furniture: this.getFurniture() ) {
			RenderableHolder.getInstance().add(furniture);
		}
		
		RenderableHolder.getInstance().add(note1);
		RenderableHolder.getInstance().add(note2);
		RenderableHolder.getInstance().add(noteWithDoll);
		RenderableHolder.getInstance().add(doorKey);
	}

}
