package by.bsu.chat.entity;

import java.util.Date;

/**
 * Created by jenia on 16.02.16.
 */
public class Message {
    private int id;
    private String message;
    private String author;
    private long timestamp;
    public Message(int id, String message,
                   String author, long timestamp){
        this.id = id;
        this.message = message;
        this.author = author;
        this.timestamp = timestamp;
    }
    public String toString(){
        return String.join(", ",
                Integer.valueOf(id).toString(),
                message,
                author,
                new Date(timestamp).toString());
    }
}
