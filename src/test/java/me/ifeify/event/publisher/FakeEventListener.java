package me.ifeify.event.publisher;

import me.ifeify.event.Event;
import me.ifeify.event.listener.EventListener;

/**
 * @author iolowosusi
 */
public class FakeEventListener implements EventListener {
    @Override
    public void handleEvent(Event event) {
        System.out.println("Handling a fake event");
    }
}
