package com.github.gogolivan.springplatform.storage.factory;

import com.github.gogolivan.springplatform.storage.exception.UnsupportedStorageException;
import com.github.gogolivan.springplatform.storage.resolver.FileSystemStorageResolver;
import com.github.gogolivan.springplatform.storage.resolver.S3StorageResolver;
import com.github.gogolivan.springplatform.storage.resolver.StorageResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StorageFactory {
    private final FileSystemStorageResolver fileSystemStorageResolver;
    private final S3StorageResolver s3StorageResolver;

    public StorageResolver create(String path) {
        if (path.startsWith("s3://")) {
            return s3StorageResolver;
        }

        if (path.startsWith("file://")) {
            return fileSystemStorageResolver;
        }

        throw new UnsupportedStorageException("Invalid path: " + path);
    }
}
