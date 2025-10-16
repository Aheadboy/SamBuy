package org.sambuy.usecases.user.usecase;

public interface RegisterUserUseCase {
    void execute(String username, String email, String phone);
}