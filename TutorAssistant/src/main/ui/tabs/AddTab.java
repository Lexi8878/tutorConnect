package ui.tabs;

import ui.ButtonNames;
import ui.StudentDataUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a tab that allows user to add match details into text fields and adds match into match history
public class AddTab extends Tab {
    private JPanel panel;
    private JLabel labelUsername;
    private JLabel labelRealName;
    private JLabel labelSchool;
    private JLabel labelSubject;
    private JLabel labelStatus;
    private JButton b1;
    private static TextField textFieldUsername;
    private static TextField textFieldRealName;
    private static TextField textFieldSchool;
    private static TextField textFieldSubject;
    private static TextField textFieldStatus;

    private static String username;
    private static String realName;
    private static String school;
    private static String subject;
    private static String status;

    // REQUIRES: MatchHistoryUI controller that holds this tab
    // EFFECTS: creates add tab that allows user to enter match details into text fields
    public AddTab(StudentDataUI controller) {
        super(controller);
        placeAddButton();
    }

    // MODIFIES: this
    // EFFECTS: initializes GUI frame, panel, labels, button
    public void init() {
        setLayout(new GridLayout(1, 20));
        panel = new JPanel();
        panel.setSize(600, 400);

        labelUsername = new JLabel("Enter display name");
        textFieldUsername = new TextField(30);
        textFieldUsername.setColumns(45);

        labelRealName = new JLabel("Enter full name");
        textFieldRealName = new TextField(30);
        textFieldRealName.setColumns(45);

        labelSchool = new JLabel("Enter school");
        textFieldSchool = new TextField(30);
        textFieldSchool.setColumns(45);

        labelSubject = new JLabel("Enter subject area");
        textFieldSubject = new TextField(30);
        textFieldSubject.setColumns(45);

        labelStatus = new JLabel("Signing up as student or tutor assistant?");
        textFieldStatus = new TextField(30);
        textFieldStatus.setColumns(45);

        b1 = new JButton(ButtonNames.ADD.getValue());
        b1.setPreferredSize(new Dimension(90,30));

    }

    // MODIFIES: this
    // EFFECTS: adds labels and text fields to JPanel
    private void addToPanel() {
        panel.add(labelUsername);
        panel.add(textFieldUsername);
        panel.add(labelRealName);
        panel.add(textFieldRealName);
        panel.add(labelSchool);
        panel.add(textFieldSchool);
        panel.add(labelSubject);
        panel.add(textFieldSubject);
        panel.add(labelStatus);
        panel.add(textFieldStatus);
        panel.add(b1);
    }

    //MODIFIES: this
    //EFFECTS: adds a generate report button that prints app status when clicked
    private void placeAddButton() {
        init();
        addToPanel();

        this.add(panel);
        this.setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == b1) {
                    username = textFieldUsername.getText().toLowerCase();
                    realName = textFieldRealName.getText();
                    school = textFieldSchool.getText();
                    subject = textFieldSubject.getText();
                    status = textFieldStatus.getText();
                    getController().addCommand(username, realName, school, subject);

                    getController().addStatus(status);
                }
            }
        });
    }
}
