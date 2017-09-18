package com.thedeadstrawberry.cleanmeup.room;

import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class RoomCollectionAdapterTest {

	private RuntimeException expectedException;
	private RoomCollectionAdapter roomCollectionAdapter;
	private long roomId;

	@Test
	public void testRoomDoesNotExist() {
		givenRoomDoesNotExistInCollection();
		whenTryToFindRoom();
		thenExpectRoomDoesNotExistException();
	}

	private void givenRoomDoesNotExistInCollection() {
		roomId = 1;
	}

	private void whenTryToFindRoom() {
		try {
			roomCollectionAdapter = new RoomCollectionAdapter();
		} catch (RuntimeException e) {
			expectedException = e;
		}
	}

	private void thenExpectRoomDoesNotExistException() {
		assertThat("RoomDoesNotExistException should have been thrown",
				  expectedException, instanceOf(RoomDoesNotExistException.class));
	}

}
