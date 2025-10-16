package org.sambuy.usecases.user;

public interface GetUserUseCase {
    void execute(String userId, UserOutputBoundary presenter);
}