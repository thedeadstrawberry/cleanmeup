package com.thedeadstrawberry.cleanmeup.usercases;

import com.thedeadstrawberry.cleanmeup.room.Room;
import com.thedeadstrawberry.cleanmeup.room.RoomRepository;
import com.thedeadstrawberry.cleanmeup.user.User;
import com.thedeadstrawberry.cleanmeup.user.UserRepository;

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
        User user = userRepository.findUser(username);
        room.clean(username);
        user.awardPoints();
        roomRepository.saveRoom(room);
        userRepository.saveUser(user);
    }
}
