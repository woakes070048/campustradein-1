package me.ifeify.config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;

/**
 * @author ifeify
 */
public class MongoDBModule extends AbstractModule {
    private static final String CONFIG_FILE = System.getProperty("MONGO_CONFIG");

    @Override
    protected void configure() {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("");
        final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
        datastore.ensureIndexes();
    }
}
