package com.odde.atdd.demo.view;

import javax.swing.*;
import java.awt.*;

public class ContentPanel {

    private final JPanel panel;
    private final JPanel labelPanel;
    private final JPanel fieldPanel;
    private final JPanel buttonPanel;

    public ContentPanel(JDialog dialog) {
        panel = new JPanel(new BorderLayout());
        dialog.setContentPane(panel);

        labelPanel = new JPanel(new GridLayout(4, 1));
        fieldPanel = new JPanel(new GridLayout(4, 1));
        buttonPanel = new JPanel(new GridLayout(1, 1));

        panel.add(labelPanel, BorderLayout.WEST);
        panel.add(fieldPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JLabel newLabel(String name) {
        JLabel label = new JLabel(name);
        labelPanel.add(label);
        return label;
    }

    public JButton newButton(String name) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
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
        fieldPanel.add(password);
        return password;
    }

    private JTextField newText(String defaultText) {
        JTextField text = new JTextField(defaultText);
        fieldPanel.add(text);
        return text;
    }

}
