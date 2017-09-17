package com.thedeadstrawberry.cleanmeup.room;

public class NonExistingRoomRepositoryStub implements RoomRepository {

    @Override
    public Room findRoom(int roomId) {
        throw new RoomDoesNotExistException();
    }

    @Override
    public void saveRoom(Room room) {

    }
}
