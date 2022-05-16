package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sharedObject.RenderableHolder;

public class DialoguePane extends StackPane{
	
	private static Text gameText= new Text();
	
	public DialoguePane() {
		
		gameText.setFont(RenderableHolder.couriterryFont);
		gameText.setFill(Color.web("#FFBD51"));
		
		BorderStroke borderStroke = new BorderStroke(Color.web("#FFBD51"), BorderStrokeStyle.SOLID,
													  new CornerRadii(10), new BorderWidths(5));
		this.setBorder(new Border(borderStroke));
		this.getChildren().add(gameText);
		
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.TOP_LEFT);
		
		this.setMaxSize(810, 140);
		this.setMinSize(810, 140);
	}
	
	public static void setGameText(String text) {
		gameText.setText(text);
	}
	
}
