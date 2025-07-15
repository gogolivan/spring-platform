package com.github.gogolivan.springplatform.storage.adapter.jpa.file.repository;

import com.github.gogolivan.springplatform.storage.adapter.jpa.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, UUID> {
}
