package me.ifeify.event.publisher;

import me.ifeify.event.Event;
import me.ifeify.event.listener.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An in-memory event publisher that allows other parts of the application
 * to listen to and unsubsribe from particular events
 * @author ifeify
 */
public class DefaultEventPublisher implements EventPublisher {
    private Map<Event, List<EventListener>> subscribers = new ConcurrentHashMap<>();
    private AtomicInteger numberOfListeners = new AtomicInteger();

    @Override
    public int publish(Event event) {
        int listenersNotified = 0;
        List<EventListener> eventListeners = subscribers.getOrDefault(event, new ArrayList<>());
        for(EventListener eventListener : eventListeners) {
            eventListener.handleEvent(event);
            listenersNotified++;
        }
        return listenersNotified;
    }

    @Override
    public void subscribe(EventListener eventListener, Event event) {
        List<EventListener> eventListeners = subscribers.getOrDefault(event, new ArrayList<>());
        eventListeners.add(eventListener);
        subscribers.put(event, eventListeners);
        numberOfListeners.incrementAndGet();
    }

    @Override
    public void unsubscribe(EventListener eventListener, Event event) {
        if(subscribers.containsKey(event)) {
            List<EventListener> eventListeners = subscribers.get(event);
            if(eventListeners.contains(eventListener)) {
                eventListeners.remove(eventListener);
                numberOfListeners.decrementAndGet();
            }
        }
    }

    @Override
    public int getNumberOfSubscribers() {
        return numberOfListeners.intValue();
    }
}
