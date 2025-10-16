package org.sambuy.usecases.user.interfaces.gateways;

import org.sambuy.entities.User;

public interface UserRepository {
    void save(User user);
    User findById(String userId);
}