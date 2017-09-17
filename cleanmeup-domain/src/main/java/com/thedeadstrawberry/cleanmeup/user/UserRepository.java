package com.thedeadstrawberry.cleanmeup.user;

public interface UserRepository {
    User findUser(String username);
    void saveUser(User user);
}
