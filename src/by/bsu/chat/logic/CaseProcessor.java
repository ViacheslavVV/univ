package by.bsu.chat.logic;

import by.bsu.chat.creator.Creator;
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
    private boolean removeMessage(int id, List<Message> list) {
        int i = -1;
        for (Message message : list) {
            if (message.getId() == id) {
                i = list.indexOf(message);
                break;
            }
        }
        if (i == -1) {
            return false;
        } else {
            list.remove(i);
            return true;
        }
    }
    public void process() throws IllegalCaseException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            int i;
            Creator creator = new Creator();
            Message message;
            System.out.println("Enter your login");
            Login login = new Login(scanner.nextLine().trim());
            List<Message> list = new ArrayList<>();
            Menu menu = new Menu();
            do {
                System.out.println(menu);
                i = Integer.parseInt(scanner.nextLine());
                switch (i) {
                    case 1:
                        System.out.println("Enter your message");
                        message = creator.createMessage(
                                scanner.nextLine(),
                                login.toString()
                        );
                        list.add(message);
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println(list);
                        break;
                    case 4:
                        System.out.println("Enter id of removing message");
                        int id;
                        id = Integer.parseInt(scanner.nextLine());
                        removeMessage(id, list);
                        break;
                    case 5:
                        Report report = new Report();
                        report.saveHistory("output.json", list);
                        break;
                    default:
                        throw new IllegalCaseException("illegal case");
                }
            } while (i != 2);
        }
    }
}