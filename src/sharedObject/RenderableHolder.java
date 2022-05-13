package sharedObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import entity.base.Emotion;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class RenderableHolder {
	private static final RenderableHolder instance = new RenderableHolder();

	private List<IRenderable> entities;
	private Comparator<IRenderable> comparator;
	public static Map<String, Image> furnitureSprite;
	public static Map<String, Image> itemSprite;
	public static Map<Emotion, Image> characterFullBody;
	public static Map<String, Image> characterSprite;
	public static Map<String, Image> background;
	public static Map<String, AudioClip> soundFX;
	public static Map<String, AudioClip> bgMusic;

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
		bgMusic.put("MainMenu", new AudioClip(ClassLoader.getSystemResource("MainMenu.wav").toString()));
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
