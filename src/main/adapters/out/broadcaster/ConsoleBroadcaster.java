package main.adapters.out.broadcaster;

import main.application.port.out.GameStateBroadcaster;

public class ConsoleBroadcaster implements GameStateBroadcaster {
    @Override
    public void broadcast(String message) {
        System.out.println(message);
    }
}