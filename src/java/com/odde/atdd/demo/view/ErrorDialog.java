package com.odde.atdd.demo.view;

import javax.swing.*;
import java.awt.*;

public class ErrorDialog extends JDialog implements Screen {
    public ErrorDialog(Window owner, String errorMsg) {
        super(owner);

        TwoColumnsBalancedPanel contentPanel = new TwoColumnsBalancedPanel(this);
        contentPanel.newLabel(errorMsg);

        display(this, "Error", owner);
    }
}
