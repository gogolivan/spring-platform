package com.github.gogolivan.springplatform.storage.adapter.jpa.file.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "FILES")
@Getter
@Setter
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "FILE_NAME")
    private String fileName;

    @Column(name = "PATH")
    private String path;

    @Column(name = "CONTENT_TYPE")
    private String contentType;
}
