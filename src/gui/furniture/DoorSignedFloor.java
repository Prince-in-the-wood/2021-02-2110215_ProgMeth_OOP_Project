package gui.furniture;

import gui.base.RoomName;

public class DoorSignedFloor extends Floor {
	private final String doorSignedURL;
	
	public DoorSignedFloor(String name, int xPosition, int yPosition, RoomName roomName) {
		super(name, xPosition, yPosition, roomName);
		// TODO Auto-generated constructor stub
		
		this.doorSignedURL = "doorSigned.png";
	}

	//setter and getter
	public String getDoorSignedURL() {
		return doorSignedURL;
	}



}
