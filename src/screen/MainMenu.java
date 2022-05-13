package screen;

public class MainMenu {

	// ห�?�?า�?ร�?�?อ�?เ�?ม
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
