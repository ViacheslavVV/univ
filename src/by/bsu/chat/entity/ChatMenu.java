package by.bsu.chat.entity;

public class ChatMenu {
    private String string;
    public ChatMenu() {
        string = "Choose you destiny\r\n1 write message\r\n2 exit\r\n" +
                "3 view history\r\n4 remove by id\r\n5 save to file";
    }
    public String toString() {
        return string;
    }
}