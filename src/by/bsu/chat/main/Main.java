package by.bsu.chat.main;

import by.bsu.chat.logic.MessageAction;
import by.bsu.chat.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.*;
import java.util.NoSuchElementException;
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
            MessageAction messageAction = new MessageAction();
            messageAction.process();

        } catch (IllegalCaseException e) {
            e.printStackTrace();
            System.err.println("Illegal case");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.err.println("No such element");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Io exception");
        }
        //LOG.info("info");
    }
}