package by.bsu.chat.logic;

import by.bsu.chat.creator.Creator;
import by.bsu.chat.entity.Message;
import by.bsu.chat.main.IllegalCaseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * this class defines actions with message
 */
public class MessageAction {
    private static boolean removeMessage(int id, List<Message> list) {
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
            String author = scanner.nextLine().trim();
            String string;
            ArrayList<Message> list = new ArrayList<>();
            do {
                System.out.println("Choose you destiny");
                System.out.println("1 write message");
                System.out.println("2 exit");
                System.out.println("3 view history");
                System.out.println("4 remove by id");
                System.out.println("5 save to file");
                i = Integer.parseInt(scanner.nextLine());
                switch (i) {
                    case 1:
                        System.out.println("Enter your message");
                        string = scanner.nextLine();
                        message = creator.createMessage(string, author);
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
                        Writer writer = new FileWriter("output.json", false);
                        Gson gson = new GsonBuilder().create();
                        gson.toJson(list, writer);
                        writer.close();
                        break;
                    default:
                        throw new IllegalCaseException("illegal case");
                }
            } while (i != 2);
        }
    }
}
