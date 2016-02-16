package by.bsu.chat.action;

import by.bsu.chat.entity.Message;

/**
 * Created by jenia on 16.02.16.
 */
public interface MessageAction {
    Message send();
    Message receive();
}