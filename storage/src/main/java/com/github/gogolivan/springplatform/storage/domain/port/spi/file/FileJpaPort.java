package com.github.gogolivan.springplatform.storage.domain.port.spi.file;

import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;

import java.util.UUID;

/**
 * Secondary Port for managing files at the persistence level.
 */
public interface FileJpaPort {
    /**
     * Finds a file by the given ID.
     *
     * @param id The unique identifier of the file.
     * @return The file corresponding to the given ID.
     */
    FileDomainModel findById(UUID id);
}
