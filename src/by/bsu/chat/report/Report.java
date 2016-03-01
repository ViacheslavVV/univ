package by.bsu.chat.report;

import by.bsu.chat.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * report to json
 */
public class Report {
    public void saveHistory(String filename, List<Message> messages) throws IOException {
        Writer writer = new FileWriter(filename, false);
        Gson gson = new GsonBuilder().create();
        gson.toJson(messages, writer);
        writer.close();
    }
}