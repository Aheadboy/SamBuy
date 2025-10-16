package org.sambuy.usecases.user;

public interface UpdateUserUseCase {
    void execute(String userId, String username, String email, String phone, String address, UserOutputBoundary presenter);
}