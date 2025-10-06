package main.domain.model;

public class Message {
    private Player expeditor;
    private String content;
    public Message(Player expeditor, String content) {
        this.expeditor = expeditor;
        this.content = content;
    }
    public Player getExpeditor() {
        return expeditor;
    }
    public String getContent() {
        return content;
    }

}
