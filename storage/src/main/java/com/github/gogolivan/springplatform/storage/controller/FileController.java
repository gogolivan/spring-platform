package com.github.gogolivan.springplatform.storage.controller;

import com.github.gogolivan.springplatform.storage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InputStream> load(@PathVariable UUID id) {
        return ResponseEntity.ok(fileService.load(id));
    }
}
