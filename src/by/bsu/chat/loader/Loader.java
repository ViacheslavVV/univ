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

public class Loader {
    public Collection<Message> loadHistory(String filename) throws IOException {
        Reader reader = new FileReader(filename);
        Gson gson = new GsonBuilder().create();

        Type collectionType = new TypeToken<ArrayDeque<Message>>() {
        }.getType();

        Collection<Message> messages = gson.fromJson(reader, collectionType);

        if (messages == null) {
            messages = new ArrayDeque<>();
        }

        reader.close();
        return messages;
    }
}
