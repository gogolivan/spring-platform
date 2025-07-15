package com.github.gogolivan.springplatform.storage.adapter.jpa.file.mapper;

import com.github.gogolivan.springplatform.storage.adapter.jpa.file.entity.FileEntity;
import com.github.gogolivan.springplatform.storage.domain.model.FileDomainModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
public interface FileJpaMapper {
    FileJpaMapper FILE_JPA_MAPPER = getMapper(FileJpaMapper.class);

    @Mapping(target = "content", ignore = true)
    FileDomainModel toDomainModel(FileEntity fileEntity);
}
