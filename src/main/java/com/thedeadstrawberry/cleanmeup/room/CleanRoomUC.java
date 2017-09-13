package com.thedeadstrawberry.cleanmeup.room;

public class CleanRoomUC {
    private final RoomRepository roomRepository;
    private final int roomId;
    private final UserRepository userRepository;
    private final String username;

    public CleanRoomUC(RoomRepository roomRepository, UserRepository userRepository, int roomId, String username) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.roomId = roomId;
        this.username = username;
    }

    public void clean() {
        Room room = roomRepository.findRoom(roomId);
        userRepository.findUser(username);
        room.clean();
    }
}
