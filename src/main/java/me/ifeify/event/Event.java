package me.ifeify.event;

import java.io.Serializable;

/**
 * @author ifeify
 * @date 8/19/16.
 */
public abstract class Event<T> implements Serializable {
    private T model;
    private long timestamp;

    public Event(T model) {
        this.model = model;
        this.timestamp = System.currentTimeMillis();
    }

    public T getModel() {
        return model;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
