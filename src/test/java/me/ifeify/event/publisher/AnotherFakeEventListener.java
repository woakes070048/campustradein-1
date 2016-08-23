package me.ifeify.event.publisher;

import me.ifeify.event.Event;
import me.ifeify.event.listener.EventListener;

/**
 * @author iolowosusi
 */
public class AnotherFakeEventListener implements EventListener {
    @Override
    public void handleEvent(Event event) {
        long timestamp = event.getTimestamp();
        System.out.println("Handling another fake event");
    }
}
