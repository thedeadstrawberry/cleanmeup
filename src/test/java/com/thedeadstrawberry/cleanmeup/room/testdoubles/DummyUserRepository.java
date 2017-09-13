package com.thedeadstrawberry.cleanmeup.room.testdoubles;

import com.thedeadstrawberry.cleanmeup.room.User;
import com.thedeadstrawberry.cleanmeup.room.UserRepository;

/**
 * Created by carce on 12/09/2017.
 */
public class DummyUserRepository implements UserRepository {
    public User findUser(String username) {

        return null;
    }
}
