package model;

import org.json.JSONObject;

public class Tutor extends User {
    private boolean isPaid;
    private boolean isTeacher;

    public Tutor(String username, String realName, String school, String subject, boolean isPaid, boolean isTeacher) {
        super(username, realName, school, subject);
        this.isPaid = isPaid;
        this.isTeacher = isTeacher;
    }

    public String getUserName() {
        return username;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("realName", realName);
        json.put("school", school);
        json.put("subject", subject);
        json.put("isPaid", isPaid);
        json.put("isTeacher", isTeacher);
        return json;
    }
}
