package ui.tabs;

import ui.ButtonNames;
import ui.StudentDataUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatRoomTab extends Tab {
    private static final String VIEW_GEN_MESSAGE = "Discord IDs are listed below:";

    private JScrollPane viewPane;
    private JTextArea viewText;
    private static TextField textFieldUserInput;
    private JLabel viewMessage;

    //REQUIRES: MatchHistoryUI controller that holds this tab
    //EFFECTS: creates view tab with buttons and window that shows games in match history
    public ChatRoomTab(StudentDataUI controller) {
        super(controller);

        placeViewButton();

        JPanel viewScrollPanel = new JPanel(new GridLayout(2, 1));
        viewScrollPanel.setSize(StudentDataUI.WIDTH - (StudentDataUI.WIDTH / 3),
                StudentDataUI.HEIGHT - (StudentDataUI.HEIGHT / 3));
        viewMessage = new JLabel("");
        viewPane = new JScrollPane(new JTextArea(6, 40));
        viewText = new JTextArea("", 6, 40);
        viewText.setVisible(true);

        viewScrollPanel.add(viewMessage);
        viewScrollPanel.add(viewPane);

        add(viewScrollPanel);
    }

    public void init() {
        textFieldUserInput = new TextField(30);
        textFieldUserInput.setColumns(45);
    }

    //MODIFIES: this
    //EFFECTS: adds a generate match history button that prints all games in match history when clicked
    private void placeViewButton() {
        init();
        JButton b1 = new JButton(ButtonNames.GENERATE_TUTOR.getValue());
        JPanel buttonRow = formatButtonRow(b1);
        buttonRow.setSize(WIDTH, HEIGHT / 6);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonPressed = e.getActionCommand();
                if (buttonPressed.equals(ButtonNames.GENERATE_TUTOR.getValue())) {
                    viewMessage.setText(VIEW_GEN_MESSAGE);
                    viewText.setText(getController().getStudentData().tutorsDisplaying());
                    viewPane.setViewportView(viewText);
                }
            }
        });

        this.add(buttonRow);
    }
}
