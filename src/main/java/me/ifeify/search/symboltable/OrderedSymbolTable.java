package me.ifeify.search.symboltable;

/**
 * @author ifeify
 */
public interface OrderedSymbolTable<K extends Comparable<K>, V> extends SymbolTable {
    /**
     * Retrieves the smallest key in the table
     * @return smallest key in the table
     */
    K min();

    /**
     * Retrieves the largest key in the table
     * @return largest key in the table
     */
    K max();

    /**
     * Retrieves the largest key less than or equal to {@code key}
     * @param key the comparison key
     * @return largest key less than or equal to {@code key}
     */
    K floor(K key);

    /**
     * Retrieves the smallest key greater than or equal to {@code key}
     * @param key the comparison key
     * @return smallest key greater than or equal to {@code key}
     */
    K ceiling(K key);

    /**
     * Retreives the number of keys less than {@code key}
     * @param key
     * @return the number of keys less than {@code key}
     */
    int rank(K key);

    /**
     * Retrives the key of rank {@code k}
      * @param k the rank
     * @return the key of rank {@code k}
     * @see #rank(Comparable)
     */
    K select(int k);

    /**
     * Removes the smallest key
     */
    void deleteMin();

    /**
     * Removes the largest key
     */
    void deleteMax();

    /**
     * Retrieves the number of keys between {@code lo} and {@code hi}
     * @param lo the smallest key
     * @param hi the largest key
     * @return the number of keys in [lo..hi] in sorted order
     */
    int size(K lo, K hi);

    /**
     * Retrieves keys in sorted order from {@code lo} to {@code hi}
     * @param lo the smallest key
     * @param hi the largest key
     * @return an iterable list of sorted keys in [lo..hi]
     */
    Iterable<K> keys(K lo, K hi);
}
