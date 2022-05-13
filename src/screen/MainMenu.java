package screen;

public class MainMenu {

	// à¸«à¸?à¹?à¸²à¹?à¸£à¸?à¸?à¸­à¸?à¹€à¸?à¸¡
	private final String gameLogoURL;
	private final String backgroundURL;
	
	public MainMenu() {
		this.backgroundURL = "background.png";
		this.gameLogoURL = "gameLogo.png";
	}
	
	
	// setter and getter
	public String getGameLogoURL() {
		return gameLogoURL;
	}

	public String getBackgroundURL() {
		return backgroundURL;
	}
}
