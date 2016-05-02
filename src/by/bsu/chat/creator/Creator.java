package by.bsu.chat.creator;

import by.bsu.chat.entity.Login;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Creator {
    private static final Logger LOG = Logger.getLogger(Creator.class);
    public Login createLogin(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            return new Login(scanner.next());

        } catch (FileNotFoundException e) {
            System.err.println("file " + filename + "didn't find");
            e.printStackTrace();
            LOG.error("file " + filename + "didn't find", e);
            System.exit(1);
        }
        return new Login();
    }
}
