package com.github.gogolivan.springplatform.storage.adapter.filesystem.file;

import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;
import com.github.gogolivan.springplatform.storage.domain.port.spi.file.FileSystemFileStoragePort;
import org.springframework.stereotype.Component;

@Component
public class FileSystemFileStorageAdapter implements FileSystemFileStoragePort {
    @Override
    public FileDomainModel findByPath(String path) {
        return null;
    }
}
