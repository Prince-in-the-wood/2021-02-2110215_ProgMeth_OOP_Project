package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class ItemInHandBox extends StackPane{

	private static ImageView itemImage = new ImageView();
	
	public ItemInHandBox() {
		
		BorderStroke borderStroke = new BorderStroke(Color.web("#FFBD51"), BorderStrokeStyle.SOLID,
				  									new CornerRadii(10), new BorderWidths(5));
		this.setBorder(new Border(borderStroke));
		this.setMaxSize(200, 140);
		this.setMinSize(200, 140);
		this.setPadding(new Insets(10));
		
		this.getChildren().add(itemImage);
		this.setAlignment(Pos.CENTER);
	}
	
	public static void setImageInBox(Image image) {
		itemImage.setImage(image);
	}
	
	public static void deleteImageInBox() {
		itemImage.setImage(null);
	}
 

}
