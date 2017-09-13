package com.thedeadstrawberry.cleanmeup.room.testdoubles;

import com.thedeadstrawberry.cleanmeup.room.Room;
import com.thedeadstrawberry.cleanmeup.room.RoomRepository;

public class AlreadyCleanRoomRepository implements RoomRepository {
    public Room findRoom(int roomId) {
        Room room = new Room();
        room.setIsClean(true);
        return room;
    }
}
