package org.sambuy.usecases.user;

import org.sambuy.entities.User;

public interface UserRepository {
    void save(User user);
    User findById(String userId);
}