package com.github.gogolivan.springplatform.storage.factory;

import com.github.gogolivan.springplatform.storage.model.FileStorageType;
import com.github.gogolivan.springplatform.storage.resolver.FileStorageResolver;
import org.springframework.stereotype.Component;

@Component
public class FileStorageFactory {
    public FileStorageResolver create(FileStorageType type) {
        return null;
    }
}
