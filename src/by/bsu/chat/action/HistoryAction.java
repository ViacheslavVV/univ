package by.bsu.chat.action;

import by.bsu.chat.entity.Message;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HistoryAction {
    public void printMessages(Collection<Message> messages) {
        if (messages.isEmpty()) {
            System.out.println("History is empty");
            return;
        }
        for (Message message : messages) {
            System.out.println(message);
            System.out.println();
        }
    }

    public boolean removeById(int id, Collection<Message> messages) {
        Collection<Message> newMessages = new ArrayDeque<>();
        for (Message message : messages) {
            if (message.getId() != id) {
                newMessages.add(message);
            }
        }

        return true;
        /*Iterator<Message> iterator = messages.iterator();
        Message message;
        while (iterator.hasNext()) {
            message = iterator.next();
            if (message.getId() == id) {
                return messages.remove(message);
            }
        }
        return f;*/
    }

    public Collection<Message> authorSearch(String author, Collection<Message> messages) {
        Collection<Message> deque = new ArrayDeque<>();
        for (Message message : messages) {
            if (message.getAuthor().equals(author)) {
                deque.add(message);
            }
        }
        return deque;
    }

    public Collection<Message> regexSearch(String regex, Collection<Message> messages) {
        Collection<Message> deque = new ArrayDeque<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for (Message message : messages) {
            matcher = pattern.matcher(message.getMessage());
            if (matcher.find()) {
                deque.add(message);
            }
        }
        return deque;
    }

    public Collection<Message> lexemeSearch(String lexeme, Collection<Message> messages) {
        return regexSearch(lexeme, messages);
    }
}
