package com.odde.atdd.demo.view;

import javax.swing.*;
import java.awt.*;

public class TwoColumnsBalancedPanel {

    private final JPanel panel;
    private final JPanel labelPanel;
    private final JPanel fieldPanel;
    private final JPanel buttonPanel;
    private final JPanel mainPanel;
    private int labelCount;
    private int buttonCount;
    private int fieldCount;

    public TwoColumnsBalancedPanel(JDialog dialog) {
        panel = new JPanel(new BorderLayout());
        dialog.setContentPane(panel);

        mainPanel = new JPanel();
        labelPanel = new JPanel();
        fieldPanel = new JPanel();
        buttonPanel = new JPanel();

        panel.add(mainPanel, BorderLayout.NORTH);
        panel.add(labelPanel, BorderLayout.WEST);
        panel.add(fieldPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JLabel newLabel(String name) {
        JLabel label = new JLabel(name);
        labelPanel.add(label);
        labelPanel.setLayout(new GridLayout(++labelCount, 1));
        addLabelToFieldPanelForBalance();
        return label;
    }

    private void addLabelToFieldPanelForBalance() {
        if (fieldCount == labelCount - 1) {
            fieldPanel.add(new Label());
            fieldPanel.setLayout(new GridLayout(++fieldCount, 1));
        }
    }

    public JButton newButton(String name) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        buttonPanel.setLayout(new GridLayout(++buttonCount, 1));
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
        fieldPanel.setLayout(new GridLayout(++fieldCount, 1));
        return password;
    }

    private JTextField newText(String defaultText) {
        JTextField text = new JTextField(defaultText);
        fieldPanel.add(text);
        fieldPanel.setLayout(new GridLayout(++fieldCount, 1));
        return text;
    }

    public void newMainContent(String text) {
        mainPanel.add(new JLabel(text));
        mainPanel.setLayout(new GridLayout(1, 1));
    }
}
