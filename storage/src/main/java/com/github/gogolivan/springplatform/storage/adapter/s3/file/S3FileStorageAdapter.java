package com.github.gogolivan.springplatform.storage.adapter.s3.file;

import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;
import com.github.gogolivan.springplatform.storage.domain.port.spi.file.S3FileStoragePort;
import org.springframework.stereotype.Component;

@Component
public class S3FileStorageAdapter implements S3FileStoragePort {
    @Override
    public FileDomainModel findByPath(String path) {
        return null;
    }
}
