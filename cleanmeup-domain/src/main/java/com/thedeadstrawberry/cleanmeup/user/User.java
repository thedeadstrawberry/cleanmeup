package com.thedeadstrawberry.cleanmeup.user;

public class User {
	private String username;
	private int points;

	public User() {
		points = 0;
	}

	void setUsername(String username) {
		this.username = username;
	}

	public void awardPoints() {
		points++;
	}

	public int getPoints() {
		return points;
	}
}
