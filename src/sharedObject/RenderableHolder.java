package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.base.Emotion;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Map<String, Image> furnitureSprite = new HashMap<String, Image>();
	public static Map<String, Image> itemSprite = new HashMap<String, Image>();
	public static Map<Emotion, Image> characterBody = new HashMap<Emotion, Image>();
	public static Map<String, Image> characterSprite = new HashMap<String, Image>();
	public static Map<String, Image> background = new HashMap<String, Image>();
	public static Map<String, AudioClip> soundFX = new HashMap<String, AudioClip>();
	public static Map<String, AudioClip> bgMusic = new HashMap<String, AudioClip>();
	public static Font juiceICTFont;
	public static Font couriterryFont;

	static {
		loadResource();
	}

	public RenderableHolder() {
		entities = new ArrayList<IRenderable>();
		comparator = (IRenderable o1, IRenderable o2) -> {
			if (o1.getZ() > o2.getZ())
				return 1;
			return -1;
		};
	}

	public static RenderableHolder getInstance() {
		return instance;
	}

	public static void loadResource() {
		background.put("MainMenu",new Image(ClassLoader.getSystemResource("MainMenu.png").toString()));
		background.put("Logo",new Image(ClassLoader.getSystemResource("Logo.png").toString()));
		background.put("OldPaper",new Image(ClassLoader.getSystemResource("OldPaperBG.jpeg").toString()));
		background.put("HowToPlay",new Image(ClassLoader.getSystemResource("HowToPlay.png").toString()));
		
		characterBody.put(Emotion.NORMAL, new Image(ClassLoader.getSystemResource("Character_Normal.png").toString()));
		characterBody.put(Emotion.WORRIED, new Image(ClassLoader.getSystemResource("Character_Worried.png").toString()));
		characterBody.put(Emotion.SHOCK, new Image(ClassLoader.getSystemResource("Character_Shock.png").toString()));
		
		bgMusic.put("MainMenuBGM", new AudioClip(ClassLoader.getSystemResource("MemoriesBGM.mp3").toString()));
		soundFX.put("ButtonClick", new AudioClip(ClassLoader.getSystemResource("ClickSFX.wav").toString()));
		
		juiceICTFont = Font.loadFont( ClassLoader.getSystemResource("JUICE.ttf").toString(), 45 );
		couriterryFont = Font.loadFont( ClassLoader.getSystemResource("AatrixCOURITER.ttf").toString(), 20 );
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public void update() {
		for (int i = entities.size() - 1; i >= 0; i--) {
			// if update
		}
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
