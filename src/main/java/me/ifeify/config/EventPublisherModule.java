package me.ifeify.config;

import com.google.inject.AbstractModule;
import me.ifeify.event.publisher.DefaultEventPublisher;
import me.ifeify.event.publisher.EventPublisher;

/**
 * @author ifeify
 */
public class EventPublisherModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EventPublisher.class).to(DefaultEventPublisher.class);
    }
}
