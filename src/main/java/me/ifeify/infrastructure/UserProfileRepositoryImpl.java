package me.ifeify.infrastructure;

import me.ifeify.infrastructure.entity.UserProfile;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import javax.inject.Inject;

/**
 * @author ifeify
 */
public class UserProfileRepositoryImpl implements UserProfileRepository {
    private static final int ID_LENGTH = 30;

    private IdGenerationStrategy idGenerationStrategy;
    @Inject
    private Datastore datastore;

    @Inject
    public UserProfileRepositoryImpl(Datastore datastore) {
        this.datastore = datastore;
    }

    @Override
    public UserProfile findByUsername(String username) {
        return null;
    }

    @Override
    public void setIdGenerationStrategy(IdGenerationStrategy idGenerationStrategy) {
        this.idGenerationStrategy = idGenerationStrategy;
    }

    @Override
    public IdGenerationStrategy getIdGenerationStrategy() {
        return this.idGenerationStrategy;
    }

    @Override
    public String nextAvailableId() {
        String id = idGenerationStrategy.generate(ID_LENGTH);
        boolean found = false;
        while(!found) {
            Query<UserProfile> query = datastore.createQuery(UserProfile.class)
                    .field("userId").equal(id);
            if(query.get() == null) {
                // id is available
                break;
            }
            // try another one
            id = idGenerationStrategy.generate(ID_LENGTH);
        }
        return id;
    }

    @Override
    public UserProfile findById(String id) {
        return null;
    }
}
