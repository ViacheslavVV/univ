package by.bsu.chat.main;

import by.bsu.chat.creator.Creator;
import by.bsu.chat.entity.Message;
import by.bsu.chat.report.Report;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.FileNotFoundException;

/**
 * Created by jenia on 16.2.16.
 */
public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    static {
        new DOMConfigurator().doConfigure("log4j.xml", org.apache.log4j.LogManager.getLoggerRepository());
    }
    public static void main(String[] args){
        try {
            Creator creator = new Creator();
            Message message = creator.createMessage("input.txt");
            Report report = new Report();
            report.messageToFile("output.txt", message);
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            e.printStackTrace();
        }
        LOG.info("info");
    }
}