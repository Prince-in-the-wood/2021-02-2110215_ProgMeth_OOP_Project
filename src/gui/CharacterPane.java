package gui;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import logic.Player;
import sharedObject.RenderableHolder;

public class CharacterPane extends StackPane {

	public CharacterPane() {
		
		setCharacterPane();
		
		this.setAlignment(Pos.CENTER);
	
	}
	
	public void setCharacterPane() {
		ImageView img = new ImageView(RenderableHolder.characterBody.get(Player.getPlayerEmotion()));
		img.setFitHeight(350);
		img.setPreserveRatio(true);
		this.getChildren().add(img);
	}

}
