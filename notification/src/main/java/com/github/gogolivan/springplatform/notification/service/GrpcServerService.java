package com.github.gogolivan.springplatform.notification.service;

import com.github.gogolivan.springplatform.notification.NotificationGrpc;
import com.github.gogolivan.springplatform.notification.NotificationReply;
import com.github.gogolivan.springplatform.notification.NotificationRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GrpcServerService extends NotificationGrpc.NotificationImplBase {
    @Override
    public void sendNotification(NotificationRequest request, StreamObserver<NotificationReply> responseObserver) {
        log.debug("Sending notification {}", request.getMessage());

        NotificationReply notificationReply = NotificationReply.newBuilder()
                .build();

        responseObserver.onNext(notificationReply);
        responseObserver.onCompleted();
    }

    @Override
    public void streamNotification(NotificationRequest request, StreamObserver<NotificationReply> responseObserver) {
        log.debug("Sending streaming notification {}", request.getMessage());

        NotificationReply notificationReply = NotificationReply.newBuilder()
                .build();

        responseObserver.onNext(notificationReply);
        responseObserver.onCompleted();
    }
}
