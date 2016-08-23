package me.ifeify.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mongodb.MongoClient;
import me.ifeify.config.annotation.MongoDB;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Simple test to make sure Guice configures the mongodb connection properly
 * @author ifeify
 */
@Ignore
public class DatabaseModuleTest {

    @Test
    public void verifyMongoClientIsCreated() throws IOException {
        System.setProperty("MONGO_CONFIG_FILE", "etc/mongo_test.yml");
        Injector injector = Guice.createInjector(new DatabaseModule());
        DatabaseConnectionProvider<MongoClient> mongoClientProvider = (DatabaseConnectionProvider<MongoClient>)
                                injector.getProvider(DatabaseConnectionProvider.class);
        MongoClient mongoClient = (MongoClient)mongoClientProvider.get();
        assertEquals(1, mongoClient.getServerAddressList().size());
    }
}
