package com.github.gogolivan.springplatform.storage.domain.port.spi.file;

import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;

public interface FileStoragePort {
    /**
     * Finds a file by the given path.
     *
     * @param path The path of the file.
     * @return The file corresponding to the given path.
     */
    FileDomainModel findByPath(String path);
}
