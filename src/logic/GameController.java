package logic;

import entity.base.Room;

public class GameController {
	
	private static Player player;
	private static Room currentRoom;
	private static Timer timer;
	
	
	public static Player getPlayer() {
		return player;
	}
	public static void setPlayer(Player player) {
		GameController.player = player;
	}
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	public static void setCurrentRoom(Room currentRoom) {
		GameController.currentRoom = currentRoom;
	}
	public static Timer getTimer() {
		return timer;
	}
	public static void setTimer(Timer timer) {
		GameController.timer = timer;
	}
	
	
}
