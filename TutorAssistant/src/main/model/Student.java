package model;

import org.json.JSONObject;
import persistence.Writable;

public class Student extends User implements Writable {
    private final boolean student = true;

    public Student(String username, String realName, String school, String subject) {
        super(username, realName, school, subject);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("teamPoints", realName);
        json.put("enemyPoints", school);
        json.put("agent", subject);
        return json;
    }

    public boolean isStudent() {
        return student;
    }
}
