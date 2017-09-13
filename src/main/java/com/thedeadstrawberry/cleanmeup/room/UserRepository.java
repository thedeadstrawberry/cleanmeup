package com.thedeadstrawberry.cleanmeup.room;

/**
 * Created by carce on 12/09/2017.
 */
public interface UserRepository {
    User findUser(String username);
}
