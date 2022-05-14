package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screen.MainMenu;


public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		MainMenu mainMenu = new MainMenu();
		Scene scene = new Scene(mainMenu);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Missing: Hide And Seek");
		primaryStage.setHeight(760);
		primaryStage.setWidth(1120);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
