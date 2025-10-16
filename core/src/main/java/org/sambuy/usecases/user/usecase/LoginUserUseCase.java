package org.sambuy.usecases.user.usecase;


import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;

public interface LoginUserUseCase {
    void execute(String email, String password, UserOutputBoundary presenter);
}