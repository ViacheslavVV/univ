package by.bsu.chat.creator;

import by.bsu.chat.entity.Message;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by jenia on 16.02.16.
 */
public class Creator {
    public Message createMessage(String text, String author) {
        return new Message(text, author, new Date().getTime());
    }
}