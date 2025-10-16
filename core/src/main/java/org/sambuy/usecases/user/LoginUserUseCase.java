package org.sambuy.usecases.user;


public interface LoginUserUseCase {
    void execute(String email, String password, UserOutputBoundary presenter);
}