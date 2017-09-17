package com.thedeadstrawberry.cleanmeup.room;

public class DirtyRoomRepositorySpy implements RoomRepository {

	private Room savedRoom;

	@Override
	public Room findRoom(int roomId) {
		Room room = new Room();
		room.setIsClean(false);
		return room;
	}

	@Override
	public void saveRoom(Room room) {
		savedRoom = room;
	}

	public boolean isSavedRoomClean() {
		return savedRoom.isClean();
	}

	public String getRoomCleaner() {
		return savedRoom.getCleaner();
	}
}
