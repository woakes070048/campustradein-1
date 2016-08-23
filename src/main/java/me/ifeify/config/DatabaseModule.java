package me.ifeify.config;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.throwingproviders.ThrowingProviderBinder;
import com.mongodb.MongoClient;
import me.ifeify.config.annotation.MongoDB;


/**
 * @author ifeify
 */
public class DatabaseModule extends AbstractModule {
    @Override
    protected void configure() {
        ThrowingProviderBinder.create(binder())
                .bind(DatabaseConnectionProvider.class, MongoClient.class)
                .annotatedWith(MongoDB.class)
                .to(MongoConnectionProvider.class)
                .in(Singleton.class);
    }
}
