package me.ifeify.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.mongodb.MongoClient;
import me.ifeify.config.annotation.MongoDB;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;


/**
 * @author ifeify
 */
@Ignore
public class DatabaseModuleTest {
    @MongoDB
    DatabaseConnectionProvider<MongoClient> mongoClientProvider;

    /**
     * simple test to make sure Guice configures the client properly
     */
    @Test
    public void verifyMongoClientIsCreated() throws IOException {
        System.setProperty("MONGO_CONFIG_FILE", "etc/mongo.yml");
        Injector injector = Guice.createInjector(new DatabaseModule());
        mongoClientProvider = (DatabaseConnectionProvider<MongoClient>)
                                injector.getProvider(DatabaseConnectionProvider.class);
        MongoClient mongoClient = (MongoClient)mongoClientProvider.get();
        System.out.println(mongoClient.getServerAddressList());
    }
}
