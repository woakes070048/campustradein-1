package me.ifeify.event.publisher;

import me.ifeify.event.Event;
import me.ifeify.event.listener.EventListener;

/**
 * @author ifeify
 * @date 8/19/16.
 */
public class RabbitMQEventPublisher implements EventPublisher {
    @Override
    public void publish(Event event) {

    }

    @Override
    public void subscribe(EventListener eventListener, Event event) {

    }

    @Override
    public void unsubscribe(EventListener eventListener, Event event) {

    }
}
