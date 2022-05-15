package screen;

import entity.base.Room;
import gui.CharacterPane;
import gui.DialoguePane;
import gui.ItemInHandBox;
import gui.TimerPane;
import gui.room.Bedroom;
import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.GameController;
import logic.Player;
import sharedObject.RenderableHolder;

public class PlayingScreen extends VBox{

	private static Button menuButton;
	private static CharacterPane character;
	private static DialoguePane dialoguePane;
	private static ItemInHandBox itemInHandBox;
	private static TimerPane timerPane;
	private static Pane room;
	private static AnimationTimer animation;
	
	public PlayingScreen() {
		
		VBox sidePane = initializeSidePane();
		
		dialoguePane = new DialoguePane();
		itemInHandBox = new ItemInHandBox();
		
		room = new Pane();
		
		room.setMaxSize(720, 520);
		room.setMinSize(720, 520);
		room.setBorder(new Border(new BorderStroke(Color.web("#FFBD51"), BorderStrokeStyle.SOLID, null, null)));
		
		HBox upperPane = new HBox();
		upperPane.getChildren().addAll(sidePane, room);
		
		HBox lowerPane = new HBox();
		lowerPane.getChildren().addAll(dialoguePane, itemInHandBox);
		lowerPane.setSpacing(10);
		
		this.getChildren().addAll(upperPane, lowerPane);
		
		this.setBackground(new Background(new BackgroundFill( Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setPadding(new Insets(20));
		this.setSpacing(10);
		this.setHeight(760);
		this.setWidth(1120);
		
		animation = new AnimationTimer() {
			public void handle(long now) {
				GameController.getCurrentRoom().paintComponent();
				Player.logicUpdate();
			}
		};
		animation.start();
	}
	
	public void initializeMenuButton() {
		
		menuButton = new Button("MENU");
		
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.WHEAT);
		shadow.setRadius(20.0);
		
		String buttonStyle = "-fx-background-color: #FFBD51; -fx-text-fill: #654321;"
				+ "-fx-font-family:" + RenderableHolder.couriterryFont.toString();
		
		menuButton.setFont(RenderableHolder.couriterryFont);
		menuButton.setStyle(buttonStyle);
		
		menuButton.setMinSize(100, 50);
		menuButton.setMaxSize(100, 50);

		menuButton.setOnMouseEntered(event -> {
			menuButton.setEffect(shadow);
		} );
		
		menuButton.setOnMouseExited(event ->{
			menuButton.setEffect(null);
		});
		
		menuButton.setOnMouseClicked(event -> {
			RenderableHolder.soundFX.get("ButtonClick").play();
			
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(new MainMenu());
//			RenderableHolder.bgMusic.get("MainMenuBGM").stop();
			stage.setScene(scene);
			stage.show();
		});
	}
	
	public VBox initializeSidePane() {
		
		initializeMenuButton();
		character = new CharacterPane();
		timerPane = new TimerPane();
		
		VBox sidePane = new VBox();
		
		sidePane.getChildren().addAll(menuButton, timerPane, character);
		sidePane.setPadding(new Insets(30, 0, 0, 10 ));
		sidePane.setSpacing(20);
		sidePane.setMinSize(300,523);
		sidePane.setMaxSize(300,523);
		sidePane.setAlignment(Pos.TOP_CENTER);
		
		return sidePane;
		
	}

	public static TimerPane getTimerPane() {
		return timerPane;
	}

	public static AnimationTimer getAnimation() {
		return animation;
	}
	

}
