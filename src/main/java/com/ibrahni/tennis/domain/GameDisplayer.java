package com.ibrahni.tennis.domain;

import java.util.Map;

import com.ibrahni.tennis.domain.score.ScoreValue;

public interface GameDisplayer {

    void displayScore(final Map<Player, ScoreValue> score);

    void displayWinner(final Player player);
}
