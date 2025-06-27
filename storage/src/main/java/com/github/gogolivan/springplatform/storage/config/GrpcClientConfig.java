package com.github.gogolivan.springplatform.storage.config;

import com.github.gogolivan.springplatform.notification.NotificationGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcClientConfig {

    @Bean
    NotificationGrpc.NotificationBlockingStub notificationBlockingStub(GrpcChannelFactory channels) {
        return NotificationGrpc.newBlockingStub(channels.createChannel("notification"));
    }
}
