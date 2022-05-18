package logic;

import entity.base.Room;
import gui.room.Bedroom;
import gui.room.Garden;
import gui.room.Library;
import gui.room.LivingRoom;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import screen.EndingScreen;
import screen.PlayingScreen;
import sharedObject.RenderableHolder;

public class GameController {
	
	private static Room currentRoom;
	private static Timer timer;
	
	public static void startGame(){
		Player.initializePlayer();
		RenderableHolder.getInstance().getEntities().clear();
		currentRoom = new Bedroom();
		timer = new Timer(3, 0, 0);
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
			endGame(false);
			return;
		}
		
		if( currentRoom.isGameEnd()) {
			
			if( currentRoom instanceof Garden ) {
				endGame(true);
				return;
			}
			
			setCurrentRoom();
			timer = new Timer(3, 0, 0);
			return;
		}
		timer.decrementTimer(2);
		PlayingScreen.getTimerPane().setTimer(timer.toString());
		Player.logicUpdate();
	}
	
	public static void setCurrentRoom() {

		RenderableHolder.getInstance().getEntities().clear();
		
		if( currentRoom instanceof Bedroom )
			currentRoom = new LivingRoom();
		else if( currentRoom instanceof LivingRoom )
			currentRoom = new Library();
		else if( currentRoom instanceof Library )
			currentRoom = new Garden();
		
		PlayingScreen.setRoomPane(currentRoom);
		
		Player.initializePlayer();
	}
	
	public static void endGame(boolean isWin) {
		PlayingScreen.getAnimation().stop();
		RenderableHolder.bgMusic.get("PlayingScreenBGM").stop();
		
		Stage stage = (Stage)(PlayingScreen.getTimerPane().getScene().getWindow());
		Scene scene = new Scene(new EndingScreen(isWin));
		stage.setScene(scene);
		stage.show();
		
		return;
	}
}