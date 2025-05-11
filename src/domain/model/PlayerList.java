package domain.model;

import infrastructure.utils.CircularList;

public class PlayerList extends CircularList<Player>
{
    public Player getByName(String name)
    {
        return super.items.stream()
                .filter(player -> player.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
