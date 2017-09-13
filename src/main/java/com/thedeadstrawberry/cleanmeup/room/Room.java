package com.thedeadstrawberry.cleanmeup.room;

public class Room {
    private boolean isClean;

    public void clean() {
        if(isClean)
            throw new RoomIsAlreadyCleanException();
    }

    public void setIsClean(boolean isClean) {
        this.isClean = isClean;
    }
}
