package logic;

import entity.base.Room;
import gui.room.Bedroom;
import gui.room.Garden;
import gui.room.Library;
import gui.room.LivingRoom;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screen.EndingScreen;
import screen.PlayingScreen;
import sharedObject.RenderableHolder;

public class GameController {
	
	private static Room currentRoom;
	private static Timer timer;
	
	public GameController(){
		
		currentRoom = new Bedroom();
		timer = new Timer(5, 0, 0);
	}
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}

	public static Timer getTimer() {
		return timer;
	}
	public static void setTimer(Timer timer) {
		GameController.timer = timer;
	}
	
	public static void logicUpdate() {
		
		if(timer.isTimerOver()) {
			endGame();
			return;
		}
		
		if( currentRoom.isEnd()) {
			
			if( currentRoom instanceof Garden ) {
				endGame();
				return;
			}
			
			setCurrentRoom();
			timer = new Timer(5, 0, 0);
			return;
		}
		
		Player.logicUpdate();
	}
	
	public static void setCurrentRoom() {
		if( currentRoom instanceof Bedroom )
			currentRoom = new LivingRoom();
		else if( currentRoom instanceof LivingRoom )
			currentRoom = new Library();
		else if( currentRoom instanceof Library )
			currentRoom = new Garden();
	}
	
	public static void endGame() {
		PlayingScreen.getAnimation().stop();
		
		Stage stage = (Stage)(PlayingScreen.getTimerPane().getScene().getWindow());
		Scene scene = new Scene(new EndingScreen());
		RenderableHolder.bgMusic.get("MainMenuBGM").play();
		stage.setScene(scene);
		stage.show();
		
		return;
	}
}
