package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class StudentData implements Writable {

    private List<Student> students;
    private List<Tutor> tutors;

    // EFFECTS: Constructs a match history with an empty list of games
    public StudentData() {
        this.students = new ArrayList<>();
        this.tutors = new ArrayList<>();
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("students", studentsToJson());
        return json;
    }

    // EFFECTS: returns games in match history as a JSON array
    private JSONArray studentsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Student s : students) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }

    public List<String> getTutors() {
        List<String> tutorList = new ArrayList<>();
        for (Tutor t: tutors) {
            String s = t.getUserName();
            tutorList.add(s);
        }

        return tutorList;
    }

    public List<String> getTutorsToDisplay() {
        return getTutors();
    }

    public String tutorsDisplaying() {
        List<String> running = getTutorsToDisplay();
        StringBuilder status = new StringBuilder();

        for (String s : running) {
            status.append("\n").append(s);
        }
        return status.toString();
    }
}
