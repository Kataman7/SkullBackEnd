package main.adapters.out.broadcaster;

import main.application.port.out.GameStateBroadcaster;

public class InMemoryBroardCaster implements GameStateBroadcaster
{
    private String message;

    @Override
    public void broadcast(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
