package com.odde.atdd.demo;

import javax.swing.*;
import java.awt.*;

public class DashboardPage extends JFrame {

    public DashboardPage() {
        super("Dashboard");
        add(new JLabel("Dashboard"));
        setSize(new Dimension(640, 480));
        setVisible(true);
    }

}
