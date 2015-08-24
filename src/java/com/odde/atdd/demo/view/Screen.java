package com.odde.atdd.demo.view;

import javax.swing.*;
import java.awt.*;

public interface Screen {

    default void display(JDialog dialog, String title, Window owner) {
        dialog.setTitle(title);
        displayRelatively(dialog, owner);
    }

    default void displayRelatively(Window self, Window owner) {
        self.setLocationRelativeTo(owner);
        self.pack();
        self.setVisible(true);
    }

    default void display(JFrame frame, String title, Window owner) {
        frame.setTitle(title);
        displayRelatively(frame, owner);
    }
}
