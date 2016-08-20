package me.ifeify.event.publisher;

import me.ifeify.event.Event;
import me.ifeify.event.listener.EventListener;

/**
 * @author ifeify
 * @date 8/19/16.
 */
public interface EventPublisher {
    /**
     * publishes the specified event
     * @param event the event to be published
     */
    void publish(Event event);

    /**
     * Allows listeners to subscribe to an event and get notified when it occurs
     * @param event the event client wants to listen to
     */
    void subscribe(EventListener eventListener, Event event);

    /**
     * Allows listeners to unsubscribe from an event
     * @param event the event to unsubscribe from
     */
    void unsubscribe(EventListener eventListener, Event event);

}
