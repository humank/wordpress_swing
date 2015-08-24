package com.odde.atdd.demo.view;

import javax.swing.*;
import java.awt.*;

public interface Screen {

    default void display(JDialog dialog, String title, Window owner) {
        dialog.setTitle(title);
        dialog.setLocationRelativeTo(owner);
        dialog.pack();
        dialog.setVisible(true);
    }
}
