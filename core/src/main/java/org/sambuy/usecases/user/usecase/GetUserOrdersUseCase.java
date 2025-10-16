package org.sambuy.usecases.user.usecase;

import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;

public interface GetUserOrdersUseCase {
    void execute(String userId, UserOutputBoundary presenter);
}