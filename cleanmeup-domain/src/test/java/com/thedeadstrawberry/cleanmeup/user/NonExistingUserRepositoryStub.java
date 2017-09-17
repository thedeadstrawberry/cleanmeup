package com.thedeadstrawberry.cleanmeup.user;

public class NonExistingUserRepositoryStub implements UserRepository {

    @Override
    public User findUser(String username) {
        throw new UserDoesNotExistException();
    }

    @Override
    public void saveUser(User user) {

    }
}
