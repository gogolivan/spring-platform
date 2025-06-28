package com.github.gogolivan.springplatform.storage.resolver;

import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class S3StorageResolver implements StorageResolver {
    @Override
    public InputStream load(String path) {
        return null;
    }

    @Override
    public void store(String path, InputStream content) {

    }

    @Override
    public void delete(String path) {

    }
}
