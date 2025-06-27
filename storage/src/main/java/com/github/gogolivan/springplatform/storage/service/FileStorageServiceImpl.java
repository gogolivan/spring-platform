package com.github.gogolivan.springplatform.storage.service;

import com.github.gogolivan.springplatform.storage.factory.FileStorageFactory;
import com.github.gogolivan.springplatform.storage.model.FileStorageType;
import com.github.gogolivan.springplatform.storage.resolver.FileStorageResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    private final FileStorageFactory fileStorageFactory;

    @Autowired
    public FileStorageServiceImpl(FileStorageFactory fileStorageFactory) {
        this.fileStorageFactory = fileStorageFactory;
    }

    @Override
    public InputStream load(FileStorageType type, String path) {
        FileStorageResolver fileStorageResolver = fileStorageFactory.create(type);
        return fileStorageResolver.load(path);
    }
}
