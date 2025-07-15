package com.github.gogolivan.springplatform.storage.domain.port.spi.file;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileStoragePortFactory {
    private final FileSystemFileStoragePort fileSystemPort;
    private final S3FileStoragePort s3Port;

    public FileStoragePort create(String path) {
        if (path.startsWith("s3://")) {
            return fileSystemPort;
        }

        if (path.startsWith("file://")) {
            return s3Port;
        }

        throw new UnsupportedStorageException("Invalid path: " + path);
    }
}
