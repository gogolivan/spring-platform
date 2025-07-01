package com.github.gogolivan.springplatform.storage.repository;

import com.github.gogolivan.springplatform.storage.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FileRepository extends JpaRepository<File, UUID> {
}
