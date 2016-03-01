package by.bsu.chat.creator;

import by.bsu.chat.entity.ChatMenu;
import by.bsu.chat.entity.Login;
import by.bsu.chat.entity.Message;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;

public class Creator {
    /*public Message createMessage(String text, String author) {
        return new Message(text, author, new Date().getTime());
    }*/

    public Login createLogin(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("login.txt"))) {
            return new Login(scanner.next());
        }
    }

    public ChatMenu createChatMenu(String filename) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("chatmenu.txt"))) {
            StringBuilder builder = new StringBuilder();
            while (scanner.hasNextLine()) {
                builder.append(scanner.nextLine());
                builder.append("\r\n");
            }
            return new ChatMenu(builder.toString());
        }
    }
}