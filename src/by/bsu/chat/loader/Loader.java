package by.bsu.chat.loader;

import by.bsu.chat.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;

public class Loader {
    public Collection<Message> loadHistory(String filename) {
        try (Reader reader = new FileReader(filename)) {

            Gson gson = new GsonBuilder().create();

            Type collectionType = new TypeToken<ArrayDeque<Message>>() {
            }.getType();

            Collection<Message> messages = gson.fromJson(reader, collectionType);

            if (messages == null) {
                messages = new ArrayDeque<>();
            }
            return messages;

        } catch (IOException e) {
            System.err.println("file " + filename + "didn't find");
            e.printStackTrace();
            System.exit(1);
        }
        return Collections.emptyList();
    }
}
