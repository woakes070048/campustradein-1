package me.ifeify.search.symboltable;

/**
 * @author ifeify
 */
public interface SymbolTable<K extends Comparable<K>, V> {
    /**
     * puts a key value pair into the table. If the key already exists, the old value
     * is replace with the new one
     * @param key the key to insert. Cannot be null
     * @param value the value to insert. Cannot be null also
     */
    void put(K key, V value);

    /**
     * Retrieves the value paired with the key
     * @param key the key to search for
     * @return the {@code value} paired with the key
     */
    V get(K key);

    /**
     * Deletes the key from the table. A {@code NullPointerException} will be thrown if the key
     * is null
     * @param key the key to delete
     */
    void delete(K key);

    /**
     * Checks if the key is in the table
     * @param key the key to search for
     * @return {@code true} if the key is in the table. Otherwise, return {@code false}
     */
    boolean contains(K key);

    /**
     * Checks if the table has any entry or not
     * @return {@code true} if there are entries or {@code false} if there are none
     */
    boolean isEmpty();

    /**
     * Returns the number of entries in the table
     * @return the number of key-value pairs in the table
     */
    boolean size();

    /**
     * Returns all the keys in the table
     * @return an interable list of the keys in the table
     * @see Iterable
     */
    Iterable<K> keys();
}
