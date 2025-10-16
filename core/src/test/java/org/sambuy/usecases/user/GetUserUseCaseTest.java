package org.sambuy.usecases.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sambuy.entities.User;
import org.sambuy.usecases.user.impl.GetUserUseCaseImpl;
import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;
import org.sambuy.usecases.user.interfaces.gateways.UserRepository;
import org.sambuy.usecases.user.usecase.GetUserUseCase;

import static org.mockito.Mockito.*;

public class GetUserUseCaseTest {
    private UserRepository repository;
    private UserOutputBoundary presenter;
    private GetUserUseCase useCase;

    @BeforeEach
    void setUp() {
        repository = mock(UserRepository.class);
        presenter = mock(UserOutputBoundary.class);
        useCase = new GetUserUseCaseImpl(repository, presenter);
    }

    @Test
    void execute_withValidUserId_presentsUser() {
        User user = User.builder()
                .userId("user1")
                .username("john_doe")
                .email("john@example.com")
                .phone("1234567890")
                .build();
        when(repository.findById("user1")).thenReturn(user);

        useCase.execute("user1", presenter);
        verify(presenter).presentUser(user);
    }

    @Test
    void execute_withEmptyUserId_presentsError() {
        useCase.execute("", presenter);
        verify(presenter).presentError("User ID cannot be empty");
        verifyNoInteractions(repository);
    }

    @Test
    void execute_withNonExistentUserId_presentsError() {
        when(repository.findById("user1")).thenReturn(null);
        useCase.execute("user1", presenter);
        verify(presenter).presentError("User not found");
    }
}