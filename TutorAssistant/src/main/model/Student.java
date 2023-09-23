package model;

import org.json.JSONObject;
import persistence.Writable;

public class Student extends User implements Writable {
    private final boolean student = true;

    public Student(String username, String realName, String school, String subject) {
        super(username, realName, school, subject);
    }

    public String getCourseNeeded() {
        return subject;
    }

    public String getSchoolNeeded() {
        return school;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("realName", realName);
        json.put("school", school);
        json.put("subject", subject);
        return json;
    }

    public boolean isStudent() {
        return student;
    }
}
