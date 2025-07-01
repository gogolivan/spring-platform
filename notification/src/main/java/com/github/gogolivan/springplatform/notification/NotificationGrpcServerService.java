package com.github.gogolivan.springplatform.notification;

import com.github.gogolivan.springplatform.notification.service.NotificationService;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
public class NotificationGrpcServerService extends NotificationGrpc.NotificationImplBase {

    private final NotificationService notificationService;

    @Autowired
    public NotificationGrpcServerService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void sendNotification(NotificationRequest request, StreamObserver<NotificationReply> responseObserver) {
        log.debug("Notification {}", request.getMessage());

        var notificationReply = NotificationReply.newBuilder()
                .build();

        responseObserver.onNext(notificationReply);
        responseObserver.onCompleted();
    }

    @Override
    public void streamNotification(NotificationRequest request, StreamObserver<NotificationReply> responseObserver) {
        log.debug("Streaming notification {}", request.getMessage());

        var notificationReply = NotificationReply.newBuilder()
                .build();

        responseObserver.onNext(notificationReply);
        responseObserver.onCompleted();
    }

    @Override
    public void batchSendNotifications(BatchNotificationRequest request, StreamObserver<BatchNotificationReply> responseObserver) {
        super.batchSendNotifications(request, responseObserver);
    }
}
