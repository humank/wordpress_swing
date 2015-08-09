package com.odde.atdd.demo;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("WordPress-Swing");
        frame.setSize(new Dimension(640, 480));

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        panel.add(new JButton("login"));

        addTextFieldWithLabel(panel, "user_name", "Please input user name");

        addPasswordFieldWithLabel(panel, "password", "Please input password");

        addTextFieldWithLabel(panel, "host_site", "Please input host site");

        frame.setVisible(true);
    }

    private static void addPasswordFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        JLabel label = createAndAddLabel(panel, labelName);
        JPasswordField password = createAndAddPassword(panel, defaultText);
        label.setLabelFor(password);
    }

    private static void addTextFieldWithLabel(JPanel panel, String labelName, String defaultText) {
        JLabel label = createAndAddLabel(panel, labelName);
        JTextField text = createAndAddText(defaultText, label);
        panel.add(text);
    }

    private static JPasswordField createAndAddPassword(JPanel panel, String defaultText) {
        JPasswordField password = new JPasswordField(defaultText);
        panel.add(password);
        return password;
    }

    private static JLabel createAndAddLabel(JPanel panel, String labelName) {
        JLabel label = new JLabel(labelName);
        panel.add(label);
        return label;
    }

    private static JTextField createAndAddText(String defaultText, JLabel label) {
        JTextField text = new JTextField(defaultText);
        label.setLabelFor(text);
        return text;
    }

}
