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
		loadLivingRoomResource();
		loadLibraryResource();
		loadGardenResource();
	}
	
	private static void loadMainMenuResource() {
	
		background.put("MainMenu",new Image(ClassLoader.getSystemResource("MainMenu.png").toString()));
		background.put("Logo",new Image(ClassLoader.getSystemResource("Logo.png").toString()));
		background.put("OldPaper",new Image(ClassLoader.getSystemResource("OldPaperBG.png").toString()));
		background.put("HowToPlay",new Image(ClassLoader.getSystemResource("HowToPlay.png").toString()));
		background.put("EndingScreen",new Image(ClassLoader.getSystemResource("EndingScreen.PNG").toString()));
		
		bgMusic.put("MainMenuBGM", new AudioClip(ClassLoader.getSystemResource("MemoriesBGM.mp3").toString()));
		bgMusic.put("PlayingScreenBGM", new AudioClip(ClassLoader.getSystemResource("playingScreenBGM.mp3").toString()));
		
		soundFX.put("ButtonClick", new AudioClip(ClassLoader.getSystemResource("ClickSFX.wav").toString()));
		
		soundFX.put("PickItem", new AudioClip(ClassLoader.getSystemResource("ClickSFX.wav").toString()));
		soundFX.get("PickItem").setVolume(0.5);
		
		soundFX.put("BreakingGlass", new AudioClip(ClassLoader.getSystemResource("breakingGlassSFX.mp3").toString()));
		soundFX.put("CloseCupboard", new AudioClip(ClassLoader.getSystemResource("CloseSFX.mp3").toString()));
		soundFX.put("OpenCupboard", new AudioClip(ClassLoader.getSystemResource("OpenSFX.mp3").toString()));
		soundFX.put("Lock", new AudioClip(ClassLoader.getSystemResource("lockSFX.mp3").toString()));
		soundFX.put("KeyUsing", new AudioClip(ClassLoader.getSystemResource("keyUsing.wav").toString()));
		
		soundFX.put("CutSofa", new AudioClip(ClassLoader.getSystemResource("CutSofa.wav").toString()));
		soundFX.get("CutSofa").setVolume(0.5);
		
		soundFX.put("OpenWindow", new AudioClip(ClassLoader.getSystemResource("OpenWindow.wav").toString()));
		soundFX.put("Tab", new AudioClip(ClassLoader.getSystemResource("tab.wav").toString()));
		
		
		juiceICTFont = Font.loadFont( ClassLoader.getSystemResource("JUICE.TTF").toString(), 45 );
		couriterryFont = Font.loadFont( ClassLoader.getSystemResource("AatrixCOURITER.ttf").toString(), 20 );
	
	}
	
	private static void loadCharacterSpriteAndBody() {

		characterBody.put(Emotion.NORMAL, new Image(ClassLoader.getSystemResource("Character_Normal.PNG").toString()));
		characterBody.put(Emotion.WORRIED, new Image(ClassLoader.getSystemResource("Character_Worried.PNG").toString()));
		characterBody.put(Emotion.SHOCK, new Image(ClassLoader.getSystemResource("Character_Shock.PNG").toString()));
		
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
		furnitureSprite.put("OpenedCupboard",new Image(ClassLoader.getSystemResource("bedroom/OpenedCupBoard.png").toString()));
		furnitureSprite.put("Chair",new Image(ClassLoader.getSystemResource("bedroom/Chair.png").toString()));
	}
	
	private static void loadLivingRoomResource() {
		background.put("LivingRoom",new Image(ClassLoader.getSystemResource("livingRoom/LivingRoomBG.png").toString()));
		
		furnitureSprite.put("IvyPic",new Image(ClassLoader.getSystemResource("livingRoom/IvyPic.png").toString()));
		furnitureSprite.put("FamilyPic",new Image(ClassLoader.getSystemResource("livingRoom/FamilyPic.png").toString()));
		furnitureSprite.put("ShieldPic",new Image(ClassLoader.getSystemResource("livingRoom/ShieldPic.png").toString()));
		
		furnitureSprite.put("OpenedSafe",new Image(ClassLoader.getSystemResource("livingRoom/OpenedSafe.png").toString()));
		furnitureSprite.put("ClosedSafe",new Image(ClassLoader.getSystemResource("livingRoom/Safe.png").toString()));
		
		furnitureSprite.put("FrontSofa",new Image(ClassLoader.getSystemResource("livingRoom/FrontSofa.png").toString()));
		furnitureSprite.put("CutSofa",new Image(ClassLoader.getSystemResource("livingRoom/TearedSofa.png").toString()));
		furnitureSprite.put("LeftSofa",new Image(ClassLoader.getSystemResource("livingRoom/LeftSofa.png").toString()));
		furnitureSprite.put("RightSofa",new Image(ClassLoader.getSystemResource("livingRoom/RightSofa.png").toString()));
		furnitureSprite.put("SouthSofa",new Image(ClassLoader.getSystemResource("livingRoom/SouthSofa.png").toString()));
		
		furnitureSprite.put("LongTableWithLamp",new Image(ClassLoader.getSystemResource("livingRoom/LongTableWithLamp.png").toString()));
	
	}
	
	private static void loadLibraryResource() {
		background.put("Library",new Image(ClassLoader.getSystemResource("library/LibraryBG.png").toString()));
		
		furnitureSprite.put("BigBookshelf",new Image(ClassLoader.getSystemResource("library/bigBookshelf.png").toString()));
		furnitureSprite.put("Bookshelf1",new Image(ClassLoader.getSystemResource("library/bookshelf_11.png").toString()));
		furnitureSprite.put("Bookshelf2",new Image(ClassLoader.getSystemResource("library/bookshelf_12.png").toString()));
		furnitureSprite.put("Bookshelf3",new Image(ClassLoader.getSystemResource("library/bookshelf_21.png").toString()));
		furnitureSprite.put("Bookshelf4",new Image(ClassLoader.getSystemResource("library/bookshelf_22.png").toString()));
		
		furnitureSprite.put("LeftTableWithLamp",new Image(ClassLoader.getSystemResource("library/leftLamp.png").toString()));
		furnitureSprite.put("RightTableWithLamp",new Image(ClassLoader.getSystemResource("library/rightLamp.png").toString()));
		
		furnitureSprite.put("TableWithBook",new Image(ClassLoader.getSystemResource("library/table.png").toString()));
		furnitureSprite.put("LeftChair",new Image(ClassLoader.getSystemResource("library/leftChair.png").toString()));
		
	}
	
	private static void loadGardenResource() {
		background.put("Garden",new Image(ClassLoader.getSystemResource("garden/GardenBG.png").toString()));
		
		furnitureSprite.put("Mirror",new Image(ClassLoader.getSystemResource("garden/Mirror.png").toString()));
		furnitureSprite.put("BehindMirror",new Image(ClassLoader.getSystemResource("garden/BehindMirror.png").toString()));
		
		furnitureSprite.put("StatueWithMoon",new Image(ClassLoader.getSystemResource("garden/statue_moon.png").toString()));
		furnitureSprite.put("StatueWithBook",new Image(ClassLoader.getSystemResource("garden/statue_book.png").toString()));
		furnitureSprite.put("StatueWithSofa",new Image(ClassLoader.getSystemResource("garden/statue_sofa.png").toString()));
		furnitureSprite.put("StatueWithLeaf",new Image(ClassLoader.getSystemResource("garden/statue_leaf.png").toString()));
		
		furnitureSprite.put("RealBed",new Image(ClassLoader.getSystemResource("garden/MysteryBox.png").toString()));
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
