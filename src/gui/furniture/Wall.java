package gui.furniture;

import gui.base.Furniture;
import gui.base.RoomName;

public class Wall extends Furniture{
	private final String bedroomWallURL;
	private final String livingroomWallURL;
	private final String libraryroomWallURL;
	private final String gardenWallURL;
	private RoomName roomName;
	
	public Wall(String name, int xPosition, int yPosition, RoomName roomName) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.bedroomWallURL = "bedroomWall.png";
		this.livingroomWallURL = "livingroomWall.png";
		this.libraryroomWallURL = "libraryroomWall.png";
		this.gardenWallURL = "gardenWall.png";
		this.roomName = roomName; 
	}

	
	//setter and geter
	public RoomName getRoomName() {
		return roomName;
	}

	public void setRoomName(RoomName roomName) {
		this.roomName = roomName;
	}

	public String getBedroomWallURL() {
		return bedroomWallURL;
	}

	public String getLivingroomWallURL() {
		return livingroomWallURL;
	}

	public String getLibraryroomWallURL() {
		return libraryroomWallURL;
	}

	public String getGardenWallURL() {
		return gardenWallURL;
	}

}
