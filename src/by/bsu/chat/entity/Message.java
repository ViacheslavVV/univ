package by.bsu.chat.entity;

import java.util.Date;
import java.util.Random;

/**
 * an entity class message
 */
public class Message {
    private static Random random;
    static  {
        random = new Random();
    }
    private int id;
    private String message;
    private String author;
    private long timestamp;

    public Message(String message,
                   String author,
                   long timestamp){
        this.id = random.nextInt();
        this.message = message;
        this.author = author;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public static Random getRandom() {
        return random;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void setRandom(Random random) {
        Message.random = random;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        return new StringBuilder().append("id = ").append(id).append("\n")
                .append("message = ").append(message).append("\n")
                .append("author = ").append(author).append("\n")
                .append("date = ").append(new Date(timestamp)).toString();
    }
}
