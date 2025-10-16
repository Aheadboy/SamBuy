package org.sambuy.usecases.user.usecase;

import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;

public interface GetUserUseCase {
    void execute(String userId, UserOutputBoundary presenter);
}