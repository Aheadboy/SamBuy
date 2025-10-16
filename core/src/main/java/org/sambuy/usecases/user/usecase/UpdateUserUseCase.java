package org.sambuy.usecases.user.usecase;

import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;

public interface UpdateUserUseCase {
    void execute(String userId, String username, String email, String phone, String address, UserOutputBoundary presenter);
}