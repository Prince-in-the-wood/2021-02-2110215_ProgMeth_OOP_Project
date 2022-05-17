package gui.room;

import entity.base.Furniture;
import entity.base.Room;
import entity.furniture.*;
import entity.item.*;
import sharedObject.RenderableHolder;

public class Bedroom extends Room{
	
	public Bedroom() {
		
		super("Bedroom", "I don’t know where I am. Maybe, I’m dreaming…\n"
				+ "but I can feel it is real.\n"
				+ "It’s cold here. I try to think but my brain is numb.\n"
				+ "Maybe someone will call me…\n"
				+ "Me…? Wait… I… Who am I?\n");

		Door door = new Door("Door", 680, 420, -1);
		
		Cupboard cupboard = new Cupboard("Cupboard", 80 ,40, 1 );
		double[][] cupboardArea = cupboard.getAreaForInteract();
		cupboardArea[0][1] = 180;
		cupboard.setAreaForInteract(cupboardArea);
		Note noteWithDoll = new Note("Note1", 100, 180, 2,
							"Yeah, you found Melody!\n"
							+ "I’m glad to invite you to visit my new room!\n"
							+ "It is bigger than the old one.\n"
							+ "Is it great, right?”");
		noteWithDoll.setImageString("Melody");
		Key doorKey = new Key("Key", 120, 200, 3, door); // It's should be door instead
		cupboard.getItem().add(noteWithDoll);
		cupboard.getItem().add(doorKey);
		
		Window window = new Window("Window", 540, 40 , 4 );
		double[][] windowArea = window.getAreaForInteract();
		windowArea[1][1] = 180;
		window.setAreaForInteract(windowArea);
		
		Bed bed = new Bed("Bed", 320 , 200 , 5 );
		double[][] bedArea = bed.getAreaForInteract();
		bedArea[0][1] = 220;
		bed.setAreaForInteract(bedArea);
		
		TableWithLamp tableWithLamp = new TableWithLamp("TableWithLamp", 480 ,160 , 4);
		double[][] tableArea = tableWithLamp.getAreaForInteract();
		tableArea[0][1] = 240;
		tableWithLamp.setAreaForInteract(tableArea);
		
		Chair chair = new Chair("Chair", 100, 400 , 6);	
		
		TableWithNote tableWithNote = new TableWithNote("TableWithNote", 40 ,440 , 7 );
		Note note2 = new Note("Note2", 40, 440, 8,
							"April 1st, 2002\n"
							+ "I like to play hide and seek.\n"
							+ "So, I hide all my dolls in my house.\n"
							+ "I think everyone would love to."
							+ "They’re the answer of everything!”");
		Key cupboardKey = new Key("Key", 40, 200, 9, cupboard );
		tableWithNote.getItem().add(note2);
		tableWithNote.getItem().add(cupboardKey);
		
		this.getFurniture().add(door);
		this.getFurniture().add( cupboard );
		this.getFurniture().add( window );
		this.getFurniture().add( bed );
		this.getFurniture().add( tableWithLamp );
		this.getFurniture().add( chair );
		this.getFurniture().add( tableWithNote );
		
		for( Furniture furniture: this.getFurniture() ) {
			RenderableHolder.getInstance().add(furniture);
		}
		
		RenderableHolder.getInstance().add(noteWithDoll);
		RenderableHolder.getInstance().add(doorKey);
		RenderableHolder.getInstance().add(note2);
		RenderableHolder.getInstance().add(cupboardKey);
		
	}

}
