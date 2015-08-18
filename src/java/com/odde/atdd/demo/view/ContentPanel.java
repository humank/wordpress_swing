package com.odde.atdd.demo.view;

import javax.swing.*;

public class ContentPanel {

    private final JPanel panel;

    public ContentPanel(JFrame frame) {
        this.panel = new JPanel();
        frame.setContentPane(panel);
    }

    public JLabel newLabel(String name) {
        JLabel label = new JLabel(name);
        panel.add(label);
        return label;
    }

    public JButton newButton(String name) {
        JButton button = new JButton(name);
        panel.add(button);
        return button;
    }

    public JTextField newTextFieldWithLabel(String labelName, String defaultText) {
        JTextField textField = newText(defaultText);
        newLabel(labelName).setLabelFor(textField);
        return textField;
    }

    public JPasswordField newPasswordFieldWithLabel(String labelName, String defaultText) {
        JPasswordField field = newPassword(defaultText);
        newLabel(labelName).setLabelFor(field);
        return field;
    }

    private JPasswordField newPassword(String defaultText) {
        JPasswordField password = new JPasswordField(defaultText);
        panel.add(password);
        return password;
    }

    private JTextField newText(String defaultText) {
        JTextField text = new JTextField(defaultText);
        panel.add(text);
        return text;
    }

}
