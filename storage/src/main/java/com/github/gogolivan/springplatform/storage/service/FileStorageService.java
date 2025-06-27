package com.github.gogolivan.springplatform.storage.service;

import com.github.gogolivan.springplatform.storage.model.FileStorageType;

import java.io.InputStream;

public interface FileStorageService {
    InputStream load(FileStorageType type, String path);
}
