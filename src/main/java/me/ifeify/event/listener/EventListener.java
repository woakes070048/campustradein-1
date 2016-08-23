package me.ifeify.event.listener;

import me.ifeify.event.Event;

/**
 * @author ifeify
 */
public interface EventListener {
    /**
     * performs an action in response to the event that occurred
     * @param event event that was triggered
     */
    void handleEvent(Event event);
}
