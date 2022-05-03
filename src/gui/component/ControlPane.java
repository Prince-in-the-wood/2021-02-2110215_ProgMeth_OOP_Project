package gui.component;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ControlPane extends VBox{
	private Button startButton;
	private Button instructionButton;
	private Button creditButton;
	private Button exitButton;
	
	public ControlPane() {
		
	}

	//getter and setter
	public Button getStartButton() {
		return startButton;
	}

	public void setStartButton(Button startButton) {
		this.startButton = startButton;
	}

	public Button getInstructionButton() {
		return instructionButton;
	}

	public void setInstructionButton(Button instructionButton) {
		this.instructionButton = instructionButton;
	}

	public Button getCreditButton() {
		return creditButton;
	}

	public void setCreditButton(Button creditButton) {
		this.creditButton = creditButton;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public void setExitButton(Button exitButton) {
		this.exitButton = exitButton;
	}
	
}
