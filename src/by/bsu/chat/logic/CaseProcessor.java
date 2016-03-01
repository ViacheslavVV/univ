package by.bsu.chat.logic;

import by.bsu.chat.entity.ChatMenu;
import by.bsu.chat.entity.Login;
import by.bsu.chat.entity.Message;
import by.bsu.chat.main.IllegalCaseException;
import by.bsu.chat.report.Report;
import java.io.IOException;
import java.util.*;

/**
 * this class defines actions with message
 */
public class CaseProcessor {

    public void process(ChatMenu menu, Login login) throws IllegalCaseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int i;

            List<Message> mesList = new ArrayList<>();
            Message message;
            do {
                System.out.println(menu);
                i = Integer.parseInt(scanner.nextLine());
                switch (i) {
                    case 1:
                        System.out.println("Enter your message");
                        message = new Message(scanner.nextLine(), login.toString(), new Date().getTime());
                        mesList.add(message);
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println(mesList);
                        break;
                    case 4:
                        System.out.println("Enter id of removing message");
                        int id;
                        id = Integer.parseInt(scanner.nextLine());
                        MessageAction action = new MessageAction();
                        action.removeMessage(id, mesList);
                        break;
                    case 5:
                        Report report = new Report();
                        report.saveHistory("output.json", mesList);
                        break;
                    default:
                        throw new IllegalCaseException("illegal case");
                }
            } while (i != 2);
        }
    }
}