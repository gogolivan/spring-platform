package com.github.gogolivan.springplatform.storage.adapter.grpc.notification;

import com.github.gogolivan.springplatform.notification.NotificationGrpc;
import com.github.gogolivan.springplatform.notification.NotificationReply;
import com.github.gogolivan.springplatform.notification.NotificationRequest;
import com.github.gogolivan.springplatform.storage.domain.model.NotificationDomainModel;
import com.github.gogolivan.springplatform.storage.domain.port.spi.notification.NotificationGrpcPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationGrpcAdapter implements NotificationGrpcPort {
    private final NotificationGrpc.NotificationBlockingStub notificationBlockingStub;

    @Autowired
    public NotificationGrpcAdapter(NotificationGrpc.NotificationBlockingStub notificationBlockingStub) {
        this.notificationBlockingStub = notificationBlockingStub;
    }

    @Override
    public NotificationDomainModel sendNotification(NotificationDomainModel notificationDomainModel) {

        NotificationReply notificationReply = notificationBlockingStub.sendNotification(NotificationRequest.newBuilder()
                .setTitle(notificationDomainModel.getTitle())
                .setMessage(notificationDomainModel.getMessage())
                .build());

        notificationDomainModel.setId(notificationReply.getId());

        return notificationDomainModel;
    }
}
