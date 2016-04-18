package by.bsu.chat.logic;

import by.bsu.chat.action.HistoryAction;
import by.bsu.chat.constants.Constants;
import by.bsu.chat.entity.Login;
import by.bsu.chat.entity.Message;
import by.bsu.chat.report.Report;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

class UserAction {
    void createAndAddMessage(Login login, Collection<Message> messages, Scanner scanner) {
        Message message;
        System.out.println(Constants.enterMessageString());
        message = new Message(
                scanner.nextLine(),
                login.toString(),
                new Date().getTime()
        );
        messages.add(message);
    }

    void exitAndSave(Collection<Message> messages, String filename) {
        Report report = new Report();
        report.messagesToJson(filename, messages);
    }

    void printMessageHistory(Collection<Message> messages, HistoryAction action) {
        action.printMessages(messages);
    }

    void idDelete(Collection<Message> messages, Scanner scanner, HistoryAction historyAction) {
        System.out.println(Constants.enterIdString());
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
            if (historyAction.removeById(id, messages)) {
                System.out.println(Constants.deleteSuccessString());
            } else {
                System.out.println("message with id = " + id  + " does not exist");
            }
        } catch (NumberFormatException e) {
            System.out.println(Constants.numberFormatString());
        }
    }

    void authorSearchAndPrintResult(Collection<Message> messages, HistoryAction action, Scanner scanner) {
        System.out.println("enter author");
        String author = scanner.nextLine().trim();
        action.printMessages(action.authorSearch(author, messages));
    }

    void regexSearchAndPrintResult(Collection<Message> messages, HistoryAction action, Scanner scanner) {
        System.out.println("enter regex");
        String regex = scanner.nextLine();
        action.printMessages(action.regexSearch(regex, messages));
    }

    void lexemeSearchAndPrintResult(Collection<Message> messages, HistoryAction action, Scanner scanner) {
        System.out.println("enter lexeme");
        String lexeme = scanner.nextLine();
        action.printMessages(action.lexemeSearch(lexeme, messages));
    }
}
