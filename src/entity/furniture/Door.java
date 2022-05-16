package entity.furniture;

import entity.base.Furniture;
import entity.base.Item;
import entity.item.Key;
import gui.DialoguePane;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.GameController;
import logic.Player;

public class Door extends Furniture{

	public Door(String name, int xPosition, int yPosition, int z) {
		super( name, xPosition, yPosition, z);
	}
	
	@Override
	public void useItem() {
		Item itemInHand = Player.getItemInHand();
		
		if( itemInHand instanceof Key && ((Key)itemInHand).useWith(this) ) {
			GameController.getCurrentRoom().setIsGameEnd(true);			
		}else {
			DialoguePane.setGameText("I think it doesn't fit here.");
		}
	}
	
	@Override
	public void observe() {
		DialoguePane.setGameText("The door is locked! I must find the key");
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
		gc.setFill(Color.BROWN);
		gc.fillRect(this.getxPosition(), this.getyPosition(), 40, 40);
		
	}

}
