package logic;

import entity.base.Room;
import gui.room.Bedroom;
import gui.room.Garden;
import gui.room.Library;
import gui.room.LivingRoom;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
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
		
		makeRoomFadeTransition();

		
		Player.initializePlayer();
	}
	
	private static void makeRoomFadeTransition() {
		FadeTransition ft1 = new FadeTransition();
		ft1.setDuration(Duration.millis(1000));
		ft1.setNode(PlayingScreen.getRoomPane());
		ft1.setFromValue(1);
		ft1.setToValue(0);
		
		ft1.setOnFinished((ActionEvent event) -> {		
			PlayingScreen.setRoomPane(currentRoom);
			
			FadeTransition ft2 = new FadeTransition();
			ft2.setDuration(Duration.millis(1000));
			ft2.setNode(PlayingScreen.getRoomPane());
			ft2.setFromValue(0);
			ft2.setToValue(1);
			
			ft2.play();
		});
		
		ft1.play();

	}
	
	public static void endGame(boolean isWin) {
		PlayingScreen.getAnimation().stop();
		RenderableHolder.bgMusic.get("PlayingScreenBGM").stop();
		
		makeSceneFadeTransition(isWin);
		
		return;
	}
	
	private static void makeSceneFadeTransition(boolean isWin ) {
		FadeTransition ft1 = new FadeTransition();
		ft1.setDuration(Duration.millis(2000));
		ft1.setNode(PlayingScreen.getRoomPane().getParent().getParent());
		ft1.setFromValue(1);
		ft1.setToValue(0);
		
		ft1.setOnFinished((ActionEvent event) -> {		
			EndingScreen endingScreen = new EndingScreen(isWin);
			Stage stage = (Stage)(PlayingScreen.getTimerPane().getScene().getWindow());
			Scene scene = new Scene(endingScreen);
			stage.setScene(scene);
			endingScreen.setOpacity(0);
			
			FadeTransition ft2 = new FadeTransition();
			ft2.setDuration(Duration.millis(2000));
			ft2.setNode(endingScreen);
			ft2.setFromValue(0);
			ft2.setToValue(1);
			ft2.play();
			
			stage.show();
		});
		
		ft1.play();

	}
	
}