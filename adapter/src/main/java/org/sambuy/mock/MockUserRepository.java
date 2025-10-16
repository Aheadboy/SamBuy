package org.sambuy.mock;

import org.sambuy.entities.User;
import org.sambuy.usecases.user.UserRepository;

import java.util.HashMap;
import java.util.Map;

public class MockUserRepository implements UserRepository {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getUserId(), user);
        // 模拟服务器延迟（可选）
        // try { Thread.sleep(200); } catch (InterruptedException e) {}
    }

    @Override
    public User findById(String userId) {
        return users.get(userId);
    }
}