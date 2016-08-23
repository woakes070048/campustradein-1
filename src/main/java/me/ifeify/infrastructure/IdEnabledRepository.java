package me.ifeify.infrastructure;

/**
 * @author ifeify
 */
public interface IdEnabledRepository<T> {

    void setIdGenerationStrategy(IdGenerationStrategy idGenerationStrategy);

    IdGenerationStrategy getIdGenerationStrategy();

    /**
     * Returns a unique identifier for an item
     * @return a unique unused id
     */
    String nextAvailableId();

    T findById(String id);
}
