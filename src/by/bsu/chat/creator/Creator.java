package by.bsu.chat.creator;

import by.bsu.chat.entity.Message;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by jenia on 16.02.16.
 */
public class Creator {
    public Message createMessage(String filename) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(filename));
        Message message = new Message(
                Integer.parseInt(scanner.nextLine()),
                scanner.nextLine().trim(),
                scanner.nextLine().trim(),
                Long.parseLong(scanner.nextLine()));
        scanner.close();
        return message;
    }
}