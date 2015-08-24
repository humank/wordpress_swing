package com.odde.atdd.demo.view;

import javax.swing.*;

public class Main extends JFrame implements Screen {

    public Main() {
        super();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        display(this, "WordPress-Swing", null);

        new LoginPage(this);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new Main());

    }

}
