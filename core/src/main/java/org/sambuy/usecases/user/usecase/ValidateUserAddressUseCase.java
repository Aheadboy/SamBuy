package org.sambuy.usecases.user.usecase;

import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;

public interface ValidateUserAddressUseCase {
    void execute(String userId, String groupOrderId, UserOutputBoundary presenter);
}