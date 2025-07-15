package com.github.gogolivan.springplatform.storage.application.service;

import com.github.gogolivan.springplatform.storage.domain.port.spi.file.FileStoragePortFactory;
import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;
import com.github.gogolivan.springplatform.storage.domain.port.api.FileServicePort;
import com.github.gogolivan.springplatform.storage.domain.port.spi.file.FileJpaPort;
import com.github.gogolivan.springplatform.storage.domain.port.spi.file.FileStoragePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileApplicationService implements FileServicePort {
    private final FileJpaPort fileJpaPort;
    private final FileStoragePortFactory fileStoragePortFactory;

    @Override
    public FileDomainModel load(UUID id) {
        FileDomainModel fileDomainModel = fileJpaPort.findById(id);
        String path = fileDomainModel.getPath();

        FileStoragePort fileStoragePort = fileStoragePortFactory.create(path);

        return fileStoragePort.findByPath(path);
    }
}
