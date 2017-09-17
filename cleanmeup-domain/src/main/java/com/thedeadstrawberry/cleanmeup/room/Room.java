package com.thedeadstrawberry.cleanmeup.room;

public class Room {
    private boolean isClean;
    private String cleaner;

    public void clean(String username) {
        if(isClean)
            throw new RoomIsAlreadyCleanException();
        isClean = true;
        cleaner = username;
    }

    void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }

    boolean isClean() {
        return isClean;
    }

    String getCleaner() {
        return cleaner;
    }
}
