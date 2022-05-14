package gui;

import application.Main;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
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

	public void initializeButtonStyle(Button button) {
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
	
	public void initializeStartButton() {
		startButton = new Button("Start");
		this.initializeButtonStyle(startButton);
		
		startButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(new PlayingScreen());
			RenderableHolder.bgMusic.get("MainMenuBGM").stop();
			stage.setScene(scene);
			stage.show();
		} );
	}
	
	public void initializeInstructionButton() {
		instructionButton = new Button("Instruction");
		this.initializeButtonStyle(instructionButton);
		
		instructionButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			showInstructionWindow();
			});
	}
	
	public void initializeCreditButton() {
		creditButton = new Button("Credit");
		this.initializeButtonStyle(creditButton);		
		creditButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			showCreditWindow();
		});
	}
	
	public void initializeExitButton() {
		exitButton = new Button("Exit");
		this.initializeButtonStyle(exitButton);
		exitButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			System.exit(0);
		});
	}
	
	
	public void showCreditWindow() {
		Pane showPane = MainMenu.getWindowPane();
		Pane creditPane = MainMenu.getCreditPane();

		if( showPane.getChildren().isEmpty() || !showPane.getChildren().get(0).equals(creditPane)) {
			showPane.getChildren().clear();
			showPane.getChildren().add(creditPane);
		}else {
			showPane.getChildren().clear();
		}
	}
	
	public void showInstructionWindow() {
		Pane showPane = MainMenu.getWindowPane();
		Pane instructionPane = MainMenu.getInstructionPane();

		if( showPane.getChildren().isEmpty() || !showPane.getChildren().get(0).equals(instructionPane)) {
			showPane.getChildren().clear();
			showPane.getChildren().add(instructionPane);
		}else {
			showPane.getChildren().clear();
		}
	}
}
