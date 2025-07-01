package com.github.gogolivan.springplatform.notification.controller;

import com.github.gogolivan.springplatform.notification.dto.NotificationDto;
import com.github.gogolivan.springplatform.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.OffsetDateTime;

@Controller
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @QueryMapping
    public NotificationDto notification(@Argument String username) {
        log.info("Notification request for user {}", username);
        return new NotificationDto("1", "admin", "title", "message", false, OffsetDateTime.now());
    }
}
