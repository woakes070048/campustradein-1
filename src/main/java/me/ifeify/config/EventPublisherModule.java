package me.ifeify.config;

import com.google.inject.AbstractModule;
import me.ifeify.event.publisher.EventPublisher;
import me.ifeify.event.publisher.InMemoryEventPublisher;

/**
 * @author ifeify
 * @date 8/19/16.
 */
public class EventPublisherModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EventPublisher.class).to(InMemoryEventPublisher.class);
    }
}
