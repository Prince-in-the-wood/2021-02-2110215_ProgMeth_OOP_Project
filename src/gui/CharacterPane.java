package gui;

import entity.base.Emotion;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;

public class CharacterPane extends StackPane {

	public CharacterPane() {
		ImageView img = new ImageView(RenderableHolder.characterBody.get(Emotion.NORMAL));
		img.setFitHeight(350);
		img.setPreserveRatio(true);
		
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(img);
		
		//this.setPadding(new Insets(20));
	}

}
