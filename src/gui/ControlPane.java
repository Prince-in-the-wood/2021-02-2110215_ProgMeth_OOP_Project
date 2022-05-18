package gui;

import application.Main;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import screen.EndingScreen;
import screen.MainMenu;
import screen.PlayingScreen;
import sharedObject.RenderableHolder;

public class ControlPane extends VBox{
	private Button startButton;
	private Button instructionButton;
	private Button creditButton;
	private Button exitButton;
	
	public ControlPane() {
		
		initializeStartButton();
		initializeInstructionButton();
		initializeCreditButton();
		initializeExitButton();
		
		this.getChildren().addAll(startButton, instructionButton, creditButton, exitButton );
		this.setAlignment(Pos.CENTER);
	}

	private void initializeButtonStyle(Button button) {
		DropShadow shadow = new DropShadow();
		String buttonStyle = "-fx-background-color: transparent; -fx-text-fill: #FFBD51; "
							+ "-fx-font-family: "+ RenderableHolder.juiceICTFont.toString();
		shadow.setColor(Color.WHEAT);
		shadow.setRadius(20.0);
		
		button.setStyle(buttonStyle);
		button.setFont(RenderableHolder.juiceICTFont);
		button.setOnMouseEntered(event -> {
			button.setEffect(shadow);
		} );
		button.setOnMouseExited(event ->{
			button.setEffect(null);
		});
	}
	
	private void initializeStartButton() {
		startButton = new Button("Start");
		this.initializeButtonStyle(startButton);
		
		startButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			makeFadeTransition(stage);
		} );
	}
	
	private void makeFadeTransition(Stage stage){
		
		FadeTransition ft1 = new FadeTransition();
		ft1.setDuration(Duration.millis(1000));
		ft1.setNode(this.getParent());
		ft1.setFromValue(1);
		ft1.setToValue(0);
		
		ft1.setOnFinished((ActionEvent event) -> {		
			
			RenderableHolder.bgMusic.get("MainMenuBGM").stop();
			PlayingScreen playingScreen = new PlayingScreen();
			Scene scene = new Scene(playingScreen);
			stage.setScene(scene);
			stage.show();
			
		});
		
		ft1.play();

	}
	
	private void initializeInstructionButton() {
		instructionButton = new Button("Instruction");
		this.initializeButtonStyle(instructionButton);
		
		instructionButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			MainMenu.showInstructionWindow();
			});
	}
	
	private void initializeCreditButton() {
		creditButton = new Button("Credit");
		this.initializeButtonStyle(creditButton);		
		creditButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			MainMenu.showCreditWindow();
		});
	}
	
	private void initializeExitButton() {
		exitButton = new Button("Exit");
		this.initializeButtonStyle(exitButton);
		exitButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			System.exit(0);
		});
	}
	
	

}
