package gui;

import javafx.scene.layout.Pane;

public class CharacterPane extends Pane {
	private final String normalFaceURL;
	private final String worriedFaceURL;
	private final String surprisedFaceURL;
	
	public CharacterPane() {
		this.normalFaceURL = "normalFace.png";
		this.worriedFaceURL = "worriedFace.png";
		this.surprisedFaceURL = "surprisedFace.png";
	}

	public String getNormalFaceURL() {
		return normalFaceURL;
	}
	
	public String getWorriedFaceURL() {
		return worriedFaceURL;
	}
	
	public String getSurprisedFaceURL() {
		return surprisedFaceURL;
	}
}
