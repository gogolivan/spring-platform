package com.github.gogolivan.springplatform.storage.service;

import java.io.InputStream;
import java.util.UUID;

public interface FileService {
    InputStream load(UUID id);
    void save(InputStream inputStream);
}
