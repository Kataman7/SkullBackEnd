package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Message;
import main.domain.rules.ValidPlayerRule;

import java.util.List;

public class AddMessageEvent extends GameEvent{

    private Message message;
    public AddMessageEvent(Message message) {
        this.message = message;
        super.getRules().addAll(List.of(new ValidPlayerRule(message.getExpeditor().getName())));
    }


    @Override
    public void apply(Board board) {
        board.getChat().addMessage(message);

    }

    @Override
    public String toJson() {
        return "";
    }
}
