package org.sambuy.presenters;

import org.sambuy.entities.Order;
import org.sambuy.entities.User;
import org.sambuy.usecases.user.interfaces.presenters.UserOutputBoundary;

import java.util.List;

public class JsonUserPresenter implements UserOutputBoundary {
    @Override
    public void presentUser(User user) {
        // 返回 JSON: {"userId": "...", "username": "..."}
    }

    @Override
    public void presentOrders(List<Order> orders) {

    }

    @Override
    public void presentSuccess(String message) {

    }

    @Override
    public void presentError(String message) {

    }
    // 其他方法...
}