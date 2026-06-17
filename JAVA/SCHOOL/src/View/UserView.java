package View;

import Controller.UserController;
import Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserView extends JFrame {
    private JTextField nameField, emailField, idField;
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserView() {
        setTitle("User Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for Input Fields
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        JButton addButton = new JButton("Add User");
        panel.add(addButton);

        add(panel, BorderLayout.NORTH);

        // Table for displaying users
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Email"}, 0);
        userTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(userTable);
        add(scrollPane, BorderLayout.CENTER);

        // Load Data
        loadUsers();

        // Button Actions
        addButton.addActionListener(e -> addUser());
        // updateButton.addActionListener(e -> updateUser());
        // deleteButton.addActionListener(e -> deleteUser());

        setVisible(true);
    }

    private void loadUsers() {
        tableModel.setRowCount(0);
        List<User> users = UserController.getUsers();
        for (User u : users) {
            tableModel.addRow(new Object[]{u.getId(), u.getName(), u.getEmail()});
        }
    }

    private void addUser() {
        String name = nameField.getText();
        String id = idField.getText();
        String email = emailField.getText();
        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }
        if (UserController.addUser(name, email)) {
            loadUsers();
            JOptionPane.showMessageDialog(this, "User added successfully!");
        }
    }
    public static void main(String[] args) {
        new UserView();
    }
}