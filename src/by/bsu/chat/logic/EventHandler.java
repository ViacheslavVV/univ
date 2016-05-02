package by.bsu.chat.logic;

import by.bsu.chat.action.HistoryAction;
import by.bsu.chat.constants.Constants;
import by.bsu.chat.entity.Login;
import by.bsu.chat.entity.Message;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Scanner;

/**
 * this class defines actions with message
 */
public class EventHandler {
    private static final Logger LOG = Logger.getLogger(EventHandler.class);

    public void startChat(Login login, Collection<Message> messages) {
        try (Scanner scanner = new Scanner(System.in)) {
            int i = 0;
            HistoryAction historyAction = new HistoryAction();
            UserAction userAction = new UserAction();
            do {
                System.out.println(Constants.menuString());
                try {
                    i = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(Constants.numberFormatString());
                    LOG.info(Constants.numberFormatString(), e);
                    continue;
                }
                switch (i) {
                    case 1:
                        userAction.createAndAddMessage(login, messages, scanner);
                        break;
                    case 2:
                        userAction.exitAndSave(messages, Constants.outFileString());
                        break;
                    case 3:
                        userAction.printMessageHistory(messages, historyAction);
                        break;
                    case 4:
                        userAction.idDelete(messages, scanner, historyAction);
                        break;
                    case 5:
                        userAction.authorSearchAndPrintResult(messages, historyAction, scanner);
                        break;
                    case 6:
                        userAction.regexSearchAndPrintResult(messages, historyAction, scanner);
                        break;
                    case 7:
                        userAction.lexemeSearchAndPrintResult(messages, historyAction, scanner);
                        break;
                    case 8:
                        userAction.periodSearchAndPrint(messages, historyAction, scanner);
                        break;
                    default:
                        System.out.println(Constants.illegalCaseString());
                }
            } while (i != 2);
        }
    }
}
