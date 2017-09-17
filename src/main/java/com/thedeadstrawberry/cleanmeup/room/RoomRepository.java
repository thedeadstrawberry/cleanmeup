package com.thedeadstrawberry.cleanmeup.room;

public interface RoomRepository {

	Room findRoom(int roomId);
	void saveRoom(Room room);
}
