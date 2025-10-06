package main.domain.model;

import java.util.ArrayList;

public class Chat {
    private ArrayList<Message> messages;

    public Chat() {
        this.messages = new ArrayList<Message>();
    }
    public ArrayList<Message> getMessages() {
        return messages;
    }
    public void addMessage(Message message) {
        this.messages.add(message);
    }


}
