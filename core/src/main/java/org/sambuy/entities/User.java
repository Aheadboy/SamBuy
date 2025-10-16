package org.sambuy.entities;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private final String userId;
    private String username;
    private String email;
    private String phone;

}
