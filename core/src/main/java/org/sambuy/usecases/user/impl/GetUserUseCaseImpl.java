package org.sambuy.usecases.user.impl;

import org.sambuy.entities.User;
import org.sambuy.usecases.user.GetUserUseCase;
import org.sambuy.usecases.user.UserOutputBoundary;
import org.sambuy.usecases.user.UserRepository;

public class GetUserUseCaseImpl implements GetUserUseCase {
    private final UserRepository repository;
    private final UserOutputBoundary presenter;

    public GetUserUseCaseImpl(UserRepository repository, UserOutputBoundary presenter) {
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public void execute(String userId, UserOutputBoundary presenter) {
        if (userId == null || userId.trim().isEmpty()) {
            presenter.presentError("User ID cannot be empty");
            return;
        }

        User user = repository.findById(userId);
        if (user == null) {
            presenter.presentError("User not found");
            return;
        }

        presenter.presentUser(user);
    }
}