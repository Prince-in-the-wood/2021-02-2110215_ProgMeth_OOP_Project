package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sharedObject.RenderableHolder;

public class InstructionPane extends VBox {
	
	private Text header;
	private ImageView howToPlayPic;
	
	public InstructionPane() {

		initializeHeaderText();
		initializeHowToPlayPic();
		
		this.setSpacing(120);
		this.setPadding(new Insets(40));
		this.setAlignment(Pos.TOP_CENTER);
		
		BackgroundSize bgSize = new BackgroundSize(700,760,false,false,false,false);
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.background.get("OldPaper"),
		        						  null, null, BackgroundPosition.CENTER, bgSize)));
		
		this.getChildren().addAll(header, howToPlayPic );
	}
	
	public void initializeHeaderText() {

		header = new Text("How to play");
		
		header.setFont(RenderableHolder.juiceICTFont);
		String headerTextStyle = "-fx-text-fill: #654321; -fx-font-weight: bold;"
								+ "-fx-font-family: "+ RenderableHolder.juiceICTFont.toString();
		header.setStyle(headerTextStyle);
		
		header.setEffect(new DropShadow(10.0, Color.GRAY));
		header.setTextAlignment(TextAlignment.CENTER);
	}
	
	public void initializeHowToPlayPic() {
		howToPlayPic = new ImageView(RenderableHolder.background.get("HowToPlay"));
		howToPlayPic.setFitWidth(400);
		howToPlayPic.setPreserveRatio(true);
		
	}
	


}
