package by.bsu.chat.entity;

import java.util.Date;
import java.util.Random;

/**
 * an entity class text
 */
public class Message {
    private static Random random;
    static  {
        random = new Random();
    }
    private int id;
    private String text;
    private String author;
    private long timestamp;

    public Message() {
    }

    public Message(String text,
                   String author,
                   long timestamp){
        this.id = random.nextInt();
        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
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

    public void setText(String text) {
        this.text = text;
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
        return new StringBuilder()
                .append("id = ").append(id).append("\n")
                .append("text = ").append(text).append("\n")
                .append("author = ").append(author).append("\n")
                .append("date = ").append(new Date(timestamp)).toString();
    }
}
