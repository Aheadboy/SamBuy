package org.sambuy.swing;


import org.sambuy.entities.Order;
import org.sambuy.entities.User;
import org.sambuy.usecases.user.UserOutputBoundary;

import javax.swing.*;
import java.util.List;

public class SwingUserPresenter implements UserOutputBoundary {
    private final JFrame parentFrame;

    public SwingUserPresenter(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    @Override
    public void presentUser(User user) {
        String message = String.format("User Registered:\nID: %s\nUsername: %s\nEmail: %s\nPhone: %s",
                user.getUserId(), user.getUsername(), user.getEmail(), user.getPhone());
        JOptionPane.showMessageDialog(parentFrame, message, "User Info", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void presentOrders(List<Order> orders) {
        StringBuilder message = new StringBuilder("User Orders:\n");
        if (orders.isEmpty()) {
            message.append("No orders found.");
        } else {
            for (Order order : orders) {
                message.append(String.format("Order ID: %s\n", order.getOrderId()));
            }
        }
        JOptionPane.showMessageDialog(parentFrame, message.toString(), "Orders", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void presentSuccess(String message) {
        JOptionPane.showMessageDialog(parentFrame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void presentError(String message) {
        JOptionPane.showMessageDialog(parentFrame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}