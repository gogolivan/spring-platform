package com.github.gogolivan.springplatform.storage.service;

import com.github.gogolivan.springplatform.notification.NotificationGrpc;
import com.github.gogolivan.springplatform.notification.NotificationReply;
import com.github.gogolivan.springplatform.notification.NotificationRequest;
import com.github.gogolivan.springplatform.storage.factory.FileStorageFactory;
import com.github.gogolivan.springplatform.storage.model.FileStorageType;
import com.github.gogolivan.springplatform.storage.resolver.FileStorageResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class FileStorageServiceImpl implements FileStorageService {
    private final FileStorageFactory fileStorageFactory;
    private final NotificationGrpc.NotificationBlockingStub notificationBlockingStub;

    @Autowired
    public FileStorageServiceImpl(FileStorageFactory fileStorageFactory,
                                  NotificationGrpc.NotificationBlockingStub notificationBlockingStub) {
        this.fileStorageFactory = fileStorageFactory;
        this.notificationBlockingStub = notificationBlockingStub;
    }

    @Override
    public InputStream load(FileStorageType type, String path) {
        FileStorageResolver fileStorageResolver = fileStorageFactory.create(type);
        return fileStorageResolver.load(path);
    }

    @Override
    public void store(FileStorageType type, String path, InputStream inputStream) {
        FileStorageResolver fileStorageResolver = fileStorageFactory.create(type);
        fileStorageResolver.store(path, inputStream);
        NotificationReply notificationReply = notificationBlockingStub.sendNotification(NotificationRequest.newBuilder()
                .build());
        log.info("File stored");
    }
}
