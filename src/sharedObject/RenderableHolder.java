package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.base.Direction;
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
	public static Map<Direction, Image> characterSprite = new HashMap<Direction, Image>();
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
		
		loadMainMenuResource();
		loadCharacterSpriteAndBody();
		loadItemResource();
		loadBedroomResource();
		
	}
	
	private static void loadMainMenuResource() {
	
		background.put("MainMenu",new Image(ClassLoader.getSystemResource("MainMenu.png").toString()));
		background.put("Logo",new Image(ClassLoader.getSystemResource("Logo.png").toString()));
		background.put("OldPaper",new Image(ClassLoader.getSystemResource("OldPaperBG.jpeg").toString()));
		background.put("HowToPlay",new Image(ClassLoader.getSystemResource("HowToPlay.png").toString()));
		
		bgMusic.put("MainMenuBGM", new AudioClip(ClassLoader.getSystemResource("MemoriesBGM.mp3").toString()));
		soundFX.put("ButtonClick", new AudioClip(ClassLoader.getSystemResource("ClickSFX.wav").toString()));
		
		juiceICTFont = Font.loadFont( ClassLoader.getSystemResource("JUICE.ttf").toString(), 45 );
		couriterryFont = Font.loadFont( ClassLoader.getSystemResource("AatrixCOURITER.ttf").toString(), 20 );
	
	}
	
	private static void loadCharacterSpriteAndBody() {

		characterBody.put(Emotion.NORMAL, new Image(ClassLoader.getSystemResource("Character_Normal.png").toString()));
		characterBody.put(Emotion.WORRIED, new Image(ClassLoader.getSystemResource("Character_Worried.png").toString()));
		characterBody.put(Emotion.SHOCK, new Image(ClassLoader.getSystemResource("Character_Shock.png").toString()));
		
		characterSprite.put(Direction.DOWN, new Image(ClassLoader.getSystemResource("character-sprite/character_sprite_front.png").toString()));
		characterSprite.put(Direction.UP, new Image(ClassLoader.getSystemResource("character-sprite/character_sprite_back.png").toString()));
		characterSprite.put(Direction.LEFT, new Image(ClassLoader.getSystemResource("character-sprite/character_sprite_left.png").toString()));
		characterSprite.put(Direction.RIGHT, new Image(ClassLoader.getSystemResource("character-sprite/character_sprite_right.png").toString()));
	}
	
	private static void loadItemResource() {
		itemSprite.put("Key",new Image(ClassLoader.getSystemResource("item/keys.png").toString()));
		itemSprite.put("PocketKnife",new Image(ClassLoader.getSystemResource("item/knife.png").toString()));
		
		itemSprite.put("Melody",new Image(ClassLoader.getSystemResource("item/doll_orange.png").toString()));
		itemSprite.put("Ivy",new Image(ClassLoader.getSystemResource("item/doll_green.png").toString()));
		itemSprite.put("Scilla",new Image(ClassLoader.getSystemResource("item/doll_blue.png").toString()));
		itemSprite.put("Snowdrop",new Image(ClassLoader.getSystemResource("item/doll_white.png").toString()));
	}
	
	private static void loadBedroomResource() {
		background.put("Bedroom",new Image(ClassLoader.getSystemResource("bedroom/BedroomBG.png").toString()));
		
		furnitureSprite.put("Bed",new Image(ClassLoader.getSystemResource("bedroom/Bed.png").toString()));
		furnitureSprite.put("TableWithLamp",new Image(ClassLoader.getSystemResource("bedroom/TableWithLamp.png").toString()));
		furnitureSprite.put("TableWithNote",new Image(ClassLoader.getSystemResource("bedroom/TableWithNote.png").toString()));
		furnitureSprite.put("Window",new Image(ClassLoader.getSystemResource("bedroom/Window.png").toString()));
		furnitureSprite.put("OpenedWindow",new Image(ClassLoader.getSystemResource("bedroom/OpenedWindow.png").toString()));
		furnitureSprite.put("Cupboard",new Image(ClassLoader.getSystemResource("bedroom/Cupboard.png").toString()));
		furnitureSprite.put("OpenedCupboard",new Image(ClassLoader.getSystemResource("bedroom/OpenedCupboard.png").toString()));
		furnitureSprite.put("Chair",new Image(ClassLoader.getSystemResource("bedroom/Chair.png").toString()));
	}

	public void add(IRenderable entity) {
		System.out.println("add");
		entities.add(entity);
		Collections.sort(entities, comparator);
	}

	public List<IRenderable> getEntities() {
		return entities;
	}
}
