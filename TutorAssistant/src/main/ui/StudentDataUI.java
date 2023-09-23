package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tabs.*;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StudentDataUI extends JFrame {
    public static final int HOME_TAB_INDEX = 0;
    public static final int ADD_TAB_INDEX = 1;
    public static final int CHAT_ROOM_TAB_INDEX = 2;
    public static final int SAVE_LOAD_TAB_INDEX = 3;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 600;
    private static final String JSON_STORE = "./data/studentdata.json";

    private JFrame frame;
    private JTabbedPane sidebar;
    private JPanel homeTab;
    private JPanel addTab;
    private JPanel chatRoomTab;
    private JPanel saveLoadTab;

    private StudentData studentData;
    private String status;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public static void main(String[] args) {
        try {
            new StudentDataUI();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }

    private StudentDataUI() throws FileNotFoundException {
        frame = new JFrame();
        frame.setTitle("Tutor Assistant App");
        frame.setSize(WIDTH, HEIGHT);

        frame. setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);


        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        studentData = new StudentData();

        sidebar = new JTabbedPane();
        sidebar.setTabPlacement(JTabbedPane.LEFT);
        loadTabs();
        frame.add(sidebar);
        frame.setVisible(true);
    }

    public StudentData getStudentData() {
        return studentData;
    }

    public String getStatus() {
        return status;
    }

    public void addStatus(String s) {
        this.status = s;
        getStatus();
    }

    public void addCommand(String username, String realName, String school, String subject) {
        doAddStudent(studentData, new Student(username, realName, school, subject));
    }

    private void doAddStudent(StudentData sd, Student s) {
        sd.addStudent(s);
    }

    public void saveStudentData() {
        try {
            jsonWriter.open();
            jsonWriter.write(studentData);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public void loadStudentData() {
        try {
            studentData = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    private void loadTabs() {
        homeTab = new HomeTab(this);
        addTab = new AddTab(this);
        chatRoomTab = new ChatRoomTab(this);
        saveLoadTab = new SaveLoadTab(this);

        sidebar.add(homeTab, HOME_TAB_INDEX);
        sidebar.setTitleAt(HOME_TAB_INDEX, "Home");
        sidebar.add(addTab, ADD_TAB_INDEX);
        sidebar.setTitleAt(ADD_TAB_INDEX, "Sign-up");
        sidebar.add(chatRoomTab, CHAT_ROOM_TAB_INDEX);
        sidebar.setTitleAt(CHAT_ROOM_TAB_INDEX, "Chat Room");
        sidebar.add(saveLoadTab, SAVE_LOAD_TAB_INDEX);
        sidebar.setTitleAt(SAVE_LOAD_TAB_INDEX, "Save/Load");
    }


    // EFFECTS: returns sidebar of this UI
    public JTabbedPane getTabbedPane() {
        return sidebar;
    }

}
