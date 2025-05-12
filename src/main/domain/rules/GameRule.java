package main.domain.rules;

import main.domain.model.Board;

public interface GameRule
{
    boolean isApplicable (Board board);
}
