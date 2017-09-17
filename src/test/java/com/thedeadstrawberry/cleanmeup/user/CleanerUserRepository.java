package com.thedeadstrawberry.cleanmeup.user;

public class CleanerUserRepository implements UserRepository {
	private User savedUser;

	@Override
	public User findUser(String username) {
		User user = new User();
		user.setUsername(username);
		return user;
	}

	@Override
	public void saveUser(User user) {
		this.savedUser = user;
	}

	public boolean wasUserAwardedPoints() {
		return savedUser.getPoints() > 0;
	}
}
