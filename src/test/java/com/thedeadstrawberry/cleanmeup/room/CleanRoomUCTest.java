package com.thedeadstrawberry.cleanmeup.room;

import com.thedeadstrawberry.cleanmeup.room.testdoubles.AlreadyCleanRoomRepository;
import com.thedeadstrawberry.cleanmeup.room.testdoubles.DummyRoomRepository;
import com.thedeadstrawberry.cleanmeup.room.testdoubles.DummyUserRepository;
import com.thedeadstrawberry.cleanmeup.room.testdoubles.NonExistingRoomRepository;
import com.thedeadstrawberry.cleanmeup.room.testdoubles.NonExistingUserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class CleanRoomUCTest {

    private CleanRoomUC cleanRoomUC;
    private RuntimeException expectedException;
    private RoomRepository roomRepository;
    private UserRepository userRepository;
    private int roomId;
    private String username;

    @Before
    public void setUp() {
        roomRepository = new DummyRoomRepository();
        userRepository = new DummyUserRepository();
        roomId = 1;
        username = "username";
    }

    @Test
    public void testRoomDoesNotExist() {
        givenNonExistingRoom();
        whenTryToCleanRoom();
        thenExpectRoomDoesNotExistException();
    }

    private void givenNonExistingRoom() {
        roomRepository = new NonExistingRoomRepository();
    }

    private void whenTryToCleanRoom() {
        try {
            cleanRoomUC = new CleanRoomUC(roomRepository, userRepository, roomId, username);
            cleanRoomUC.clean();
        } catch (RuntimeException e) {
            expectedException = e;
        }
    }

    private void thenExpectRoomDoesNotExistException() {
        assertThat(expectedException, instanceOf(RoomDoesNotExistException.class));
    }

    @Test
    public void testUserDoesNotExist() {
        givenNonExistingUser();
        whenTryToCleanRoom();
        thenExpectUserDoesNotExistException();
    }

    private void givenNonExistingUser() {
        userRepository = new NonExistingUserRepository();
    }

    private void thenExpectUserDoesNotExistException() {
        assertThat(expectedException, instanceOf(UserDoesNotExistException.class));
    }

    @Test
    public void testRoomIsAlreadyClean() {
        givenRoomIsClean();
        whenTryToCleanRoom();
        thenExpectRoomIsAlreadyCleanException();
    }

    private void givenRoomIsClean() {
        roomRepository = new AlreadyCleanRoomRepository();
    }

    private void thenExpectRoomIsAlreadyCleanException() {
        assertThat(expectedException, instanceOf(RoomIsAlreadyCleanException.class));
    }
}
