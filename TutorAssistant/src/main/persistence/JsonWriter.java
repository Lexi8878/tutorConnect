package persistence;

import model.StudentData;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    public JsonWriter(String destination) {
        this.destination = destination;
    }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(destination);
    }

    public void write(StudentData s) {
        JSONObject json = s.toJson();
        saveToFile(json.toString(TAB));
    }

    public void close() {
        writer.close();
    }

    private void saveToFile(String json) {
        writer.print(json);
    }
}
