package me.ifeify;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.ifeify.config.EventPublisherModule;
import me.ifeify.event.publisher.EventPublisher;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author ifeify
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        Injector injector = Guice.createInjector(new EventPublisherModule());
        EventPublisher eventPublisher = injector.getInstance(EventPublisher.class);

        // read mongo config file
        Yaml yaml = new Yaml();
        Map<String, Map<String, String>> servers =
                (Map<String, Map<String, String>>)yaml.load(
                        new FileInputStream(System.getProperty("MONGO_CONFIG")));


        for(Map.Entry<String, Map<String, String>> entry : servers.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }
}
