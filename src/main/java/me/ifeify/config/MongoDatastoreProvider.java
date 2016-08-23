package me.ifeify.config;

import com.mongodb.MongoClient;
import me.ifeify.config.annotation.MongoDB;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.MapperOptions;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

/**
 * @author ifeify
 */
public class MongoDatastoreProvider implements Provider<Datastore> {
    private final Provider<MongoClient> mongoClientProvider;
    private final String datastoreName;

    @Inject
    public MongoDatastoreProvider(@MongoDB Provider<MongoClient> mongoClientProvider,
                                  @Named("Mongo Datastore") String datastoreName) {
        this.mongoClientProvider = mongoClientProvider;
        this.datastoreName = datastoreName;
    }

    @Override
    public Datastore get() {
        MongoClient mongoClient = mongoClientProvider.get();

        final Morphia morphia = new Morphia();
        // TODO: specify packages rather than scanning the entire project
        morphia.mapPackage("me.ifeify");
        MapperOptions mapperOptions = morphia.getMapper().getOptions();
        mapperOptions.setStoreEmpties(true);
        mapperOptions.setStoreNulls(true);

        System.out.println(morphia.getMapper().getOptions());

        final Datastore datastore = morphia.createDatastore(mongoClient, datastoreName);
        datastore.ensureIndexes();
        return datastore;
    }
}
