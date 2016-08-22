package me.ifeify.config;

import com.google.inject.throwingproviders.CheckedProvider;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * @author ifeify
 */
public interface DatabaseConnectionProvider<T> extends CheckedProvider<T> {
    T get() throws IOException;
}
