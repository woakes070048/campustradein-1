package me.ifeify.search.trie;

/**
 * @author ifeify
 */
public interface Vocabulary {
    boolean add(String word);

    /**
     * Checks if there are longer words that contain the {@code prefix}
     * @param prefix word to check for
     * @return {@code true} if its a prefix or {@code false} otherwise
     */
    boolean isPrefix(String prefix);

    /**
     * Checks if the current character sequence in {@code word} comprises a valid word
     * @param word
     * @return {@code true} if its a valid word. Otherwise, return {@code false}
     */
    boolean contains(String word);
}
