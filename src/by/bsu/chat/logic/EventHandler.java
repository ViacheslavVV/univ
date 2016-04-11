package by.bsu.chat.logic;

import by.bsu.chat.action.HistoryAction;
import by.bsu.chat.entity.ChatMenu;
import by.bsu.chat.entity.Login;
import by.bsu.chat.entity.Message;
import by.bsu.chat.report.Report;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

/**
 * this class defines actions with message
 */
public class EventHandler {
    public void startChat(ChatMenu menu, Login login, Collection<Message> messages) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int i = 0;
            HistoryAction action = new HistoryAction();
            Message message;
            do {
                System.out.println(menu);
                try {
                    i = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("You entered not a number" +
                            "\nPress enter to continue");
                    scanner.nextLine();
                    continue;
                }
                switch (i) {
                    case 1:
                        System.out.println("Enter your message");
                        message = new Message(
                                scanner.nextLine(),
                                login.toString(),
                                new Date().getTime()
                        );
                        messages.add(message);
                        break;
                    case 2:
                        Report report = new Report();
                        report.messagesToJson("output.json", messages);
                        break;
                    case 3:
                        action.printMessages(messages);
                        break;
                    case 4:
                        System.out.println("Enter id of removing message");
                        int id;
                        try {
                            id = Integer.parseInt(scanner.nextLine());
                            if (action.removeById(id, messages)) {
                                System.out.println("deleted success");
                            } else {
                                System.out.println("message with id = " + id  + " does not exist");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("You entered not a number" +
                                    "\nPress enter to continue");
                            scanner.nextLine();
                            continue;
                        }
                        break;
                    default:
                        System.out.println("illegal case");
                }
            } while (i != 2);
        }
    }
}
