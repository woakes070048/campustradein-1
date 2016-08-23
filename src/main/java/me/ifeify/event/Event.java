package me.ifeify.event;

import java.io.Serializable;

/**
 * @author ifeify
 */
public abstract class Event implements Serializable {
    private long timestamp;

    public Event() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Returns the time the event was generated in milliseconds
     * @return event timestamp
     */
    public long getTimestamp() {
        return timestamp;
    }
}
