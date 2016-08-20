package me.ifeify.infrastructure;

/**
 * @author ifeify
 * @date 8/19/16.
 */
public interface IdGenerationStrategy {
    String generate(int length);
}
