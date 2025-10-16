package org.sambuy.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CartItem {
    private final String cartId;
    private final String userId;
    private final String productId;
    private int quantity;


}
