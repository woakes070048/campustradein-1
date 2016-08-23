package me.ifeify.event.publisher;

import me.ifeify.event.Event;
import me.ifeify.event.listener.EventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ifeify
 * @date 8/19/16.
 */
public class InMemoryEventPublisher implements EventPublisher {
    private Map<Event, List<EventListener>> subscribers = new ConcurrentHashMap<>();

    @Override
    public void publish(Event event) {
        List<EventListener> eventListeners = subscribers.getOrDefault(event, new ArrayList<>());
        for(EventListener eventListener : eventListeners) {
            eventListener.handleEvent(event);
        }
    }

    @Override
    public void subscribe(EventListener eventListener, Event event) {
        List<EventListener> eventListeners = subscribers.getOrDefault(event, new ArrayList<>());
        eventListeners.add(eventListener);
        subscribers.put(event, eventListeners);
    }

    @Override
    public void unsubscribe(EventListener eventListener, Event event) {
        if(subscribers.containsKey(event)) {
            List<EventListener> eventListeners = subscribers.get(event);
            if(eventListeners.contains(eventListener)) {
                eventListeners.remove(eventListener);
            }
        }
    }
}
