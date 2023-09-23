package ui.tabs;

import ui.ButtonNames;
import ui.StudentDataUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeTab extends Tab {
    private static final String INIT_GREETING = "Welcome to TutorConnect";
    private JLabel greeting;

    public HomeTab(StudentDataUI controller) {
        super(controller);

        setLayout(new GridLayout(4, 1));

        placeGreeting();
        placeAddButton();
        placeViewButton();
    }

    private void placeGreeting() {
        greeting = new JLabel(INIT_GREETING, JLabel.CENTER);
        greeting.setSize(WIDTH, HEIGHT / 3);
        this.add(greeting);
    }

    private void placeAddButton() {
        JPanel addBlock = new JPanel();
        JButton addButton = new JButton(ButtonNames.GO_TO_ADD.getValue());
        addBlock.add(formatButtonRow(addButton));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.GO_TO_ADD.getValue())) {
                    getController().getTabbedPane().setSelectedIndex(StudentDataUI.ADD_TAB_INDEX);
                }
            }
        });

        this.add(addBlock);
    }

    private void placeViewButton() {
        JPanel statusBlock = new JPanel();
        JButton statusButton = new JButton(ButtonNames.GO_TO_FIND_TUTOR.getValue());
        statusBlock.add(formatButtonRow(statusButton));

        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.GO_TO_FIND_TUTOR.getValue())) {
                    getController().getTabbedPane().setSelectedIndex(StudentDataUI.CHAT_ROOM_TAB_INDEX);
                }
            }
        });

        this.add(statusBlock);
    }
}
