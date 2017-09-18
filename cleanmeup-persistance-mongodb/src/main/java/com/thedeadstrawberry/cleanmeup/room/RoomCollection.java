package com.thedeadstrawberry.cleanmeup.room;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "room")
public class RoomCollection {

	@Id
	private long id;

	private boolean isClean;

	private String cleaner;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isClean() {
		return isClean;
	}

	public void setClean(boolean clean) {
		isClean = clean;
	}

	public String getCleaner() {
		return cleaner;
	}

	public void setCleaner(String cleaner) {
		this.cleaner = cleaner;
	}
}
