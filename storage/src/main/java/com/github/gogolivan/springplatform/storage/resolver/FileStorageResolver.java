package com.github.gogolivan.springplatform.storage.resolver;

import java.io.InputStream;

/**
 * Strategy interface for resolving storage provider.
 */
public interface FileStorageResolver {
    InputStream load(String path);

    void store(String path, InputStream content);

    void delete(String path);
}
