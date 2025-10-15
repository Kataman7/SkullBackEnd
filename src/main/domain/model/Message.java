package main.domain.model;

import javax.json.Json;
import javax.json.JsonObject;

public class Message implements Model {
    private final Player expeditor;
    private final String content;
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

    @Override
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("expeditor", expeditor.toJson())
                .add("content", content)
                .build();
    }
}
