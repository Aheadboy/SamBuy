package org.sambuy.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Cart {
    private final String userId = "";
    private List<CartItem> items;
}
