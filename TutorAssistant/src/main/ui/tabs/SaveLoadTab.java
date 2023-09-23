package ui.tabs;

import ui.ButtonNames;
import ui.StudentDataUI;

import javax.swing.*;
import java.awt.*;

public class SaveLoadTab extends Tab {
    private static final String INIT_MESSAGE = "Save or load?";
    private JLabel message;

    public SaveLoadTab(StudentDataUI controller) {
        super(controller);

        setLayout(new GridLayout(3, 1));

        placeMessage();
        placeSaveLoadButtons();
    }

    private void placeMessage() {
        message = new JLabel(INIT_MESSAGE, JLabel.CENTER);
        message.setSize(WIDTH, HEIGHT / 3);
        this.add(message);
    }

    private void placeSaveLoadButtons() {
        JButton b1 = new JButton(ButtonNames.SAVE.getValue());
        JButton b2 = new JButton(ButtonNames.LOAD.getValue());

        JPanel buttonRow = formatButtonRow(b1);
        buttonRow.add(b2);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        b1.addActionListener(e -> {
            getController().saveStudentData();
            message.setText("Saving data!");
        });

        b2.addActionListener(e -> {
            getController().loadStudentData();
            message.setText("Loading data!");
        });

        this.add(buttonRow);
    }
}
