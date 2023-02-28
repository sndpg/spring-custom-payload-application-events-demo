package io.github.sndpg.events;

public class MyPayload {
    private final long id;

    public MyPayload(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
