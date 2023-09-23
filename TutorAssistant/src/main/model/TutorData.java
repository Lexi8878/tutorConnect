package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class TutorData implements Writable {

    private List<Tutor> tutors;
    private List<String> tutorUserNames;

    public TutorData() {
        this.tutors = new ArrayList<>();
        this.tutorUserNames = new ArrayList<>();
    }

    public void addTutor(Tutor t) {
        this.tutors.add(t);
    }

    public void addUserNames(String s) {
        this.tutorUserNames.add(s);
    }
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("tutors", tutorsToJson());
        return json;
    }

    private JSONArray tutorsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Tutor t : tutors) {
            jsonArray.put(t.toJson());
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
