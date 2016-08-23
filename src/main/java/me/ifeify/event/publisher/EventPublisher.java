package me.ifeify.event.publisher;

import me.ifeify.event.Event;
import me.ifeify.event.listener.EventListener;

/**
 * @author ifeify
 */
public interface EventPublisher {
    /**
     * Notifies all event listeners that the {@code event} just occurred
     * @param event the event to be published
     * @return the number of event listeners notified
     */
    int publish(Event event);

    /**
     * Allows listeners to subscribe to an event and get notified when it occurs
     * @param eventListener observer interested in the event
     * @param event the event client wants to listen to
     */
    void subscribe(EventListener eventListener, Event event);

    /**
     * Allows listeners to unsubscribe from an event
     * @param eventListener observer wanting to unsubscribe from the event
     * @param event the event to unsubscribe from
     */
    void unsubscribe(EventListener eventListener, Event event);

    /**
     * Returns the current number of event listeners
     * @return the event subscription count
     */
    int getNumberOfSubscribers();

}
