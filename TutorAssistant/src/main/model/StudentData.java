package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class StudentData implements Writable {

    private List<Student> students;
    private String course;
    private String school;

    public StudentData() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student s) {
        this.students.add(s);
        this.course = s.getCourseNeeded();
        this.school = s.getSchoolNeeded();
    }

    public String getCourse() {
        return this.course;
    }

    public String getSchool() {
        return this.school;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("students", studentsToJson());
        return json;
    }

    private JSONArray studentsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Student s : students) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }
}
