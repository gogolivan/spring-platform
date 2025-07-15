package com.github.gogolivan.springplatform.storage.domain.port.spi.file;

public class UnsupportedStorageException extends RuntimeException {
    public UnsupportedStorageException(String message) {
        super(message);
    }
}
