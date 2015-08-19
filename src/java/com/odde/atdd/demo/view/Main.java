package com.odde.atdd.demo.view;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrame("WordPress-Swing") {{
                    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    setLocationRelativeTo(null);
                    setVisible(true);
                    new LoginPage(this);
                }};
            }
        });

    }

}
