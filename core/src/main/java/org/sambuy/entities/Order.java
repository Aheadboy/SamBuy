package org.sambuy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class Order {
    private final String orderId;
    private final String userId;
    private List<CartItem> items;
    private double totalAmount;
    private String status;
    private LocalDateTime createdAt;

}
