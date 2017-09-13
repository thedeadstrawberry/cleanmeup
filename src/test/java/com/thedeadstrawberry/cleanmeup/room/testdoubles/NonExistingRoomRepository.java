package com.thedeadstrawberry.cleanmeup.room.testdoubles;

import com.thedeadstrawberry.cleanmeup.room.Room;
import com.thedeadstrawberry.cleanmeup.room.RoomDoesNotExistException;
import com.thedeadstrawberry.cleanmeup.room.RoomRepository;

public class NonExistingRoomRepository implements RoomRepository {
    public Room findRoom(int roomId) {
        throw new RoomDoesNotExistException();
    }
}
