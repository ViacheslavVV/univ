package by.bsu.chat.logic;

import by.bsu.chat.action.HistoryAction;
import by.bsu.chat.constants.Constants;
import by.bsu.chat.entity.Login;
import by.bsu.chat.entity.Message;
import by.bsu.chat.report.Report;
import org.apache.log4j.Logger;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

class UserAction {
    private static final Logger LOG = Logger.getLogger(UserAction.class);

    void createAndAddMessage(Login login, Collection<Message> messages, Scanner scanner) {
        Message message;
        System.out.println(Constants.enterMessageString());
        message = new Message(
                scanner.nextLine(),
                login.toString(),
                new Date().getTime()
        );
        LOG.info("message created");
        if (message.getText().length() > Constants.MAX_LENGTH) {
            LOG.warn(Constants.moreThan140());
        }
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
                System.out.println(Constants.deleteIdSuccessString());
                LOG.info(Constants.deleteIdSuccessString());
            } else {
                System.out.println("deleting message with id = " + id  + " does not exist");
                LOG.info("deleting failed message with id = " + id  + " does not exist");
            }
        } catch (NumberFormatException e) {
            System.out.println(Constants.numberFormatString());
            LOG.info(Constants.numberFormatString(), e);
        }
    }

    void authorSearchAndPrintResult(Collection<Message> messages, HistoryAction action, Scanner scanner) {
        System.out.println("enter author");
        String author = scanner.nextLine().trim();
        Collection<Message> authorCollection = action.authorSearch(author, messages);
        action.printMessages(authorCollection);
        LOG.info("author search: " + authorCollection.size() + " messages found");
    }

    void regexSearchAndPrintResult(Collection<Message> messages, HistoryAction action, Scanner scanner) {
        System.out.println("enter regex");
        String regex = scanner.nextLine();
        Collection<Message> regexCollection = action.regexSearch(regex, messages);
        action.printMessages(regexCollection);
        LOG.info("regex search: " + regexCollection.size() + " messages found");
    }

    void lexemeSearchAndPrintResult(Collection<Message> messages, HistoryAction action, Scanner scanner) {
        System.out.println("enter lexeme");
        String lexeme = scanner.nextLine();
        Collection<Message> lexemeCollection = action.lexemeSearch(lexeme, messages);
        action.printMessages(lexemeCollection);
        LOG.info("lexeme search: " + lexemeCollection.size() + " messages found");
    }

    void periodSearchAndPrint(Collection<Message> messages, HistoryAction action, Scanner scanner) {
        try {
            System.out.println("enter from timestamp");
            long t1 = Long.parseLong(scanner.nextLine());
            System.out.println("enter by timestamp");
            long t2 = Long.parseLong(scanner.nextLine());
            Collection<Message> periodCollection = action.periodSearch(messages, t1, t2);
            action.printMessages(periodCollection);
            LOG.info("period search: " + periodCollection.size() + " messages found");

        } catch (NumberFormatException e) {
            System.out.println(Constants.numberFormatString());
            LOG.info(Constants.numberFormatString(), e);
        }
    }
}
