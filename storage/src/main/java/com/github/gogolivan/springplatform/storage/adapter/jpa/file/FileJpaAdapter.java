package com.github.gogolivan.springplatform.storage.adapter.jpa.file;

import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;
import com.github.gogolivan.springplatform.storage.domain.port.spi.file.FileJpaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FileJpaAdapter implements FileJpaPort {
    private final FileRepository fileRepository;

    @Autowired
    public FileJpaAdapter(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public FileDomainModel findById(UUID id) {
        return null;
    }
}
