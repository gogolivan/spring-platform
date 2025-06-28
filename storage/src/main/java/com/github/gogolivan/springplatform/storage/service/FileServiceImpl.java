package com.github.gogolivan.springplatform.storage.service;

import com.github.gogolivan.springplatform.notification.NotificationGrpc;
import com.github.gogolivan.springplatform.notification.NotificationReply;
import com.github.gogolivan.springplatform.notification.NotificationRequest;
import com.github.gogolivan.springplatform.storage.factory.StorageFactory;
import com.github.gogolivan.springplatform.storage.resolver.StorageResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FileServiceImpl implements FileService {
    private final StorageFactory storageFactory;
    private final NotificationGrpc.NotificationBlockingStub notificationBlockingStub;

    @Override
    public InputStream load(String path) {
        StorageResolver storageResolver = storageFactory.create(path);
        return storageResolver.load(path);
    }

    @Override
    public void save(String path, InputStream inputStream) {
        StorageResolver storageResolver = storageFactory.create(path);
        storageResolver.store(path, inputStream);
        NotificationReply notificationReply = notificationBlockingStub.sendNotification(NotificationRequest.newBuilder()
                .build());
        log.info("File {} saved", path);
    }
}
