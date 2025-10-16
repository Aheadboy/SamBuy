package org.sambuy.usecases.user;

public interface ValidateUserAddressUseCase {
    void execute(String userId, String groupOrderId, UserOutputBoundary presenter);
}