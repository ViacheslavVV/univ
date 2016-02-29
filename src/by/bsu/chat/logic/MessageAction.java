package by.bsu.chat.logic;

import by.bsu.chat.entity.Message;

import java.util.Date;
import java.util.Scanner;

/**
 * this class defines actions with message
 */
public class MessageAction {
    public Message getMessage() {
        try (Scanner scanner = new Scanner(System.in)) {
            return new Message(scanner.nextLine(), "author", new Date().getTime());
        }
    }
}
