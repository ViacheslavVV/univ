package by.bsu.chat.main;

import by.bsu.chat.creator.Creator;
import by.bsu.chat.entity.ChatMenu;
import by.bsu.chat.entity.Login;
import by.bsu.chat.entity.Message;
import by.bsu.chat.logic.CaseProcessor;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import java.io.IOException;
import java.util.Scanner;

/**
 * main class
 *
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    static {
        new DOMConfigurator().doConfigure("log4j.xml", org.apache.log4j.LogManager.getLoggerRepository());
    }
    public static void main(String[] args){
        try {
            Creator creator = new Creator();

            Login login = creator.createLogin("login.txt");
            ChatMenu menu = creator.createChatMenu("chatmenu.txt");

            CaseProcessor caseProcessor = new CaseProcessor();
            caseProcessor.process(menu, login);

        } catch (IllegalCaseException e) {
            e.printStackTrace();
            System.err.println("Illegal case");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Io exception");
        }
        //LOG.info("info");
    }
}