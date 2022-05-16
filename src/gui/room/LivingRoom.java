package gui.room;

import entity.base.Emotion;
import entity.base.Furniture;
import entity.base.Room;
import entity.furniture.Bed;
import entity.furniture.Chair;
import entity.furniture.Cupboard;
import entity.furniture.Door;
import entity.furniture.TableWithLamp;
import entity.furniture.TableWithNote;
import entity.furniture.Window;
import entity.item.Key;
import entity.item.Note;
import logic.Player;
import screen.PlayingScreen;
import sharedObject.RenderableHolder;

public class LivingRoom extends Room{

	public LivingRoom() {
		super("LivingRoom", "I walk along in the corridor. It seems to be only me here.\n"
				+ "I can feel this place is weird.\nI must leave this house as soon as possible...\n"
				+ "but how? Maybe I should find her dolls.\n"
				+ "She said that they keep the answer!\n"
				, "Where will the corridor lead?");

		Player.setPlayerEmotion(Emotion.NORMAL);
		PlayingScreen.setCharacterPane();

	}

}
