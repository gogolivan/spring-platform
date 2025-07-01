package com.github.gogolivan.springplatform.storage.domain.model;

import lombok.Data;

import java.io.InputStream;
import java.util.UUID;

@Data
public class FileDomainModel {
    private UUID id;
    private String fileName;
    private String path;
    private InputStream content;
    private String contentType;
}
