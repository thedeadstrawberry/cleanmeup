package com.thedeadstrawberry.cleanmeup.room;

public class AlreadyCleanRoomRepositoryStub implements RoomRepository {

    @Override
    public Room findRoom(int roomId) {
        Room room = new Room();
        room.setIsClean(true);
        return room;
    }

    @Override
    public void saveRoom(Room room) {

    }
}
