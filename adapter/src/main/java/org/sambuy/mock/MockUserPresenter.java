package org.sambuy.mock;



import org.sambuy.entities.Order;
import org.sambuy.entities.User;
import org.sambuy.usecases.user.UserOutputBoundary;

import java.util.List;
import java.util.logging.Logger;

public class MockUserPresenter implements UserOutputBoundary {
    private static final Logger LOGGER = Logger.getLogger(MockUserPresenter.class.getName());

    @Override
    public void presentUser(User user) {
        LOGGER.info("Presenting user: " + user.getUserId() + ", " + user.getUsername());
        // 模拟 UI 或服务端输出，例如记录日志或格式化 JSON
    }

    @Override
    public void presentOrders(List<Order> orders) {
        LOGGER.info("Presenting " + orders.size() + " orders");
        // 模拟输出订单列表
    }

    @Override
    public void presentSuccess(String message) {
        LOGGER.info("Success: " + message);
        // 模拟成功消息
    }

    @Override
    public void presentError(String message) {
        LOGGER.warning("Error: " + message);
        // 模拟错误消息
    }
}