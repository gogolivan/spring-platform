package com.github.gogolivan.springplatform.storage.controller;

import com.github.gogolivan.springplatform.storage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@RestController
@RequestMapping("/file")
public class FileController {
    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public ResponseEntity<InputStream> load(@RequestParam String path) {
        return ResponseEntity.ok(fileService.load(path));
    }
}
