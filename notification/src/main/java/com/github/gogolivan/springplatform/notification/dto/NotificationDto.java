package com.github.gogolivan.springplatform.notification.dto;

import java.time.OffsetDateTime;

public record NotificationDto(String id,
                              String username,
                              String title,
                              String message,
                              Boolean isRead,
                              OffsetDateTime createdAt) {
}
