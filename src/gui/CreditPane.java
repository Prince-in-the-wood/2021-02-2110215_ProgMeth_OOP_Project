package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import sharedObject.RenderableHolder;

public class CreditPane extends VBox {
	
	private Text header;
	private Text body;
	
	public CreditPane() {
		
		initializeHeaderText();
		initializeBodyText();
		
		this.setSpacing(150);
		this.setPadding(new Insets(50));
		this.setAlignment(Pos.TOP_CENTER);
		this.setMinSize(500, 600);
		this.setMaxSize(500, 600);
		
		this.setVisible(false);
		
		BackgroundSize bgSize = new BackgroundSize(700,760,false,false,false,false);
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.background.get("OldPaper"),
		        						  null, null, BackgroundPosition.CENTER, bgSize)));
	
		this.getChildren().addAll(header, body);
		
	}
	
	private void initializeHeaderText() {

		header = new Text("Credit");
		
		header.setFont(RenderableHolder.juiceICTFont);
		String headerTextStyle = "-fx-text-fill: #654321; -fx-font-weight: bold;"
								+ "-fx-font-family: "+ RenderableHolder.juiceICTFont.toString();
		header.setStyle(headerTextStyle);
		
		header.setEffect(new DropShadow(10.0, Color.GRAY));
		header.setTextAlignment(TextAlignment.CENTER);
	}
	
	private void initializeBodyText() {
		
		body = new Text("Designed and Created by\nTongRod99\n\nSupported by\nOur beloved family");
		body.setFont(RenderableHolder.couriterryFont);
		
		String bodyTextStyle = "-fx-text-fill: #654321; -fx-font-family: "
								+ RenderableHolder.couriterryFont.toString();
		body.setStyle(bodyTextStyle);

		body.setEffect(new DropShadow(5.0, Color.GRAY));
		body.setTextAlignment(TextAlignment.CENTER);
	}

}
