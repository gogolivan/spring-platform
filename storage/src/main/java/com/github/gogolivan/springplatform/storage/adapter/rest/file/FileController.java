package com.github.gogolivan.springplatform.storage.adapter.rest.file;

import com.github.gogolivan.springplatform.storage.domain.port.api.FileServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {
    private final FileServicePort fileServicePort;

    @Autowired
    public FileController(FileServicePort fileServicePort) {
        this.fileServicePort = fileServicePort;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InputStream> load(@PathVariable UUID id) {
        return ResponseEntity.ok(fileServicePort.load(id).getContent());
    }
}
