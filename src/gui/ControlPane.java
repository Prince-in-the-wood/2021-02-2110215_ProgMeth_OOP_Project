package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sharedObject.RenderableHolder;

public class ControlPane extends VBox{
	private Button startButton;
	private Button instructionButton;
	private Button creditButton;
	private Button exitButton;
	
	public ControlPane() {
		startButton = new Button("Start");
		instructionButton = new Button("Instruction");
		creditButton = new Button("Credit");
		exitButton = new Button("Exit");
		
		this.initializeButtonStyle(startButton);
		this.initializeButtonStyle(instructionButton);
		this.initializeButtonStyle(creditButton);
		this.initializeButtonStyle(exitButton);
		
		//startButton.setOnMouseClicked(event -> Start() );
		//instructionButton.setOnMouseClicked(event -> method() );
		//creditButton.setOnMouseClicked(event -> method() );
		//exitButton.setOnMouseClicked(event -> method() );
		
		this.getChildren().addAll(startButton, instructionButton, creditButton, exitButton );
		this.setAlignment(Pos.CENTER);
	}

	public void initializeButtonStyle(Button button) {
		DropShadow shadow = new DropShadow();
		String buttonStyle = "-fx-background-color: transparent; -fx-text-fill: #FFBD51; "
							+ "-fx-font-family: "+ RenderableHolder.juiceICTFont.toString();
		shadow.setColor(Color.WHEAT);
		
		button.setStyle(buttonStyle);
		button.setFont(RenderableHolder.juiceICTFont);
		button.setOnMouseEntered(event -> {
			button.setEffect(shadow);
		} );
		button.setOnMouseExited(event ->{
			button.setEffect(null);
		});
	}
}
