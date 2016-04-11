package by.bsu.chat.creator;

import by.bsu.chat.entity.ChatMenu;
import by.bsu.chat.entity.Login;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Creator {
    public Login createLogin(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            return new Login(scanner.next());
        }
    }

    public ChatMenu createChatMenu(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filename))) {
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
                builder.append("\r\n");
            }
            return new ChatMenu(builder.toString());
        }
    }
}
