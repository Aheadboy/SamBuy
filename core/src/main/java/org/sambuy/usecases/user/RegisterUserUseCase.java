package org.sambuy.usecases.user;

public interface RegisterUserUseCase {
    void execute(String username, String email, String phone);
}