package screen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sharedObject.RenderableHolder;

public class EndingScreen extends VBox{

	private StackPane endingTextPane;
	private Button menuButton;
	
	
	public EndingScreen(boolean isWin) {
		
		initializeEndingTextPane(isWin);
		initializeMenuButtonPane();
		
		this.getChildren().addAll(endingTextPane, menuButton );
		this.setPadding(new Insets(60));
		this.setSpacing(0);
		this.setAlignment(Pos.TOP_CENTER);
		
		this.setMaxSize(1120, 760);
		this.setMinSize(1120, 760);

		BackgroundSize bgSize = new BackgroundSize(1120,760,false,false,false,false);
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.background.get("EndingScreen"),
		        						  null, null, null, bgSize)));
		
		RenderableHolder.bgMusic.get("MainMenuBGM").setCycleCount(MainMenu.INDEFINITE);
		RenderableHolder.bgMusic.get("MainMenuBGM").play();
	}
	
	private void initializeEndingTextPane(boolean isWin) {
		endingTextPane = new StackPane();
		
		endingTextPane.setMinSize( 470, 500 );
		endingTextPane.setMaxSize( 470, 500 );
		
		endingTextPane.setPadding(new Insets(5));;
		
		Text endingText;
		
		if( isWin ) {
			endingText = new Text("In the end,\n"
								+ "Anna found herself is in her dream.\n"
								+ "But is she really dreaming?\n"
								+ "Or it is the world she create?\n"
								+ "\n\n\nTo be continue...");
		}else {
			endingText = new Text("And then Anna fall asleep again...\n"
								+ "Losing her memory...\n"
								+ "And go back to the bedroom\n"
								+ "again and again...");
		}
		
		endingTextPane.getChildren().add(endingText);
		
		endingText.setFont(RenderableHolder.couriterryFont);
		endingText.setFill(Color.web("#654321"));
		
		BackgroundSize bgSize = new BackgroundSize(600,500,false,false,false,false);
		endingTextPane.setBackground(new Background(new BackgroundImage(RenderableHolder.background.get("OldPaper"),
		        						  null, null, BackgroundPosition.CENTER, bgSize)));
	}
	
	private void initializeMenuButtonPane() {
		menuButton = new Button("Menu");
		
		DropShadow shadow = new DropShadow();
		String buttonStyle = "-fx-background-color: transparent; -fx-text-fill: #FFBD51; "
							+ "-fx-font-family: "+ RenderableHolder.juiceICTFont.toString();
		shadow.setColor(Color.WHEAT);
		shadow.setRadius(20.0);
		
		menuButton.setStyle(buttonStyle);
		menuButton.setFont(RenderableHolder.juiceICTFont);
		menuButton.setOnMouseEntered(event -> {
			menuButton.setEffect(shadow);
		} );
		menuButton.setOnMouseExited(event ->{
			menuButton.setEffect(null);
		});
		
		menuButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			
			RenderableHolder.bgMusic.get("MainMenuBGM").stop();
			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(new MainMenu());
			
			stage.setScene(scene);
			stage.show();
		});
		
	}

}
