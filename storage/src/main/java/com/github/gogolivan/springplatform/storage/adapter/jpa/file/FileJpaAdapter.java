package com.github.gogolivan.springplatform.storage.adapter.jpa.file;

import com.github.gogolivan.springplatform.storage.adapter.jpa.file.repository.FileRepository;
import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;
import com.github.gogolivan.springplatform.storage.domain.port.spi.file.FileJpaPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.github.gogolivan.springplatform.storage.adapter.jpa.file.mapper.FileJpaMapper.FILE_JPA_MAPPER;

@Component
public class FileJpaAdapter implements FileJpaPort {
    private final FileRepository fileRepository;

    @Autowired
    public FileJpaAdapter(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public FileDomainModel findById(UUID id) {
        return fileRepository.findById(id).map(FILE_JPA_MAPPER::toDomainModel).orElseThrow();
    }
}
