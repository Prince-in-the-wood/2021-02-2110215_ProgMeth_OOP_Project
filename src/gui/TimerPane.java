package gui;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class TimerPane extends Pane{
	private Text timer;
	
	public TimerPane() {
		
	}

	//getter and setter
	public Text getTimer() {
		return timer;
	}

	public void setTimer(Text timer) {
		this.timer = timer;
	}

}
