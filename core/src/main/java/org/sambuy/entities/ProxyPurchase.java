package org.sambuy.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ProxyPurchase {
    private final String requestId;
    private final String userId;
    private final String orderId;
    private String status;
    private LocalDateTime requestedAt;


}
