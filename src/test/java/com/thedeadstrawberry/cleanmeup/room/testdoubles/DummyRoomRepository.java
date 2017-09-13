package com.thedeadstrawberry.cleanmeup.room.testdoubles;

import com.thedeadstrawberry.cleanmeup.room.Room;
import com.thedeadstrawberry.cleanmeup.room.RoomRepository;

/**
 * Created by carce on 12/09/2017.
 */
public class DummyRoomRepository implements RoomRepository {
    public Room findRoom(int roomId) {
        return null;
    }
}
