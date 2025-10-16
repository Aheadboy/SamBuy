package org.sambuy.usecases.user.impl;


import org.sambuy.entities.User;
import org.sambuy.usecases.user.usecase.RegisterUserUseCase;
import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;
import org.sambuy.usecases.user.interfaces.gateways.UserRepository;

import java.util.UUID;

public class RegisterUserUseCaseImpl implements RegisterUserUseCase {
    private final UserRepository repository;
    private final UserOutputBoundary presenter;

    public RegisterUserUseCaseImpl(UserRepository repository, UserOutputBoundary presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public void execute(String username, String email, String phone) {
        // 简单验证（可扩展）
        if (username == null || username.trim().isEmpty()) {
            presenter.presentError("Username cannot be empty");
            return;
        }
        if (email == null || !email.contains("@")) {
            presenter.presentError("Invalid email format");
            return;
        }

        // 创建用户
        String userId = UUID.randomUUID().toString();
        User user = User.builder()
                .userId(userId)
                .username(username)
                .email(email)
                .phone(phone)
                .build();

        // 保存用户
        repository.save(user);
        presenter.presentUser(user);
    }
}