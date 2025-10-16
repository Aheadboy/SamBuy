package org.sambuy.swing;



import org.sambuy.mock.MockUserRepository;
import org.sambuy.usecases.user.GetUserUseCase;
import org.sambuy.usecases.user.RegisterUserUseCase;
import org.sambuy.usecases.user.impl.GetUserUseCaseImpl;
import org.sambuy.usecases.user.impl.RegisterUserUseCaseImpl;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final RegisterUserUseCase registerUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final SwingUserPresenter presenter;

    public MainFrame() {
        // 初始化 Presenter 和 Use Cases
        presenter = new SwingUserPresenter(this);
        MockUserRepository repository = new MockUserRepository();
        registerUserUseCase = new RegisterUserUseCaseImpl(repository, presenter);
        getUserUseCase = new GetUserUseCaseImpl(repository, presenter);

        // 设置窗口
        setTitle("SamProxy App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建 UI
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();
        JLabel userIdLabel = new JLabel("User ID:");
        JTextField userIdField = new JTextField();
        JButton registerButton = new JButton("Register");
        JButton getUserButton = new JButton("Get User");

        // 添加组件
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(userIdLabel);
        panel.add(userIdField);
        panel.add(registerButton);
        panel.add(getUserButton);
        add(panel, BorderLayout.CENTER);

        // 注册按钮事件
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            registerUserUseCase.execute(username, email, phone);
        });

        // 查询按钮事件
        getUserButton.addActionListener(e -> {
            String userId = userIdField.getText();
            getUserUseCase.execute(userId, presenter);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}