package org.sambuy.usecases.user;

public interface GetUserOrdersUseCase {
    void execute(String userId, UserOutputBoundary presenter);
}