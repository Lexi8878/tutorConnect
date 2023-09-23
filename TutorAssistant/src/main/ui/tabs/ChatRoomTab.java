package ui.tabs;

import ui.ButtonNames;
import ui.StudentDataUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatRoomTab extends Tab {
    private static final String VIEW_GEN_MESSAGE = "Available tutors listed below:";

    private JScrollPane viewPane;
    private JTextArea viewText;
    private static TextField textFieldUserInput;
    private JLabel viewMessage;

    public ChatRoomTab(StudentDataUI controller) {
        super(controller);

        placeViewButton();

        JPanel viewScrollPanel = new JPanel(new GridLayout(2, 1));
        viewScrollPanel.setSize(StudentDataUI.WIDTH - (StudentDataUI.WIDTH / 5),
                StudentDataUI.HEIGHT - (StudentDataUI.HEIGHT / 5));
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
                    if (getController().getStudentData().getCourse().equals("Computer Science")
                            && getController().getStudentData().getSchool().equals("UBC")) {
                        viewText.setText("1. Discord: CPSCTutor110\nSchool: UBC\nSubject:CPSC\n\n" +
                                "2. Discord: BestCoderNA\nSchool: UBC\nSubject:CPSC\n\n" +
                                "3. Discord: hibye01\nSchool: SFU\nSubject:CPSC\n\n" +
                                "4. Discord: non-player-character\nSchool: Langara\nSubject:CPSC\n\n" +
                                "5. Discord: Fluffy_Sheep\nSchool: Langara\nSubject:CPSC");
                    } else if (getController().getStudentData().getCourse().equals("Computer Science")
                            && getController().getStudentData().getSchool().equals("Langara")) {
                        viewText.setText("1. Discord: FlightReacts\nSchool: Langara\nSubject:CPSC\n\n" +
                                "2. Discord: non-player-character\nSchool: Langara\nSubject:CPSC\n\n" +
                                "3. Discord: Fluffy_Sheep\nSchool: Langara\nSubject:CPSC\n\n" +
                                "4. Discord: BestCoderNA\nSchool: UBC\nSubject:CPSC\n\n" +
                                "5. Discord: CPSCTutor110\nSchool: UBC\nSubject:CPSC\n\n" +
                                "6. Discord: hibye01\nSchool: SFU\nSubject:CPSC");
                    } else if (getController().getStudentData().getCourse().equals("Arts")
                            && getController().getStudentData().getSchool().equals("UBC")) {
                        viewText.setText("1. Discord: John837\nSchool: UBC\nSubject:Arts\n\n" +
                                "2. Discord: NgBoi_Ngo\nSchool: SFU\nSubject:Arts\n\n" +
                                "3. Discord: tim8878\nSchool: Langara\nSubject:Arts");
                    } else {
                        viewText.setText("There are currently no tutors available for that course");
                    }
                    //viewText.setText(getController().getTutorData().tutorsDisplaying());
                    viewPane.setViewportView(viewText);
                }
            }
        });

        this.add(buttonRow);
    }
}
