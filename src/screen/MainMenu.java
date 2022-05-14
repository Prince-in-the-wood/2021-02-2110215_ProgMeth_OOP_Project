package screen;

import gui.ControlPane;
import gui.CreditPane;
import gui.InstructionPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sharedObject.RenderableHolder;


public class MainMenu extends BorderPane{
	
	private static ControlPane controlPane;
	private static CreditPane creditPane;
	private static InstructionPane instructionPane;
	private static StackPane windowPane;
	private static VBox sidePane;
	
	public static final int INDEFINITE = -1;
	
	public MainMenu() {
		
		controlPane = new ControlPane();
		creditPane = new CreditPane();
		instructionPane = new InstructionPane();
		sidePane = new VBox();
		windowPane = new StackPane();
		
		sidePane.getChildren().addAll( new ImageView( RenderableHolder.background.get("Logo") ), controlPane );
		sidePane.setPadding(new Insets(75));
		
		windowPane.setAlignment(Pos.CENTER);
		windowPane.setPrefSize(600, 760);
		windowPane.setPadding(new Insets(50));
		
		this.setLeft(windowPane);
		this.setRight(sidePane);
	
		BackgroundSize bgSize = new BackgroundSize(1120,760,false,false,false,false);
		this.setBackground(new Background(new BackgroundImage(RenderableHolder.background.get("MainMenu"),
		        						  null, null, null, bgSize)));
		
		this.setPadding(new Insets(10));
		this.setHeight(760);
		this.setWidth(1120);
		
		RenderableHolder.bgMusic.get("MainMenuBGM").setCycleCount(INDEFINITE);
		RenderableHolder.bgMusic.get("MainMenuBGM").play();
	}

	public static ControlPane getControlPane() {
		return controlPane;
	}

	public static StackPane getWindowPane() {
		return windowPane;
	}

	public static VBox getSidePane() {
		return sidePane;
	}

	public static CreditPane getCreditPane() {
		return creditPane;
	}

	public static InstructionPane getInstructionPane() {
		return instructionPane;
	}
	
}
