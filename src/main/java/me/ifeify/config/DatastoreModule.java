package me.ifeify.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.mongodb.morphia.Datastore;

/**
 * @author ifeify
 */
public class DatastoreModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class)
                .annotatedWith(Names.named("Mongo Datastore"))
                .toInstance("campustradein");

        bind(Datastore.class)
                .toProvider(MongoDatastoreProvider.class);
    }
}
