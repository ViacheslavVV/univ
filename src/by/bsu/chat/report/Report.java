package by.bsu.chat.report;

import by.bsu.chat.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

/**
 * report to json
 */
public class Report {
    public void messagesToJson(String filename, Collection<Message> messages) throws IOException {
        Writer writer = new FileWriter(filename);
        Gson gson = new GsonBuilder().create();
        gson.toJson(messages, writer);
        writer.close();
    }
}
