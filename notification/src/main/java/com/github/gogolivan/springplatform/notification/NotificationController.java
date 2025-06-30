package com.github.gogolivan.springplatform.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.OffsetDateTime;

@Controller
@Slf4j
public class NotificationController {
    @QueryMapping
    public Notification notification(@Argument String username) {
        log.info("Notification request for user {}", username);
        return new Notification("1", "admin", "title", "message", false, OffsetDateTime.now());
    }
}
