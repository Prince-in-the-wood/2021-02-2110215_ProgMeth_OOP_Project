package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sharedObject.RenderableHolder;

public class TimerPane extends StackPane{
	private Text timer;
	
	public TimerPane() {
		timer = new Text("00:00:00");
		//It should be text from timer
		
		timer.setFont(RenderableHolder.couriterryFont);
		timer.setFill(Color.web("#FFBD51"));
		
		this.setMinSize(100, 50);
		this.setMaxSize(100, 50);
		this.setAlignment(Pos.CENTER);
		
		this.getChildren().addAll(timer);
		
	}

	//getter and setter
	public Text getTimer() {
		return timer;
	}

	public void setTimer(String timer) {
		this.timer.setText(timer);
	}

}
