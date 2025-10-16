package org.sambuy.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Notification {
    private final String notificationId;
    private final String userId;
    private String message;
    private LocalDateTime sentAt;
    private boolean read;

}
