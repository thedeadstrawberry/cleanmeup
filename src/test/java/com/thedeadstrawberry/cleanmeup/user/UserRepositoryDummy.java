package com.thedeadstrawberry.cleanmeup.user;

public class UserRepositoryDummy implements UserRepository {

    @Override
    public User findUser(String username) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }
}
