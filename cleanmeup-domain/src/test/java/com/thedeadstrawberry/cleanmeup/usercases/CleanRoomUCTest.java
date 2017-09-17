package com.thedeadstrawberry.cleanmeup.usercases;

import com.thedeadstrawberry.cleanmeup.room.*;
import com.thedeadstrawberry.cleanmeup.user.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class CleanRoomUCTest extends UserDoesNotExistException {

    private CleanRoomUC cleanRoomUC;
    private RuntimeException expectedException;
    private RoomRepository roomRepository;
    private UserRepository userRepository;
    private int roomId;
    private String username;

    @Before
    public void setUp() {
        roomRepository = new RoomRepositoryDummy();
        userRepository = new UserRepositoryDummy();
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
        roomRepository = new NonExistingRoomRepositoryStub();
    }

    private void whenTryToCleanRoom() {
        try {
            whenCleanRoom();
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
        userRepository = new NonExistingUserRepositoryStub();
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
        roomRepository = new AlreadyCleanRoomRepositoryStub();
    }

    private void thenExpectRoomIsAlreadyCleanException() {
        assertThat(expectedException, instanceOf(RoomIsAlreadyCleanException.class));
    }

    @Test
    public void testCleanRoom() {
        givenRoomIsNotClean();
        givenUserCleansRoom();
        whenCleanRoom();
        thenRoomShouldBeClean();
    }

    private void givenRoomIsNotClean() {
        roomRepository = new DirtyRoomRepositorySpy();
    }

    private void whenCleanRoom() {
        cleanRoomUC = new CleanRoomUC(roomRepository, userRepository, roomId, username);
        cleanRoomUC.clean();
    }

    private void thenRoomShouldBeClean() {
        assertThat("Room should have been cleaned", getDirtyRoomRepository().isSavedRoomClean(), is(true));
    }

    private DirtyRoomRepositorySpy getDirtyRoomRepository() {
        return (DirtyRoomRepositorySpy)roomRepository;
    }

    @Test
    public void testUserCleansRoom() {
        givenRoomIsNotClean();
        givenUserCleansRoom();
        whenCleanRoom();
        thenRoomCleanerShouldBeUser();
    }

    private void givenUserCleansRoom() {
        userRepository = new CleanerUserRepository();
    }

    private void thenRoomCleanerShouldBeUser() {
        assertThat("Room's cleaner should be user", getDirtyRoomRepository().getRoomCleaner(), is(username));
    }

    @Test
    public void testAwardUserPointsForCleaning() {
        givenRoomIsNotClean();
        givenUserCleansRoom();
        whenCleanRoom();
        thenUserShouldBeAwardedPointsForCleaning();
    }

    private void thenUserShouldBeAwardedPointsForCleaning() {
        CleanerUserRepository cleanerUserRepository = (CleanerUserRepository)userRepository;
        assertThat("User wasn't awarded points", cleanerUserRepository.wasUserAwardedPoints(), is(true));
    }
}
