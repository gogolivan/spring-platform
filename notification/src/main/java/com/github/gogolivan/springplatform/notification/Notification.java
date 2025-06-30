package com.github.gogolivan.springplatform.notification;

import java.time.OffsetDateTime;

public record Notification(String id,
                           String username,
                           String title,
                           String message,
                           Boolean isRead,
                           OffsetDateTime createdAt) {
}
