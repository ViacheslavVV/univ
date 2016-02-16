package by.bsu.chat.report;

import by.bsu.chat.entity.Message;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by jenia on 16.02.16.
 */
public class Report {
    public void messageToFile(String filename, Message message) throws FileNotFoundException{
        PrintStream printStream = new PrintStream(filename);
        printStream.print(message);
        printStream.close();
    }
}