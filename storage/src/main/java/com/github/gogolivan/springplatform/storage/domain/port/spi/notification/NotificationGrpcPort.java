package com.github.gogolivan.springplatform.storage.domain.port.spi.notification;

import com.github.gogolivan.springplatform.storage.domain.model.NotificationDomainModel;

/**
 * Secondary Port for managing notification via GRPC
 */
public interface NotificationGrpcPort {
    NotificationDomainModel sendNotification(NotificationDomainModel notificationDomainModel);
}
