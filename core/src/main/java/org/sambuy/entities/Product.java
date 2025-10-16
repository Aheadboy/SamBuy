package org.sambuy.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private final String productId;
    private String name;
    private double price;
    private String category;
    private String description;
    private String weight;//重量，选择重量比较重的买家作为收货地址，如果重量相似，则以拼主为收货地址

}
