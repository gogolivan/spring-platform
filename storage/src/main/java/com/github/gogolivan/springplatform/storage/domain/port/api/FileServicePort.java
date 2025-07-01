package com.github.gogolivan.springplatform.storage.domain.port.api;

import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;

import java.util.UUID;

/**
 * Primary port for managing files
 */
public interface FileServicePort {
    FileDomainModel load(UUID id);
}
