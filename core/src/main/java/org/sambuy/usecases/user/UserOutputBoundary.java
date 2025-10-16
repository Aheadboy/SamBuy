package org.sambuy.usecases.user;

import org.sambuy.entities.Order;
import org.sambuy.entities.User;

import java.util.List;

public interface UserOutputBoundary {
    void presentUser(User user);
    void presentOrders(List<Order> orders);
    void presentSuccess(String message);
    void presentError(String message);
}