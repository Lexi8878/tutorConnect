package ui.tabs;

import ui.StudentDataUI;

import javax.swing.*;
import java.awt.*;

public class Tab extends JPanel {
    private StudentDataUI controller;

    public Tab(StudentDataUI controller) {
        this.controller = controller;
    }

    public JPanel formatButtonRow(JButton b) {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(b);

        return p;
    }

    public StudentDataUI getController() {
        return controller;
    }
}
