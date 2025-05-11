package domain.rules;

import domain.model.Board;

public interface GameRule
{
    boolean isApplicable (Board board);
}
