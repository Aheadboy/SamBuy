package org.sambuy.usecases.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sambuy.entities.User;
import org.sambuy.usecases.user.impl.RegisterUserUseCaseImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * //目的是测试useCase.execute这个方法的逻辑
 */
class RegisterUserUseCaseTest {
    private UserRepository repository;
    private UserOutputBoundary presenter;
    private RegisterUserUseCase useCase;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
        presenter = mock(UserOutputBoundary.class);
        useCase = new RegisterUserUseCaseImpl(repository, presenter);
    }

    @Test
    void execute_withValidInput_savesUserAndPresents() {
        useCase.execute("john_doe", "john@example.com", "1234567890");//目的是测试这个方法的逻辑
        verify(repository).save(any(User.class));
        verify(presenter).presentUser(any(User.class));
    }

    @Test
    void execute_withEmptyUsername_presentsError() {
        useCase.execute("", "john@example.com", "1234567890");
        verify(presenter).presentError("Username cannot be empty");
        verifyNoInteractions(repository);
    }

    @Test
    void execute_withInvalidEmail_presentsError() {
        useCase.execute("john_doe", "invalid_email", "1234567890");
        verify(presenter).presentError("Invalid email format");
        verifyNoInteractions(repository);
    }
}