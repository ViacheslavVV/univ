package by.bsu.chat.logic;

import by.bsu.chat.entity.Message;

import java.util.List;

public class MessageAction {
    public boolean removeMessage(int id, List<Message> list) {
        int i = -1;
        for (Message message : list) {
            if (message.getId() == id) {
                i = list.indexOf(message);
                break;
            }
        }
        if (i == -1) {
            return false;
        } else {
            list.remove(i);
            return true;
        }
    }
}
