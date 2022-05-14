package logic;

import entity.base.Emotion;
import entity.base.Item;

public class Player {
	private static Item itemInHand;
	private static Emotion playEmotion;
	
	public Player() {
		itemInHand = null;
		playEmotion = Emotion.NORMAL;
	}

	public Item getItemInHand() {
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
	
	
	
}
