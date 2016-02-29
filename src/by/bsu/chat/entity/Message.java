package by.bsu.chat.entity;

import java.util.Date;

/**
 * an entity class message
 */
public class Message {
    private static int counter = 0;
    private int id;
    private String message;
    private String author;
    private long timestamp;
    public Message(String message,
                   String author,
                   long timestamp){
        this.id = counter++;
        this.message = message;
        this.author = author;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return String.join(", ",
                Integer.valueOf(id).toString(),
                message,
                author,
                new Date(timestamp).toString());
    }
}