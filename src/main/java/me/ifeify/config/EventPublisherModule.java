package me.ifeify.config;

import com.google.inject.AbstractModule;
import me.ifeify.config.annotation.InAppPublisher;
import me.ifeify.event.publisher.EventPublisher;
import me.ifeify.event.publisher.DefaultEventPublisher;

/**
 * @author ifeify
 */
public class EventPublisherModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(EventPublisher.class).to(DefaultEventPublisher.class);
    }
}
