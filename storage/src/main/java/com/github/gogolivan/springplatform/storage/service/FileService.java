package com.github.gogolivan.springplatform.storage.service;

import java.io.InputStream;

public interface FileService {
    InputStream load(String path);
    void save(String path, InputStream inputStream);
}
