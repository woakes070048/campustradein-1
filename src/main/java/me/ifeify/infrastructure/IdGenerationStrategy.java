package me.ifeify.infrastructure;

/**
 * @author ifeify
 */
public interface IdGenerationStrategy {
    String generate(int length);
}
