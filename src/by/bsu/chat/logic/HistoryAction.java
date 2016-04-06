package by.bsu.chat.logic;

import by.bsu.chat.entity.Message;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HistoryAction {
    public void printMessages(Collection<Message> messages) {
        if (!messages.isEmpty()) {
            messages.forEach(System.out::println);
        } else {
            System.out.println("History is empty");

        }

    }
    public boolean removeMessage(int id, Collection<Message> messages) {
        Iterator<Message> iterator = messages.iterator();
        Message message;
        while (iterator.hasNext()) {
            message = iterator.next();
            if (message.getId() == id) {
                return messages.remove(message);
            }
        }
        return false;
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

    public Collection<String> regexSearch(String regex, Collection<Message> messages) {
        Collection<String> deque = new ArrayDeque<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        for (Message message : messages) {
            matcher = pattern.matcher(message.getMessage());
            while (matcher.find()) {
                deque.add(matcher.group());
            }
        }
        return deque;
    }

    /*public List<Message> lexemeSearch(String lexeme, List<Message> messages) {
        List<Message> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(lexeme);
        Matcher matcher;
        for (Message message : messages) {
            matcher = pattern.matcher(message.getMessage());
            if (matcher.find()) {
                list.add(message);
            }
        }
        return list;
    }*/
}
