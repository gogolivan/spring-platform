package com.github.gogolivan.springplatform.storage.resolver;

import java.io.InputStream;

/**
 * Strategy interface for resolving storage provider.
 */
public interface FileStorageResolver {
    InputStream load(String path);

    void save(String path, InputStream content);

    void delete(String path);
}
