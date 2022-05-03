package gui.furniture;

import gui.base.Furniture;
import gui.base.RoomName;

public class Floor extends Furniture {
	private final String roomFloorURL;
	private final String gardenFloorURL;
	private RoomName roomName;
	
	public Floor(String name, int xPosition, int yPosition, RoomName roomName) {
		super(name, xPosition, yPosition);
		// TODO Auto-generated constructor stub
		
		this.roomFloorURL = "roomFloor.png";
		this.gardenFloorURL = "gardenFloor.png";
		this.roomName = roomName;
	}

	//setter and getter
	public RoomName getRoomName() {
		return roomName;
	}

	public void setRoomName(RoomName roomName) {
		this.roomName = roomName;
	}

	public String getRoomFloorURL() {
		return roomFloorURL;
	}

	public String getGardenFloorURL() {
		return gardenFloorURL;
	}

}
