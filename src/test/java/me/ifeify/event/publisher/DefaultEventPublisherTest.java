package me.ifeify.event.publisher;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.ifeify.config.EventPublisherModule;
import me.ifeify.event.listener.EventListener;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ifeify
 */
public class DefaultEventPublisherTest {
    private EventPublisher eventPublisher;

    public DefaultEventPublisherTest() {
        Injector injector = Guice.createInjector(new EventPublisherModule());
        eventPublisher = injector.getInstance(EventPublisher.class);
    }

    @Test
    public void trySubscribeAndUnsubscribe() {
        EventListener eventListener = new FakeEventListener();
        FakeEvent fakeEvent = new FakeEvent();
        eventPublisher.subscribe(eventListener, fakeEvent);
        assertEquals(1, eventPublisher.getNumberOfSubscribers());

        eventPublisher.unsubscribe(eventListener, fakeEvent);
        assertEquals(0, eventPublisher.getNumberOfSubscribers());
    }

    @Test
    public void notifyListenersListeningToSameEvent() {
        FakeEvent fakeEvent = new FakeEvent();
        EventListener fakeEventListener = new FakeEventListener();
        EventListener anotherFakeEventListener = new AnotherFakeEventListener();

        eventPublisher.subscribe(fakeEventListener, fakeEvent);
        eventPublisher.subscribe(anotherFakeEventListener, fakeEvent);

        int listenersNotified = eventPublisher.publish(fakeEvent);
        assertEquals(2, listenersNotified);
    }
}
