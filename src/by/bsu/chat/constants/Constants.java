package by.bsu.chat.constants;

public final class Constants {
    public static final int MAX_LENGTH = 140;

    public static String moreThan140() {
        return "message length > 140";
    }

    public static String menuString() {
        return "Choose you destiny\n" +
                "1 write text\n" +
                "2 exit\n" +
                "3 view history\n" +
                "4 remove by id\n" +
                "5 author search\n" +
                "6 regex search\n" +
                "7 lexeme search\n" +
                "8 period search";
    }

    public static String numberFormatString() {
        return "You entered not a number";
    }

    public static String illegalCaseString() {
        return "illegal case";
    }

    public static String outFileString() {
        return "output.json";
    }

    public static String enterIdString() {
        return "Enter id of removing message";
    }

    public static String enterMessageString() {
        return "Enter your message";
    }

    public static String deleteIdSuccessString() {
        return "success: message deleted by id";
    }

    public static String startApplication() {
        return "start application";
    }

    public static String exitApplication() {
        return "exit application";
    }
}
