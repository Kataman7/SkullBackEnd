package main.domain.model;

import main.domain.enums.CardType;

import java.util.*;

public class Player {

    private final String name;
    private final List<CardType> hand;
    private final Deque<CardType> deck;
    private boolean isSkiping;
    private boolean isDead;
    private int score;
    private int winsCount;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
        hand.add(CardType.SKULL);
        for (int i = 0; i < 3; i++)
            hand.add(CardType.FLOWER);
        deck = new ArrayDeque<>();
        isSkiping = false;
        isDead = false;
        score = 0;
        winsCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getDeckSize() {
        return deck.size();
    }

    public int getHandSize() { return hand.size(); }

    public void drawCard(int index) {
        deck.push(hand.remove(index));
    }

    public CardType pickCard(Player player) {
        CardType card = player.deck.removeFirst();
        player.hand.add(card);
        return card;
    }

    //compare uniquement le nom lors des égalités
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}