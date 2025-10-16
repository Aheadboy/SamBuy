package org.sambuy.usecases.user;

public interface DeleteUserUseCase {
    void execute(String userId, UserOutputBoundary presenter);
}