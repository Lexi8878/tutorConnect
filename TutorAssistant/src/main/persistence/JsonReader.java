package persistence;

import model.Student;
import model.StudentData;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public StudentData read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseStudentData(jsonObject);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    private StudentData parseStudentData(JSONObject jsonObject) {
        StudentData sd = new StudentData();
        addStudents(sd, jsonObject);
        return sd;
    }

    private void addStudents(StudentData sd, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("students");
        for (Object json : jsonArray) {
            JSONObject nextGame = (JSONObject) json;
            addGame(sd, nextGame);
        }
    }

    private void addGame(StudentData sd, JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String realName = jsonObject.getString("realName");
        String school = jsonObject.getString("school");
        String subject = jsonObject.getString("subject");
        Student s = new Student(username, realName, school, subject);
        sd.addStudent(s);
    }
}
